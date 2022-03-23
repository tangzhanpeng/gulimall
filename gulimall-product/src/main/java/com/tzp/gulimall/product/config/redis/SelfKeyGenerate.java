package com.tzp.gulimall.product.config.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("selfKeyGenerate")
public class SelfKeyGenerate implements KeyGenerator {


    @Override
    public Object generate(Object o, Method method, Object... objects) {
        String keyRes = o.getClass().getSimpleName() + "#" + method.getName();
        if (objects.length == 0) {
            keyRes += "()";
        } else {
            keyRes += "(" + JSON.toJSONString(objects) + ")";
        }
        return keyRes;
    }
}
