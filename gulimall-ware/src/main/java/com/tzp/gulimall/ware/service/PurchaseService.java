package com.tzp.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.ware.entity.PurchaseEntity;
import com.tzp.gulimall.ware.vo.MergeVo;
import com.tzp.gulimall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:39:16
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}

