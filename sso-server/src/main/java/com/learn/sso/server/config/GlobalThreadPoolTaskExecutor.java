package com.learn.sso.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Package:                 com.bill99.fto.cmdc.pay
 * Date:                    2019/4/19 19:05
 * @Author:                kevin.wang
 * Company:                 kuaiqian
 * Version:                 1.0.0
 * Description:             类
 */
@Configuration
public class GlobalThreadPoolTaskExecutor {
    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        /** 线程池维护线程的最少数量 */
        threadPoolTaskExecutor.setCorePoolSize(2*Runtime.getRuntime().availableProcessors());
        /** 线程池维护线程的最大数量 */
        threadPoolTaskExecutor.setMaxPoolSize(120);
        /** 线程池所使用的缓冲队列 */
        threadPoolTaskExecutor.setQueueCapacity(200);
        /** 线程池维护线程所允许的空闲时间 */
        threadPoolTaskExecutor.setKeepAliveSeconds(300);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        /** 线程名称前缀 */
        threadPoolTaskExecutor.setThreadNamePrefix("sso-thread-execute");
        /** 设置拒绝策略 */
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return threadPoolTaskExecutor;
    }

}
