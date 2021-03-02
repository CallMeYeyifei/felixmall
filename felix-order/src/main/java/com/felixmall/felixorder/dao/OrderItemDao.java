package com.felixmall.felixorder.dao;

import com.felixmall.felixorder.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:29:29
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
