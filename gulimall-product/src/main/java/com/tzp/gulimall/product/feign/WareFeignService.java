package com.tzp.gulimall.product.feign;

import com.tzp.common.result.Result;
import com.tzp.common.to.SkuHasStockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("gulimall-ware")
public interface WareFeignService {

    @PostMapping(value = "/ware/waresku/hasStock")
    Result<List<SkuHasStockVo>> getSkuHasStock(@RequestBody List<Long> skuIds);

}
