package com.felixmall.felixproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixproduct.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-07-29 00:15:44
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

