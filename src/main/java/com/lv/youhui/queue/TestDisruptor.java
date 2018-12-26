package com.lv.youhui.queue;

import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

//单元测试类
public class TestDisruptor {
   /* private static final Logger log = LoggerFactory
            .getLogger(TestDisruptor.class);*/

    @Test
    public void myTest() throws Exception {
        Disruptor<MyEvent> disruptor = new Disruptor<MyEvent>(new MyEventFactory(),
                1024, Executors.defaultThreadFactory(),
                ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.setDefaultExceptionHandler(new MyHandlerException());
        //事件依次处理
        disruptor.handleEventsWithWorkerPool(new Handler1())
                .thenHandleEventsWithWorkerPool(new Handler11())
                .thenHandleEventsWithWorkerPool(new Handler2());
        disruptor.start();
        MyEventProduce ep = new MyEventProduce().setDisruptor(disruptor);
        CountDownLatch countDownLatch = ep.getCountDownLatch();
        new Thread(ep).start();
        //Executors.defaultThreadFactory();
        countDownLatch.await();
        disruptor.shutdown();
        System.out.println("运行完毕");

        long start2 = System.currentTimeMillis();
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            System.currentTimeMillis();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("currentTimeMillis Time:" + (end2 - start2) + "毫秒");



//        log.debug("运行完毕");
    }

  /*  public void testJDBC() throws Exception {

        Connection connection = DriverManager.getConnection("", "", "");

    }*/
}