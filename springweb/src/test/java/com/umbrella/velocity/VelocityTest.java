package com.umbrella.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;

import java.io.OutputStreamWriter;
import java.io.StringWriter;

/**
 * Created by ���� on 15-3-31.
 * Ĭ��ģ��ŵ�����Ŀ¼��
 */
public class VelocityTest {
    @Test
    public void test1() {
        // ģ��ŵ� resources(classpath)�£��������ֶ�����ִ��
//        Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "./springweb/target/test-classes");
//        Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "D:\\_idea\\TestApp\\springweb\\target\\test-classes");
        Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        Velocity.init();

        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");

//        System.out.println(Velocity.getProperty(Velocity.FILE_RESOURCE_LOADER_PATH)); // .
//        System.out.println(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()); // /D:/_idea/TestApp/springweb/target/test-classes/

        Template t = Velocity.getTemplate("hello.vm");

        StringWriter writer = new StringWriter();

        t.merge(context, writer);
        System.out.println(writer.toString());
    }
}
