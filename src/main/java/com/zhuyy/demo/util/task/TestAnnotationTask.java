package com.zhuyy.demo.util.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/6/15.
 */
@Component
public class TestAnnotationTask {

//    @Scheduled(cron = "5/3 * * * * ?")
    public void say() {
        System.out.println("=========say=========");
    }
//    @Scheduled(cron = "5/3 * * * * ?")
    public void hello() {
        System.out.println("=========hello=========");
    }
}
