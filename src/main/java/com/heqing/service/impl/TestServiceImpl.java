package com.heqing.service.impl;

import org.springframework.stereotype.Service;

import com.heqing.base.BaseDaoImpl;
import com.heqing.entities.Test;
import com.heqing.service.TestService;

@Service("testService")
public class TestServiceImpl extends BaseDaoImpl<Test> implements TestService {

}
