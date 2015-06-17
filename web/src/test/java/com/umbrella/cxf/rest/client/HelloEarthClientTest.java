package com.umbrella.cxf.rest.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ���� on 14-11-23.
 * REST �ͻ���
 * ʹ�� http �ķ�ʽ(Apache httpcomponents-client)���� REST �����
 */
public class HelloEarthClientTest {
    @Test
    public void test1() {
        CloseableHttpClient http = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/rs/helloEarth/user/tom");
        try {
            CloseableHttpResponse resp = http.execute(httpGet);
            HttpEntity entity = resp.getEntity();
            InputStream is = entity.getContent();
            byte[] arr = new byte[1024];
            int i = -1;
            StringBuilder res = new StringBuilder();
            while ((i=is.read(arr))!=-1) {
                res.append(new String(arr, 0, i));
            }
            System.out.println(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        CloseableHttpClient http = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/rs/helloEarth/student/1");
        try {
            CloseableHttpResponse resp = http.execute(httpGet);
            HttpEntity entity = resp.getEntity();
            InputStream is = entity.getContent();
            byte[] arr = new byte[1024];
            int i = -1;
            StringBuilder res = new StringBuilder();
            while ((i=is.read(arr))!=-1) {
                res.append(new String(arr, 0, i));
            }
            System.out.println(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        CloseableHttpClient http = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/rs/helloEarth/search?stuName=lucy");
        try {
            CloseableHttpResponse resp = http.execute(httpGet);
            HttpEntity entity = resp.getEntity();
            InputStream is = entity.getContent();
            byte[] arr = new byte[1024];
            int i = -1;
            StringBuilder res = new StringBuilder();
            while ((i=is.read(arr))!=-1) {
                res.append(new String(arr, 0, i));
            }
            System.out.println(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
