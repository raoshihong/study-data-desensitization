package com.daoyuan.study.data.desensitization.algorithm.javaalgorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("nameAlgorithm")
public class NameAlgorithm implements JavaAlgorithm<String> {
    @Override
    public String algorithm(Algorithm algorithm, String source) {
        if (StringUtils.isNotEmpty(source)) {
            source = source.substring(0,1) + "**";
        }
        return source;
    }
}
