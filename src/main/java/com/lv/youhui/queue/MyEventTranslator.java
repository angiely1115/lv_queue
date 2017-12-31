package com.lv.youhui.queue;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

public class MyEventTranslator implements EventTranslator<MyEvent> {
    private MyEvent myEvent;//数据构造

    public MyEventTranslator(MyEvent myEvent) {
        this.myEvent = myEvent;
    }

    @Override
    public void translateTo(MyEvent event, long sequence) {
        event.setMyEvent(myEvent);
    }

}