package com.daoyuan.study.data.desensitization.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestInfo {
    private String appId;
    private String url;
    private String method;
    private Boolean showSource;
}
