package com.lv.youhui.queue;

import com.lmax.disruptor.EventFactory;

//生产数据的工厂
public class MyEventFactory implements EventFactory<MyEvent> {

    @Override
    public MyEvent newInstance() {
        // TODO Auto-generated method stub
        return new MyEvent();
    }

}