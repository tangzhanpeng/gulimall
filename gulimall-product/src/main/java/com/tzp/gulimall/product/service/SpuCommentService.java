package com.tzp.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.product.entity.SpuCommentEntity;

import java.util.Map;

/**
 * 商品评价
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 16:51:42
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

