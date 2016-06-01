package com.zhuyy.demo.util.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * Created by Administrator on 2016/5/31.
 */
@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger LOGGER = Logger.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getRedisClient() {
        try {
            Jedis jedis = jedisPool.getResource();
            return jedis;
        } catch (Exception e) {
            LOGGER.error("getRedisClent error", e);
        }
        return null;
    }

    @Override
    public void returnResource(Jedis Jedis) {
        jedisPool.returnResource(Jedis);
    }

    @Override
    public void returnResource(Jedis Jedis, boolean broken) {
        if (broken) {
            jedisPool.returnBrokenResource(Jedis);
        } else {
            jedisPool.returnResource(Jedis);
        }
    }
}
