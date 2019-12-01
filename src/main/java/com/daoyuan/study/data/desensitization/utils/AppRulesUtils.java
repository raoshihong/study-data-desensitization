package com.daoyuan.study.data.desensitization.utils;

import com.alibaba.fastjson.JSON;
import com.daoyuan.study.data.desensitization.domain.AppRule;
import com.daoyuan.study.data.desensitization.domain.DataRule;
import com.daoyuan.study.data.desensitization.domain.UrlRule;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AppRulesUtils {

    public static List<AppRule> load() throws Exception{
        InputStream is = AppRulesUtils.class.getClassLoader().getResourceAsStream("app_rules.json");
        int length = -1;
        byte[] buff = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while ((length = is.read(buff))!=-1){
            stringBuffer.append(new String(buff,0,length));
        }

        return JSON.parseArray(stringBuffer.toString(), AppRule.class);
    }

    public static AppRule getAppRule(String appId) throws Exception{
        List<AppRule> appRules = load();
        Optional<AppRule> appRuleOptional = appRules.stream().filter(appRule -> appRule.getAppId().equals(appId)).findFirst();

        return appRuleOptional.isPresent()?appRuleOptional.get():null;
    }

    public static UrlRule getUrlRule(String appId,String url,String method) throws Exception{
        AppRule appRule = getAppRule(appId);
        if (Objects.nonNull(appRule)) {
            Optional<UrlRule> urlRuleOptional = appRule.getUrlRules().stream().filter(urlRule -> urlRule.getUrl().equals(url) && urlRule.getMethod().equals(method)).findAny();
            UrlRule urlRule = urlRuleOptional.isPresent()?urlRuleOptional.get():null;
            return urlRule;
        }
        return null;
    }
}
