package com.daoyuan.study.data.desensitization.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AppRule {
    //指定那个应用app,如果是default则表示采用默认的规则
    private String appId;
    //指明这个应用下对规则类型,是全部脱敏all,还是部分脱敏part
    private String ruleType;
    //指明app下那些url请求需要进行脱敏处理
    private List<UrlRule> urlRules;
}
