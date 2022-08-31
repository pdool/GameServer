package com.xin.mgr;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Parser;
import com.xin.core.HandlerAnno;
import com.xin.handler.AbsHandler;
import com.xin.msg.login.SimpleMessage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MsgMgr implements ApplicationContextAware {
    public static Map<Integer, Parser> msgMap = new ConcurrentHashMap<>();
    public static Map<Integer, AbsHandler> handlerMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(HandlerAnno.class);
        for (Object value : beansWithAnnotation.values()) {
            AbsHandler handler = (AbsHandler) value;
            Class<? extends AbsHandler> aClass = handler.getClass();
            try {
                ParameterizedType superGenericSuperclass = (ParameterizedType) aClass.getGenericSuperclass();
                Class protoClass = (Class) superGenericSuperclass.getActualTypeArguments()[0];
                Method parser = protoClass.getMethod("parser");
                Parser invoke = (Parser) parser.invoke(null);
                HandlerAnno annotation = aClass.getAnnotation(HandlerAnno.class);
                int headId = annotation.headerId();

                msgMap.put(1, invoke);
                handlerMap.put(headId, handler);
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
