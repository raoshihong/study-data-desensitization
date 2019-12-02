package com.daoyuan.study.data.desensitization.algorithm;

import com.daoyuan.study.data.desensitization.domain.Algorithm;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;

public class JavascriptRuleAlgorithm implements RuleAlgorithm {

    private static final String FUNC = "sensitivy";

    @Override
    public Object algorithm(Algorithm algorithm, Object source) {

        //采用javascript引擎处理js代码
        String data = algorithm.getData();

        if (StringUtils.isNotEmpty(data)) {
            try {
                ScriptEngineManager engineManager = new ScriptEngineManager();
                ScriptEngine scriptEngine = engineManager.getEngineByName("javascript");
                //固定脚本函数名称,参数,返回值
                scriptEngine.eval(data);
                if (scriptEngine instanceof Invocable) {
                    Invocable invocable = (Invocable) scriptEngine;
                    List<Object> params = Lists.newArrayList();
                    params.add(source);
                    source = invocable.invokeFunction(FUNC,params);
                }
            }catch (Exception e){

            }
        }

        return source;
    }
}
