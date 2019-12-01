package com.daoyuan.study.data.desensitization.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据规则
 */
@Setter
@Getter
public class DataRule {
    //数据规则类型
    private String type;
    //数据字段名路径
    private String filedNamePath;
    //数据规则对应对算法id
    private String algorithmId;
}
