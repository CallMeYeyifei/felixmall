package com.felixmall.felixcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixcoupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 22:32:03
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

