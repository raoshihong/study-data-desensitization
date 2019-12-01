package com.daoyuan.study.data.desensitization.converter.jsonpath;

import com.daoyuan.study.data.desensitization.algorithm.RuleAlgorithmFactory;
import com.daoyuan.study.data.desensitization.domain.Algorithm;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.MapFunction;
import net.minidev.json.JSONArray;

import java.util.Objects;

public class JsonPathMapFunction implements MapFunction {

    private Algorithm algorithm;
    private String dataJson;

    public JsonPathMapFunction(Algorithm algorithm, String dataJson) {
        this.algorithm = algorithm;
        this.dataJson = dataJson;
    }

    @Override
    public Object map(Object currentValue, Configuration configuration) {
        Object value = currentValue;
        if(Objects.nonNull(currentValue)){
            if (currentValue instanceof JSONArray){
                //遍历数组
            } else if(currentValue instanceof String){
                //对数据进行编码处理

                RuleAlgorithmFactory ruleAlgorithmFactory = new RuleAlgorithmFactory();
                value = ruleAlgorithmFactory.build(this.algorithm,currentValue);
            }
        }
        return value;
    }
}
