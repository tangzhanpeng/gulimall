package com.tzp.gulimall.product.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisCacheController {

    @GetMapping("/cacheTest")
    @Cacheable(value = "m1=100", keyGenerator = "selfKeyGenerate")
    public String cacheTest(Long id) {
        log.info("调用cacheTest方法");
        return "cacheTest" + id;
    }
}
