package com.daoyuan.study.data.desensitization.converter;

import com.daoyuan.study.data.desensitization.domain.RequestInfo;

public interface SensitivyConverter {
    Object converter(RequestInfo info, Object response);
}
