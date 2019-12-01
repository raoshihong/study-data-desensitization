package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;

/**
 * 根据算法类型,调用不同算法处理器
 */
public class RuleAlgorithmFactory {
    public Object build(Algorithm algorithm,Object sourceData){
        if ("java".equals(algorithm.getType())) {//根据不同类型的算法处理器来处理具体的算法
            //处理算法
            JavaRuleAlgorithm javaRuleAlgorithm = new JavaRuleAlgorithm();
            return javaRuleAlgorithm.algorithm(algorithm,sourceData);
        }else if("groovy".equals(algorithm.getType())){
            GroovyRuleAlgorithm groovyRuleAlgorithm = new GroovyRuleAlgorithm();
            return groovyRuleAlgorithm.algorithm(algorithm,sourceData);
        }else if("javascript".equals(algorithm.getType())){
            JavascriptRuleAlgorithm javascriptRuleAlgorithm = new JavascriptRuleAlgorithm();
            return javascriptRuleAlgorithm.algorithm(algorithm,sourceData);
        }else {
            return sourceData;
        }
    }
}
