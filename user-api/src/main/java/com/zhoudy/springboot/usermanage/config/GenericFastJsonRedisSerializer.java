package com.zhoudy.springboot.usermanage.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class GenericFastJsonRedisSerializer implements RedisSerializer<Object> {

    private final static ParserConfig defaultRedisConfig = new ParserConfig();

    static {defaultRedisConfig.setAutoTypeSupport(true);}
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        //空，直接返回空数组
        if(o == null){
            return new byte[0];
        }
        try {
            //使用JSON进行序列化成二进制数组，SerializerFeature.WriteClassName参数，声明写入类全名
            System.out.println(1111111);
            return JSON.toJSONBytes(o, SerializerFeature.WriteClassName);
        } catch (Exception e) {
            throw new SerializationException("Could not serialize:"+e.getMessage(),e);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        // 如果为空，则返回空对象
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            System.out.println(1111111);
            // 使用 JSON 解析成对象。
            return JSON.parseObject(new String(bytes, IOUtils.UTF8), Object.class, defaultRedisConfig);
        } catch (Exception ex) {
            throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
        }
    }
}
