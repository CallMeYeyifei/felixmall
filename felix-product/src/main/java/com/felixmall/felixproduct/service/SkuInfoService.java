package com.felixmall.felixproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixproduct.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-07-29 00:15:44
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

