package com.felixmall.felixmember.feigh;

import com.felixmall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @InterfaceName CouponFeignService
 * @Description TODO
 * @Author yeyifei
 * @Date 2020/9/1 12:22 AM
 * @Version 1.0
 **/
@FeignClient("felix-coupon")
@Component
public interface CouponFeignService {
    @RequestMapping("/felixcoupon/coupon/member/list")
    public R memberCoupons();
}
