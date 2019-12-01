package com.daoyuan.study.data.desensitization.converter;

import com.alibaba.fastjson.JSON;
import com.daoyuan.study.data.desensitization.author.UserAuthorityService;
import com.daoyuan.study.data.desensitization.converter.jsonpath.JsonPathMapFunction;
import com.daoyuan.study.data.desensitization.domain.Algorithm;
import com.daoyuan.study.data.desensitization.domain.DataRule;
import com.daoyuan.study.data.desensitization.domain.RequestInfo;
import com.daoyuan.study.data.desensitization.domain.UrlRule;
import com.daoyuan.study.data.desensitization.utils.AlgorithmsUtils;
import com.daoyuan.study.data.desensitization.utils.AppRulesUtils;
import com.daoyuan.study.data.desensitization.utils.SpringContext;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 编码器
 */
public class EncodeSensitivyConverter implements SensitivyConverter{

//    @Autowired
//    UserAuthorityService userAuthorityService;

    @Override
    public Object converter(RequestInfo requestInfo, Object response) {
        String dataJson = JSON.toJSONString(response);
        try {
            UrlRule urlRule = AppRulesUtils.getUrlRule(requestInfo.getAppId(),requestInfo.getUrl(),requestInfo.getMethod());
            UserAuthorityService userAuthorityService = SpringContext.getBean(UserAuthorityService.class);
            if (Boolean.TRUE.equals(requestInfo.getShowSource())  //传递了要显示源码都请求
                    && urlRule.getGrantShowSource()   //先判断这个url是否有授权可以显示查看源码
                    && Objects.nonNull(userAuthorityService) && userAuthorityService.hashAuthor()) {//接着判断当前登录用户都角色是否有权限查看源码
               return response;
            }

            for (DataRule dataRule:urlRule.getDataRules()){
                String algorithmId = dataRule.getAlgorithmId();
                try{
                    Algorithm algorithm = AlgorithmsUtils.getAlgorithm(algorithmId);
                    if (Objects.nonNull(algorithm)) {
                        //可以在这里支持多种解码器,目前只支持一种jsonPath
                        DocumentContext documentContext = JsonPath.parse(dataJson);
                        dataJson = documentContext.map(dataRule.getFiledNamePath(),new JsonPathMapFunction(algorithm,dataJson)).jsonString();
                    }
                }catch (Exception e){

                }
            }

        }catch (Exception e){

        }

        return JSON.parseObject(dataJson,response.getClass());
    }
}
