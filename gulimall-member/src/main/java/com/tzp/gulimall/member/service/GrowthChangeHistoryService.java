package com.tzp.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzp.common.utils.PageUtils;
import com.tzp.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:27:01
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

