package com.tzp.gulimall.coupon.dao;

import com.tzp.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:15:59
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
