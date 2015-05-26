package com.umbrella.service;

import org.springframework.stereotype.Service;

/**
 * Created by ���� on 14-12-25.
 * ��֤ ������ã�ʹ�� Spring ע��᲻����ѭ����
 * ����
 */
@Service
public class HelloWorldService {
    // ������ã�������ѭ��
    private HelloEarthService helloEarthService;

    public HelloWorldService() {
        System.out.println("this is HelloWorldService()");
    }

    public void sayHello() {
        System.out.println("Hello World Service");
    }

    public void setHelloEarthService(HelloEarthService helloEarthService) {
        this.helloEarthService = helloEarthService;
    }
}
