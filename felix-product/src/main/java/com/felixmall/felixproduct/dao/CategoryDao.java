package com.felixmall.felixproduct.dao;

import com.felixmall.felixproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-07-29 00:15:44
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
