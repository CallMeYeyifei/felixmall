package com.felixmall.felixcoupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felixmall.felixcoupon.entity.CouponEntity;
import com.felixmall.felixcoupon.service.CouponService;
import com.felixmall.common.utils.PageUtils;
import com.felixmall.common.utils.R;



/**
 * 优惠券信息
 *
 * @author yeyf
 * @email 1095459717@qq.com
 * @date 2020-08-31 22:32:03
 */
@RestController
@RequestMapping("felixcoupon/coupon")
@RefreshScope
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    String name;

    @Value("${coupon.user.money}")
    Double money;
    @RequestMapping("/test")
    public R test(){
        return R.ok().put("name",name).put("money",money);
    }

    @RequestMapping("/member/list")
    public R memberCoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减20！");
        return R.ok().put("coupons",Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("felixcoupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("felixcoupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("felixcoupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("felixcoupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("felixcoupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
