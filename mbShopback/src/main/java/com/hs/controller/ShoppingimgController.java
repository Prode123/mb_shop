package com.hs.controller;

import com.hs.entity.Shoppingimg;
import com.hs.service.ShoppingimgService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Shoppingimg)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/shoppingimg")
public class ShoppingimgController {
    /**
     * 服务对象
     */
    @Resource
    private ShoppingimgService shoppingimgService;


    @RequestMapping("/queryShoppingimgByGid")
    public List<Shoppingimg> queryShoppingimgByGid(int gid){
        return shoppingimgService.findShoppingimgByGid(gid);
    }

    
}