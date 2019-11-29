package com.daoyuan.study.data.desensitization.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 规则算法类
 */
@Setter
@Getter
public class Algorithm {
    //算法id
    private String id;
    //算法类型
    private String type;
    //具体算法,可以直接是正则表达式,也可以是js脚本,也可以是groovy脚本
    private String data;
    //是否启用
    private String state;
    //算法描述
    private String desc;
}
