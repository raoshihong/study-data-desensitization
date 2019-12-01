package com.daoyuan.study.data.desensitization.utils;

import com.alibaba.fastjson.JSON;
import com.daoyuan.study.data.desensitization.domain.Algorithm;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class AlgorithmsUtils {
    public static List<Algorithm> load() throws Exception{
        InputStream is = AlgorithmsUtils.class.getClassLoader().getResourceAsStream("algorithms.json");
        int length = -1;
        byte[] buff = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while ((length = is.read(buff))!=-1){
            stringBuffer.append(new String(buff,0,length));
        }

        return JSON.parseArray(stringBuffer.toString(),Algorithm.class);
    }

    public static Algorithm getAlgorithm(String algorithmId)throws Exception{
        List<Algorithm> algorithms = load();
        Optional<Algorithm> algorithmOptional = algorithms.stream().filter(algorithm -> algorithm.getId().equals(algorithmId)).findAny();
        return algorithmOptional.isPresent()?algorithmOptional.get():null;
    }
}
