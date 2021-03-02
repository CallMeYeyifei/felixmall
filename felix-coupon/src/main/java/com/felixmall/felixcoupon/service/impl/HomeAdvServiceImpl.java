package com.felixmall.felixcoupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.common.utils.Query;

import com.felixmall.felixcoupon.dao.HomeAdvDao;
import com.felixmall.felixcoupon.entity.HomeAdvEntity;
import com.felixmall.felixcoupon.service.HomeAdvService;


@Service("homeAdvService")
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvDao, HomeAdvEntity> implements HomeAdvService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HomeAdvEntity> page = this.page(
                new Query<HomeAdvEntity>().getPage(params),
                new QueryWrapper<HomeAdvEntity>()
        );

        return new PageUtils(page);
    }

}