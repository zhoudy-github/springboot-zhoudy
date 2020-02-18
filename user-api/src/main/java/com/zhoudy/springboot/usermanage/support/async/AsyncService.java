package com.zhoudy.springboot.usermanage.support.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    public Integer execute01(){
        log.info("[execute01]");
        sleep(10);
        return 1;
    }

    public Integer execute02(){
        log.info("[execute02]");
        sleep(5);
        return 2;
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public Integer execute01Async() {
        return this.execute01();
    }

    @Async
    public Integer execute02Async() {
        return this.execute02();
    }


    /***
     * 两个方法只是发布异步调用，并未执行完成。在一些业务场景中，
     * 我们希望达到异步调用的效果，同时主线程阻塞等待异步调用的结果。
     */
    @Async
    public Future<Integer> execute01AsyncWithFuture(){
        return AsyncResult.forValue(this.execute01());
    }

    @Async
    public Future<Integer> execute02AsyncWithFuture(){
        return AsyncResult.forValue(this.execute02());
    }

    @Async
    public ListenableFuture<Integer> execute01AsyncWithListenableFuture(){
        try {
            return AsyncResult.forValue(this.execute02());
        } catch (Throwable e) {
            return AsyncResult.forExecutionException(e);
        }
    }

    @Async
    public Integer executeExcception(Integer a,Integer b){
        throw new RuntimeException("抛出一个异常");
    }

}
