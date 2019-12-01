package com.daoyuan.study.data.desensitization.algorithm.javaalgorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component(value = "cnidAlgorithm")
public class CnidAlgorithm implements JavaAlgorithm<String> {
    @Override
    public String algorithm(Algorithm algorithm, String source) {
        if (Objects.nonNull(source)) {
            source = source.substring(0,7)+"*****"+source.substring(13,18);
        }
        return source;
    }
}
