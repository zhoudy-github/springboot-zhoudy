package com.zhoudy.springboot.usermanage.support.task.quartzjdbc;
//实际场景下，我们必然需要考虑定时任务的高可用，所以基本上，肯定使用 Quartz 的集群方案。
// 因此本小节，我们使用 Quartz 的 JDBC 存储器 JobStoreTX ，并是使用 MySQL 作为数据库。