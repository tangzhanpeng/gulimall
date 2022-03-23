package com.tzp.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:15:59
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

