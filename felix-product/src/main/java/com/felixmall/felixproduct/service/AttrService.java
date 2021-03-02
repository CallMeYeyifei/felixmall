package com.felixmall.felixproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixproduct.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-07-29 00:15:44
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

