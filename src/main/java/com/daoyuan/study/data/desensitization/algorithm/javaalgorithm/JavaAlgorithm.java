package com.daoyuan.study.data.desensitization.algorithm.javaalgorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;

public interface JavaAlgorithm<T> {
    T algorithm(Algorithm algorithm, T source);
}
