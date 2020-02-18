package com.zhoudy.springboot.usermanage.async;

import com.zhoudy.springboot.usermanage.Application;
import com.zhoudy.springboot.usermanage.support.async.AsyncService;
import com.zhoudy.springboot.usermanage.support.async.autoexecution.AutoAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class AsyncTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void task01(){
        long now=System.currentTimeMillis();
        log.info("[task01][开始执行]");
        asyncService.execute01();
        asyncService.execute02();
        log.info("[task01][执行结束,消耗时长{}毫秒]",System.currentTimeMillis()-now);
    }

    @Test
    public void task02(){
        long now=System.currentTimeMillis();
        log.info("[task02][开始执行]");
        asyncService.execute01Async();
        asyncService.execute02Async();
        log.info("[task02][执行结束,消耗时长{}毫秒]",System.currentTimeMillis()-now);
    }

    /***
     * 异步执行，因为主线程阻塞等待执行结果，所以消耗 10 秒左右。
     * 当同时有多个异步调用，并阻塞等待执行结果，消耗时长由最慢的异步调用的逻辑所决定。
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void task03AsyncWithFuture() throws ExecutionException, InterruptedException {
        long now=System.currentTimeMillis();
        log.info("[task03][开始执行]");
        // <1> 执行任务
        Future<Integer> execute01Result = asyncService.execute01AsyncWithFuture();
        Future<Integer> execute02Result = asyncService.execute02AsyncWithFuture();
        //<2>阻塞等待结果
        log.info(""+execute01Result.get());
        log.info(""+execute02Result.get());
        log.info("[task03][执行结束,消耗时长{}毫秒]",System.currentTimeMillis()-now);
    }

    @Test
    public void task04() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        log.info("[task04][开始执行]");
        //<1>
        ListenableFuture<Integer> execute01Result = asyncService.execute01AsyncWithListenableFuture();
        log.info("[task04][execute01Result 的类型是：({})]",execute01Result.getClass().getSimpleName());
        execute01Result.addCallback(new SuccessCallback<Integer>() {// <2.1> 增加成功的回调
            @Override
            public void onSuccess(Integer result) {
                log.info("[onSuccess][result: {}]", result);
            }
        }, new FailureCallback() {// <2.1> 增加失败的回调
            @Override
            public void onFailure(Throwable ex) {
                log.info("[onFailure][发生异常]", ex);
            }
        });
        execute01Result.addCallback(new ListenableFutureCallback<Integer>() {// <2.2> 增加成功和失败的统一回调
            @Override
            public void onSuccess(Integer result) {
                log.info("[onSuccess][result: {}]", result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("[onFailure][发生异常]", ex);
            }
        });

        //<3>阻塞等待结果
        execute01Result.get();
        log.info("[task04][结束执行，消耗时长{}毫秒]",System.currentTimeMillis()-now);
    }

    @Test
    public void testException() throws InterruptedException {
        asyncService.executeExcception(1,3);
        // sleep 1 秒，保证异步调用的执行
        Thread.sleep(1000);
    }
}
