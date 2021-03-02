package com.felixmall.felixmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixmember.entity.MemberReceiveAddressEntity;

import java.util.Map;

/**
 * 会员收货地址
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:14:30
 */
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

