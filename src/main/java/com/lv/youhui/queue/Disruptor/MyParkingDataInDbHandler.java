package com.lv.youhui.queue.Disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;  
  
/** 
 * Handler 第一个消费者，负责保存进场汽车的信息 
 * 
 */  
public class MyParkingDataInDbHandler implements EventHandler<MyInParkingDataEvent> , WorkHandler<MyInParkingDataEvent>{  
  
    @Override  
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent) throws Exception {  
        long threadId = Thread.currentThread().getId(); // 获取当前线程id  
        String carLicense = myInParkingDataEvent.getCarLicense(); // 获取车牌号  
        System.out.println(String.format("时间 %s Thread Id %s 保存 %s 到数据库中 ....",System.currentTimeMillis(), threadId, carLicense));
    }  
  
    @Override  
    public void onEvent(MyInParkingDataEvent myInParkingDataEvent, long sequence, boolean endOfBatch)  
            throws Exception {  
        this.onEvent(myInParkingDataEvent);
    }  
  
} 