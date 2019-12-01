package com.daoyuan.study.data.desensitization.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ChannelVo {
    private String name;
    private List<AgentVo> agentVos;
}
