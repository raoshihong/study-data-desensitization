package com.daoyuan.study.data.desensitization;

import com.alibaba.fastjson.JSON;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.MapFunction;
import net.minidev.json.JSONArray;

import java.io.InputStream;
import java.util.List;

public class TestJsonPath {

    public static void main(String[] args) {
        InputStream is = TestJsonPath.class.getClassLoader().getResourceAsStream("books.json");
        DocumentContext documentContext = JsonPath.parse(is);

        Object obj = documentContext.read("$.store.book[?(@.isbn)].author");

        System.out.println(obj);

        obj = documentContext.read("$.store");

        System.out.println(obj instanceof Object);

        obj = documentContext.read("$.store.book[*].bb[*].name");

        System.out.println(obj instanceof JSONArray);

        obj = documentContext.read("$..name");

        System.out.println(obj instanceof JSONArray);

        obj = documentContext.read("$..price");

        System.out.println(obj instanceof com.alibaba.fastjson.JSONArray);

        obj = documentContext.read("$.store.book[0].author");

        System.out.println(obj);

        obj = documentContext.read("$.store.book[0].price");

        System.out.println(obj);

        obj = documentContext.read("$.expensive");

        System.out.println(obj);

        obj = documentContext.read("$.isFlag");

        System.out.println(obj);

        obj = documentContext.read("$.store.book[*]");

        System.out.println(obj);

        String data = documentContext.map("$.store.book[*]", new MapFunction() {
            @Override
            public Object map(Object currentValue, Configuration configuration) {
                return "ff";
            }
        }).jsonString();

        System.out.println(data);

        is = TestJsonPath.class.getClassLoader().getResourceAsStream("computers.json");
        documentContext = JsonPath.parse(is);

        obj = documentContext.read("$");

        System.out.println(data);

        System.out.println(obj);

        obj = documentContext.read("$.[*].name");

        System.out.println(obj);

        obj = documentContext.read("$..name");

        System.out.println(obj);

        List<String> list = (List)obj;

        System.out.println(list);


        data = documentContext.map("$..name", new MapFunction() {
            @Override
            public Object map(Object currentValue, Configuration configuration) {
                return "aa";
            }
        }).jsonString();

        System.out.println(data);


        Computer computer = new Computer();
        computer.setName("aa");
        computer.setPrice(10.0);

//        String json = JSON.toJSONString(computer);

        documentContext = JsonPath.parse(computer);

        obj = documentContext.read("$.name");

        System.out.println(obj);
    }

}
