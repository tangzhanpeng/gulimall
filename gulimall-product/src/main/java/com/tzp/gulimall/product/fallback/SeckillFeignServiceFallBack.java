package com.tzp.gulimall.product.fallback;

import com.tzp.common.exception.BizCodeEnume;
import com.tzp.gulimall.product.feign.SeckillFeignService;
import com.tzp.common.utils.R;
import org.springframework.stereotype.Component;

@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
    }
}
