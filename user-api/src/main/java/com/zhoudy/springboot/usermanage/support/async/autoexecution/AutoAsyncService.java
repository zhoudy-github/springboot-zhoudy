package com.zhoudy.springboot.usermanage.support.async.autoexecution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AutoAsyncService {

    @Async(AutoAsyncConfig.EXECUTOR_ONE_BEAN_NAME)
    public Integer execute01(){
        log.info("[execute01]");
        return 1;
    }

    @Async(AutoAsyncConfig.EXECUTOR_TWO_BEAN_NAME)
    public Integer execute02(){
        log.info("[execute02]");
        return 2;
    }

}
