package com.felixmall.felixorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixorder.entity.OrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:29:29
 */
public interface OrderReturnApplyService extends IService<OrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

