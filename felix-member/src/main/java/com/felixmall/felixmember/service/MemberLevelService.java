package com.felixmall.felixmember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixmember.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:14:30
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

