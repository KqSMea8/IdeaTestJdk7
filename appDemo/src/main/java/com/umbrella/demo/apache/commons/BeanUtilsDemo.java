package com.umbrella.demo.apache.commons;

import com.umbrella.demo.apache.commons.vo.Friend;
import com.umbrella.demo.apache.commons.vo.User1;
import com.umbrella.demo.apache.commons.vo.User2;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xudazhou on 2015/8/27.
 */
public class BeanUtilsDemo {

    private static final Logger log = LoggerFactory.getLogger(BeanUtilsDemo.class);

    /**
     * java.lang.IllegalArgumentException: No destination bean specified
     * 赋值目标对象不能为 null
     */
    @Test
    public void test1() {
        User1 user1 = new User1();
        user1.setId(1L);
        user1.setName("tom");
        User2 user2 = null;
        try {
            BeanUtils.copyProperties(user2, user1);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (InvocationTargetException e) {
            log.error("", e);
        }
        System.out.println(user2.getId());
    }

    /**
     * User1 User2 不能是内部类
     * 如果Date成员变量不是null，可以转换Date类型
     * 可以复制对象中的对象，源类成员变量=null，则目标类成员变量也是null，比如 Friend
     * 忽略名称不相同的属性
     * 对于名称相同，类型不同的属性，会根据能否转换进行转换，比如
     *     String 不能赋给 Integer
     *     Long  的长度超过Integer，不以赋给 Integer，否则可以
     * 但是：
     * 当源Date类型成员变量 =null 时，抛异常 org.apache.commons.beanutils.ConversionException: No value specified for 'Date'
     * 当源BigDecimal类型成员变量 =null 时，抛异常 org.apache.commons.beanutils.ConversionException: No value specified for 'BigDecimal'
     */
    @Test
    public void test2() {
        User1 user1 = new User1();
        user1.setId(1L);
        user1.setName("tom");
        user1.setAge(2);
        user1.setBirth(new Date());
        Friend friend = new Friend();
        friend.setId(2L);
        friend.setName("jim");
        user1.setFriend(friend);
        user1.setHomeAddress("山东滕州");
        user1.setScore("abc");
        user1.setEnrollTime(new Date()); // 字段是null，抛异常
        user1.setScore1(2147483648L); // 值大于 Integer.MAX_VALUE

        User2 user2 = new User2();
        try {
            BeanUtils.copyProperties(user2, user1);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (InvocationTargetException e) {
            log.error("", e);
        } catch (Exception e) {
            log.error("", e);
        }
        System.out.println(user2);
    }

    /**
     * 处理 源Date是null的情况
     */
    @Test
    public void test3() {
        User1 user1 = new User1();
        user1.setAge(2);
        user1.setBirth(new Date());
        user1.setHomeAddress("山东滕州");
        user1.setScore1(83648L);

        User2 user2 = new User2();

        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class aClass, Object o) {
                if(o==null) return null;

                // 下面的写法会抛异常
//                String str = (String)o; // java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                try {
//                    return sdf.parse(str);
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }

                return o;
            }
        }, Date.class);

        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class aClass, Object o) {
                if(o==null) return o;
                return o;
            }
        }, BigDecimal.class);

        try {
            BeanUtils.copyProperties(user2, user1);
        } catch (IllegalAccessException e) {
            log.error("", e);
        } catch (InvocationTargetException e) {
            log.error("", e);
        } catch (Exception e) {
            log.error("", e);
        }
        System.out.println(user2);
    }

}
