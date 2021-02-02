package com.gjc.mybatisplus_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.mybatisplus_demo.entity.Test;
import com.gjc.mybatisplus_demo.mapper.TestMapper;
import com.gjc.mybatisplus_demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test>
        implements TestService {



}
