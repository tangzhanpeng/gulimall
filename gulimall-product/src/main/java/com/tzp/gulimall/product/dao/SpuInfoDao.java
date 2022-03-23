package com.tzp.gulimall.product.dao;

import com.tzp.gulimall.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * spu信息
 * 
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 16:51:42
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {
    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") int code);
}
