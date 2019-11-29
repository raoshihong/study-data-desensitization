package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;
import org.springframework.stereotype.Component;

@Component("mobileRuleAlgorithm")
public class MobileRuleAlgorithm implements RuleAlgorithm {
    @Override
    public String algorithm(Algorithm algorithm, String source) {
        return "这是编码后的";
    }
}
