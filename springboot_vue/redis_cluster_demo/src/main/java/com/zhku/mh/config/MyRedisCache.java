package com.zhku.mh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyRedisCache {
    @Autowired
    RedisConnectionFactory connectionFactory;

    @Bean
    RedisCacheManager redisCacheManager(){
        Map<String, RedisCacheConfiguration> conMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .prefixKeysWith("mh:")
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(30));
        conMap.put("c1",redisCacheConfig);

        RedisCacheWriter cacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisCacheManager cacheManager = new RedisCacheManager(cacheWriter,
                                                                RedisCacheConfiguration.defaultCacheConfig(),
                                                                conMap);
        return cacheManager;
    }
}
