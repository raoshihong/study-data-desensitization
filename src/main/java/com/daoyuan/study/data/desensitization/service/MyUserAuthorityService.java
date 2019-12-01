package com.daoyuan.study.data.desensitization.service;

import com.daoyuan.study.data.desensitization.author.UserAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserAuthorityService implements UserAuthorityService {
    @Override
    public boolean hashAuthor() {
        return true;
    }
}
