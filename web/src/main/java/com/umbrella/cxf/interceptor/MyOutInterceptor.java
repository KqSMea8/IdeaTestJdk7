package com.umbrella.cxf.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ���� on 14-11-25.
 */
public class MyOutInterceptor extends AbstractPhaseInterceptor<Message> {
    public MyOutInterceptor(String phase) {
        super(phase);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        /*
         * http ͷ��Ϣ���������Map��Map ��ֵ�� List
         * �����ڻ�ȡ���ListԪ��ʱ������Ԫ�ض����ڵ�һ��λ�ã��� list.get(0)�����Զ��Ÿ���
         */
        Map map = new HashMap();
        List<String> list = new ArrayList<String>();
        list.add("l1");
        list.add("l2");
        map.put("k1", list);
        message.put(Message.PROTOCOL_HEADERS, map);

        // ���������ַ�ʽ������Ϣ��������ò���
//        message.put("k1", "������Ҫ�������Ϣ");
    }
}
