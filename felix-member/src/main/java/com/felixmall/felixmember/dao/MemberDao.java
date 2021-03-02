package com.felixmall.felixmember.dao;

import com.felixmall.felixmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:14:30
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
