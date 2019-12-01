package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.algorithm.javaalgorithm.JavaAlgorithm;
import com.daoyuan.study.data.desensitization.domain.Algorithm;
import com.daoyuan.study.data.desensitization.utils.SpringContext;
import org.apache.commons.lang3.StringUtils;

public class JavaRuleAlgorithm implements RuleAlgorithm{
    @Override
    public Object algorithm(Algorithm algorithm, Object source) {
        //根据data去处理
        String data = algorithm.getData();
        if (StringUtils.isNotEmpty(data)) {
            JavaAlgorithm javaAlgorithm = SpringContext.getBean(data, JavaAlgorithm.class);
            return javaAlgorithm.algorithm(algorithm,source);
        }
        return source;
    }
}
