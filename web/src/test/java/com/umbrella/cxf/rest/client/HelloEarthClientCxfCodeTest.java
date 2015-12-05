package com.umbrella.cxf.rest.client;

import com.umbrella.cxf.interceptor.MyOutInterceptor;
import com.umbrella.cxf.rest.service.HelloEarthService;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.phase.Phase;
import org.junit.Test;

/**
 * Created by ���� on 14-11-23.
 * ���� ʵ�� REST �ͻ���
 */
public class HelloEarthClientCxfCodeTest {
    @Test
    public void test1() {
        JAXRSClientFactoryBean factory = new JAXRSClientFactoryBean();
        // ���������쳣
//        factory.getOutInterceptors().add(new MyOutInterceptor(Phase.SEND));
        factory.setServiceClass(HelloEarthService.class);
        factory.setAddress("http://localhost:9999/ws/helloEarth");
        HelloEarthService service = (HelloEarthService)factory.create();
        System.out.println(service.getStudentById(1));
    }

}