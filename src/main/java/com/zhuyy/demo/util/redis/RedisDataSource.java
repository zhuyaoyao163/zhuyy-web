package com.zhuyy.demo.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * Created by Administrator on 2016/5/31.
 */
public interface RedisDataSource {

    /**
     * 取得redis的客户端，可以执行命令了
     * @return
     */
    public abstract Jedis getRedisClient();

    /**
     * 将资源返还给pool
     * @param jedis
     */
    public void returnResource(Jedis jedis);

    /**
     * 出现异常后，将资源返还给pool
     * @param jedis
     * @param broken
     */
    public void returnResource(Jedis jedis,boolean broken);
}
