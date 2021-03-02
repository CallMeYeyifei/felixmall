package com.felixmall.felixproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.felixmall.felixproduct.entity.BrandEntity;
import com.felixmall.felixproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FelixProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setDescript("我是你爹");
//        brandEntity.setName("好东西");
//        brandService.save(brandEntity);
//        System.out.println("操作成功呀 宝贝！！ save successs!!!");

        List<BrandEntity> brandEntity = brandService.list(new QueryWrapper<BrandEntity>().eq("name","好东西"));
        brandEntity.forEach((item)->{
            System.out.println(item);
        });
    }

}
