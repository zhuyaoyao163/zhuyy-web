package com.zhuyy.demo.util.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml",
        "classpath:spring-mybatis.xml","classpath:spring/applicationContext-cache.xml"})
public class TestRedisClientTemplate {

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Test
    public void testgenerateCacheKey() {
        String a = "ERROR_LOGIN";
        String b = "32324";
        String key = redisClientTemplate.generateCacheKey(a,b);
        System.out.println(key);
    }
}
