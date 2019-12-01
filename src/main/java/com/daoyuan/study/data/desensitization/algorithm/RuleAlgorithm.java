package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;

public interface RuleAlgorithm {
    Object algorithm(Algorithm algorithm,Object source);
}
