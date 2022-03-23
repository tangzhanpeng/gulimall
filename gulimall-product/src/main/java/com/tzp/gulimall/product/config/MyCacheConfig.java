//package com.tzp.gulimall.product.config;
//
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.boot.autoconfigure.cache.CacheProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableConfigurationProperties(CacheProperties.class)
//@Configuration
//@EnableCaching
//public class MyCacheConfig {
//
//    // @Autowired
//    // public CacheProperties cacheProperties;
//
//    /**
//     * 配置文件的配置没有用上
//     * @return
//     */
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties) {
//
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//        // config = config.entryTtl();
//        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
//        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        CacheProperties.Redis redisProperties = cacheProperties.getRedis();
//        //将配置文件中所有的配置都生效
//        if (redisProperties.getTimeToLive() != null) {
//            config = config.entryTtl(redisProperties.getTimeToLive());
//        }
//        if (redisProperties.getKeyPrefix() != null) {
//            config = config.prefixKeysWith(redisProperties.getKeyPrefix());
//        }
//        if (!redisProperties.isCacheNullValues()) {
//            config = config.disableCachingNullValues();
//        }
//        if (!redisProperties.isUseKeyPrefix()) {
//            config = config.disableKeyPrefix();
//        }
//
//        return config;
//    }
//
////    @Bean
////    public RedisConnectionFactory redisConnectionFactory(){
////        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder = JedisClientConfiguration.builder().usePooling();
////        GenericObjectPoolConfig GenericObjectPoolConfig = new GenericObjectPoolConfig();
////        GenericObjectPoolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
////        GenericObjectPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
////        GenericObjectPoolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
////        JedisClientConfiguration jedisClientConfiguration = JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).build();
////
////        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
////
////        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
////        redisStandaloneConfiguration.setPort(redisProperties.getPort());
////        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
////        redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
////
////
////        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
////        return factory;
////    }
////
////    @Bean
////    public CacheManager cacheManager() {
////        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory());
////
////        builder.transactionAware();
////
////        RedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
////        RedisSerializationContext.SerializationPair serializationPair = RedisSerializationContext.SerializationPair.fromSerializer(genericJackson2JsonRedisSerializer);
////        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
////                .serializeKeysWith(serializationPair)
////                .serializeValuesWith(serializationPair);
////        builder.cacheDefaults(cacheConfig);
////
////        Map<String, RedisCacheConfiguration> initialCacheConfigs = new HashMap<>();
////        initialCacheConfigs.put("1s", cacheConfig.entryTtl(Duration.ofSeconds(1)));
////        initialCacheConfigs.put("5s", cacheConfig.entryTtl(Duration.ofSeconds(5)));
////        initialCacheConfigs.put("10s", cacheConfig.entryTtl(Duration.ofSeconds(10)));
////        initialCacheConfigs.put("15s", cacheConfig.entryTtl(Duration.ofSeconds(15)));
////        initialCacheConfigs.put("30s", cacheConfig.entryTtl(Duration.ofSeconds(30)));
////        initialCacheConfigs.put("60s", cacheConfig.entryTtl(Duration.ofSeconds(60)));
////        initialCacheConfigs.put("1min", cacheConfig.entryTtl(Duration.ofMinutes(1)));
////        initialCacheConfigs.put("2min", cacheConfig.entryTtl(Duration.ofMinutes(2)));
////        initialCacheConfigs.put("5min", cacheConfig.entryTtl(Duration.ofMinutes(5)));
////        initialCacheConfigs.put("15min", cacheConfig.entryTtl(Duration.ofMinutes(15)));
////        initialCacheConfigs.put("30min", cacheConfig.entryTtl(Duration.ofMinutes(30)));
////        initialCacheConfigs.put("45min", cacheConfig.entryTtl(Duration.ofMinutes(45)));
////        initialCacheConfigs.put("60min", cacheConfig.entryTtl(Duration.ofMinutes(60)));
////        initialCacheConfigs.put("1h", cacheConfig.entryTtl(Duration.ofHours(1)));
////        initialCacheConfigs.put("2h", cacheConfig.entryTtl(Duration.ofHours(2)));
////        initialCacheConfigs.put("3h", cacheConfig.entryTtl(Duration.ofHours(3)));
////        initialCacheConfigs.put("6h", cacheConfig.entryTtl(Duration.ofHours(6)));
////        initialCacheConfigs.put("8h", cacheConfig.entryTtl(Duration.ofHours(8)));
////        initialCacheConfigs.put("9h", cacheConfig.entryTtl(Duration.ofHours(9)));
////        initialCacheConfigs.put("12h", cacheConfig.entryTtl(Duration.ofHours(12)));
////        initialCacheConfigs.put("24h", cacheConfig.entryTtl(Duration.ofHours(24)));
////        initialCacheConfigs.put("1day", cacheConfig.entryTtl(Duration.ofDays(1)));
////        initialCacheConfigs.put("2day", cacheConfig.entryTtl(Duration.ofDays(2)));
////        initialCacheConfigs.put("3day", cacheConfig.entryTtl(Duration.ofDays(3)));
////        initialCacheConfigs.put("5day", cacheConfig.entryTtl(Duration.ofDays(5)));
////        initialCacheConfigs.put("7day", cacheConfig.entryTtl(Duration.ofDays(7)));
////        initialCacheConfigs.put("1week", cacheConfig.entryTtl(Duration.ofDays(7)));
////        initialCacheConfigs.put("2week", cacheConfig.entryTtl(Duration.ofDays(14)));
////        initialCacheConfigs.put("3week", cacheConfig.entryTtl(Duration.ofDays(21)));
////        initialCacheConfigs.put("4week", cacheConfig.entryTtl(Duration.ofDays(28)));
////        initialCacheConfigs.put("1month", cacheConfig.entryTtl(Duration.ofDays(30)));
////        initialCacheConfigs.put("2month", cacheConfig.entryTtl(Duration.ofDays(60)));
////        initialCacheConfigs.put("appResource", cacheConfig.entryTtl(Duration.ofSeconds(500)));
////
////        builder.withInitialCacheConfigurations(initialCacheConfigs);
////        return builder.build();
////    }
//
//}
