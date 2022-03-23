package com.tzp.gulimall.order.dao;

import com.tzp.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单
 * 
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:34:43
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
    /**
     * 修改订单状态
     * @param orderSn
     * @param code
     * @param payType
     */
    void updateOrderStatus(@Param("orderSn") String orderSn,
                           @Param("code") Integer code,
                           @Param("payType") Integer payType);
}
