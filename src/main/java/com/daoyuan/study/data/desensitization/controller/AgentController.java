package com.daoyuan.study.data.desensitization.controller;

import com.daoyuan.study.data.desensitization.dto.Agent;
import com.daoyuan.study.data.desensitization.vo.AgentVo;
import com.daoyuan.study.data.desensitization.vo.ChannelVo;
import com.daoyuan.study.data.desensitization.vo.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AgentController {

    @PostMapping(value = "/v1/agent/get")
    public ResponseVo get(@RequestBody Agent agent){
        AgentVo agentVo = new AgentVo();
        agentVo.setName("asfasdf");
        agentVo.setMobile("13824411467");
        agentVo.setCnid("431022199010198776");
        return new ResponseVo(agentVo);
    }

    @PostMapping(value = "/v1/agent/list")
    public ResponseVo list(){
        List<AgentVo> agentVos = new ArrayList<>();
        AgentVo agentVo = new AgentVo();
        agentVo.setName("asfasdf");
        agentVo.setMobile("13824411467");
        agentVo.setCnid("431022199010198776");

        agentVos.add(agentVo);

        AgentVo agentVo1 = new AgentVo();
        agentVo1.setName("asfasdf");
        agentVo1.setMobile("13824411467");
        agentVo1.setCnid("431022199010198776");

        agentVos.add(agentVo1);

        return new ResponseVo(agentVos);
    }

    @GetMapping(value = "/v1/agent/detail")
    public AgentVo detail(){
        AgentVo agentVo = new AgentVo();
        agentVo.setName("asfasdf");
        agentVo.setMobile("13824411467");
        agentVo.setCnid("431022199010198776");
        return agentVo;
    }

    @GetMapping(value = "/v1/agent/getChannel")
    public ResponseVo getChannel(){
        List<AgentVo> agentVos = new ArrayList<>();
        AgentVo agentVo = new AgentVo();
        agentVo.setName("asfasdf");
        agentVo.setMobile("13824411467");
        agentVo.setCnid("431022199010198776");

        agentVos.add(agentVo);

        AgentVo agentVo1 = new AgentVo();
        agentVo1.setName("asfasdf");
        agentVo1.setMobile("13824411467");
        agentVo1.setCnid("431022199010198776");

        agentVos.add(agentVo1);

        ChannelVo channelVo = new ChannelVo();
        channelVo.setAgentVos(agentVos);
        channelVo.setName("aaaa");

        return new ResponseVo(channelVo);
    }

}
