package com.umbrella.cxf.ws.client.nospring;

import com.umbrella.cxf.interceptor.MyOutInterceptor;
import com.umbrella.cxf.ws.server.HelloWorldService;
import com.umbrella.ws.model.User;
import com.umbrella.ws.model.Users;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.Phase;
import org.junit.Test;

/**
 * Created by ���� on 14-11-22.
 * ��ʹ�� Spring ,ֱ��ʹ�� CXF
 */
public class HelloWorldClientTest {
    @Test
    public void test1() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getOutInterceptors().add(new MyOutInterceptor(Phase.SEND));
        factory.setServiceClass(HelloWorldService.class);
        factory.setAddress("http://localhost:9999/ws/helloWorld");

        HelloWorldService client = (HelloWorldService)factory.create();

        // ���� String
//        System.out.println(client.sayHello("Jim"));

        // ���ض���
//        User u1 = client.getUser("Tom");
//        System.out.println(u1);

        // ���� ���Ӷ���
        Users users = client.getUserList();
        for(User u : users.getUserList()) {
            System.out.format("%s-%s\n", u.getUserName(), u.getAge());
        }
    }
}
