package com.tzp.gulimall.member.dao;

import com.tzp.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author tzp
 * @email 807324130@qq.com
 * @date 2022-03-14 22:27:02
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}