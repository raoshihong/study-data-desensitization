package com.daoyuan.study.data.desensitization;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Computer implements Serializable {
    private String name;
    private Double price;
}
