package com.tzp.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.to.SkuReductionTo;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:15:59
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo reductionTo);
}

