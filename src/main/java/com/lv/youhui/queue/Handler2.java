package com.lv.youhui.queue;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

//第三个消费者
public class Handler2 implements EventHandler<MyEvent>, WorkHandler<MyEvent> {
//    private static final Logger log = LoggerFactory.getLogger(Handler2.class);

    @Override
    public void onEvent(MyEvent event) throws Exception {
//        log.debug(event.getName() + "====Handler2........");
        System.out.println(event.getName() + "====Handler2........");
        event.getCountDownLatch().countDown();
    }

    @Override
    public void onEvent(MyEvent event, long sequence, boolean endOfBatch)
            throws Exception {
        onEvent(event);
    }

}