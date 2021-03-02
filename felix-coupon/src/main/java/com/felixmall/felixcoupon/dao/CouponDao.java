package com.felixmall.felixcoupon.dao;

import com.felixmall.felixcoupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 22:32:03
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
