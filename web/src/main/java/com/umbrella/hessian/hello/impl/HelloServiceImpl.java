package com.umbrella.hessian.hello.impl;

import com.umbrella.hessian.hello.HelloService;

/**
 * Created by ���� on 14-12-19.
 * �ͻ��˵����� appDemo��
 */
public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl() {
        System.out.println("this is HelloServiceImpl");
    }

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
