package com.zhoudy.springboot.usermanage.support.task.quartz;
//Spring Boot 1.X 版本未提供 Quartz 的自动化配置，而 2.X 版本提供了支持。
//Scheduler ：调度器
//Trigger ：触发器
//Job ：任务
// 公司使用 Quartz 作为任务调度中间件。考虑到我们要实现定时任务的高可用，
// 需要部署多个 JVM 进程。比较舒服的是，Quartz 自带了集群方案。它通过将
// 作业信息存储到关系数据库中，并使用关系数据库的行锁来实现执行作业的竞争，
// 从而保证多个进程下，同一个任务在相同时刻，不能重复执行。

