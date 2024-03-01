package com.yry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

public class Test {

    @Resource
    private RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(redisTemplate.opsForValue().get("student-202235720346"));
    }
}
