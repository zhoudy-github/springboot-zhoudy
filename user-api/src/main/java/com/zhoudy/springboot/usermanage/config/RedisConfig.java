package com.zhoudy.springboot.usermanage.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        //创建RedisTemplate对象
        RedisTemplate redisTemplate=new RedisTemplate();


        // 设置开启事务支持
        redisTemplate.setEnableTransactionSupport(true);


        //设置RedisConnection工厂，它就是实现多种Java Redis客户端接入的秘密工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //使用String序列化方式序列化key
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //使用JSON序列化方式(库是Jackson)序列化value
//        redisTemplate.setValueSerializer(RedisSerializer.json());

        /*
        //使用自定义序列化方式
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);
        */
        return redisTemplate;
    }
}
