package com.xin.module;

import com.xin.core.HandlerAnno;
import com.xin.handler.AbsHandler;
import com.xin.msg.login.SimpleMessage;
import org.springframework.stereotype.Component;

@HandlerAnno(headerId = 123)
@Component
public class TestHandler extends AbsHandler<SimpleMessage,SimpleMessage> {
    @Override
    public SimpleMessage handle(SimpleMessage in) {
        return null;
    }
}
