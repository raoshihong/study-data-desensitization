package com.daoyuan.study.data.desensitization.interceptors;

import com.alibaba.fastjson.JSON;
import com.daoyuan.study.data.desensitization.converter.EncodeSensitivyConverter;
import com.daoyuan.study.data.desensitization.converter.SensitivyConverter;
import com.daoyuan.study.data.desensitization.domain.RequestInfo;
import com.daoyuan.study.data.desensitization.vo.ResponseVo;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class DesenitizationInterceptor{

    private static final String REGXSTR = "@(org.springframework.web.bind.annotation.GetMapping || org.springframework.web.bind.annotation.PostMapping || org.springframework.web.bind.annotation.PutMapping || org.springframework.web.bind.annotation.DeleteMapping || org.springframework.web.bind.annotation.PatchMapping || org.springframework.web.bind.annotation.RequestMapping)";


    @Around("execution("+REGXSTR+" * *(..)))")
    public Object interceptor(ProceedingJoinPoint pjp)throws Throwable{

        Object[] args = pjp.getArgs();

        //在这块拦截后，解析调用方法前后数据
        //调用方法前参数进行解码
            //目标方法的调用
        Object response = pjp.proceed(args);
        //调用方法后响应数据进行编码
        //对结果集进行编码
        return desenitization(response);
    }

    public Object desenitization(Object response)throws Exception{
        //拦截所有的方法
        //判断拦截对url是否配置了需要脱敏,没有则直接跳过,有则需要进行脱敏规则处理

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = servletRequestAttributes.getRequest();
        String appId = getAppId(request.getContextPath());
        String uri = request.getRequestURI();
        String requestMethod = request.getMethod().toUpperCase();

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setAppId(appId);
        requestInfo.setUrl(uri);
        requestInfo.setMethod(requestMethod);
        //TODO 从请求头里获取
        String showSource = request.getHeader("Show-Source");

        requestInfo.setShowSource("true".equals(showSource)?true:false);

        //进行字段都匹配,匹配到的字段进行脱敏处理,这里采用path进行处理
        SensitivyConverter sensitivyConverter = new EncodeSensitivyConverter();

        Object result = response;
        if(response instanceof ResponseVo){
            ResponseVo responseVo = ((ResponseVo)response);
            result = responseVo.getResult();

            responseVo.setResult(sensitivyConverter.converter(requestInfo, result));
            return responseVo;
        }

        //进行字段对匹配
//        if () {//如果是直接所有字段都脱敏怎进入这里直接处理
//        }else{//如果是指定那些字段进行脱敏
//        }

        return sensitivyConverter.converter(requestInfo, result);
    }

    private String getAppId(String contextPath){
        return Splitter.on("/").omitEmptyStrings().splitToList(contextPath).get(0);
    }

}
