package com.daoyuan.study.data.desensitization.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseVo<T> {
    private String code;
    private String message;
    private T result;

    public ResponseVo() {
    }

    public ResponseVo(T result) {
        this.result = result;
    }
}
