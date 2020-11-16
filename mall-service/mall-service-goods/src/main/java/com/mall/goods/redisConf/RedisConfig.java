package com.mall.goods.redisConf;


import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig  extends CachingConfigurerSupport{

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        //创建redisTemplate对象
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<String, Object>();
        //设置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //序列化对象
        //简单的字符串序列化
        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
        //jdk 序列化
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer=new JdkSerializationRedisSerializer();
        //Json 序列化
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();

        redisTemplate.setStringSerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        return redisTemplate;
    }
}
