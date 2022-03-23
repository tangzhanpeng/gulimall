package com.tzp.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.to.OrderTo;
import com.tzp.common.to.SkuHasStockVo;
import com.tzp.common.to.mq.StockLockedTo;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.ware.entity.WareSkuEntity;
import com.tzp.gulimall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:39:16
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    /**
     * 锁定库存
     * @param vo
     * @return
     */
    boolean orderLockStock(WareSkuLockVo vo);


    /**
     * 解锁库存
     * @param to
     */
    void unlockStock(StockLockedTo to);

    /**
     * 解锁订单
     * @param orderTo
     */
    void unlockStock(OrderTo orderTo);
}

