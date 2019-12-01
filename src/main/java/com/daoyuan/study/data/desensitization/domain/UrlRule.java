package com.daoyuan.study.data.desensitization.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * url规则
 */
@Setter
@Getter
public class UrlRule {
    //指明是对哪个请求url下对数据进行脱敏
    private String url;
    //指明请求方式
    private String method;
    //授权这个接口支持源码查看
    private Boolean grantShowSource;
    //这个源码哪写角色可以查看
    private String userRole;
    //指明对数据对处理规则
    private List<DataRule> dataRules;
}
