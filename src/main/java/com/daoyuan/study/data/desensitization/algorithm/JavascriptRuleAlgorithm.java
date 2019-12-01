package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;

public class JavascriptRuleAlgorithm implements RuleAlgorithm {
    @Override
    public Object algorithm(Algorithm algorithm, Object source) {

        //采用javascript引擎处理js代码
        String data = algorithm.getData();

        return source;
    }
}
