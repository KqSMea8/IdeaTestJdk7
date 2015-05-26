package com.umbrella.cxf.rest.client;

import com.umbrella.ws.model.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created by ���� on 14-11-23.
 * REST �ͻ���
 * ʹ�� http �ķ�ʽ���� REST �����
 */
public class HelloEarthClientTest3 {

    @Test
    public void  test1() {
        WebClient client = WebClient.create("http://localhost:8080/rs");
        User u = client.path("helloEarth/user/tom").accept(MediaType.APPLICATION_XML).get(User.class);
        System.out.println(u);
    }
}
