package com.umbrella.service;

import org.springframework.stereotype.Service;

/**
 * Created by ���� on 14-12-25.
 * ��֤ ������ã�ʹ�� Spring ע��᲻����ѭ����
 * ����
 */
@Service
public class HelloEarthService {
    private HelloWorldService helloWorldService;

    public HelloEarthService() {
        System.out.println("this is HelloEarthService()");
    }

    public void sayHello() {
        System.out.println("Hello Earth Service");
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
