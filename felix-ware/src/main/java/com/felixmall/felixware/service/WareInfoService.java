package com.felixmall.felixware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.felixware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 23:37:37
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

