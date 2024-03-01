package com.yry;

import com.yry.entity.LoginR;
import com.yry.util.IdentUtils;
import com.yry.util.JwtUtils;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class Test {
    public static void main(String[] args) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        System.out.println(redisTemplate.opsForValue().get(IdentUtils.STUDENT + "202235720346"));
    }
}
