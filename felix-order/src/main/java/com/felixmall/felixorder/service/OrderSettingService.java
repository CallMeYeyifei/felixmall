package com.felixmall.felixorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixorder.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:29:29
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

