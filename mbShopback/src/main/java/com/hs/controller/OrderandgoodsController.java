package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Orderandgoods;
import com.hs.entity.Orderr;
import com.hs.entity.ResponseEntity;
import com.hs.service.OrderandgoodsService;
import com.hs.tools.OrderTool;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Orderandgoods)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/orderandgoods")
public class OrderandgoodsController {
    /**
     * 服务对象
     */
    @Resource
    private OrderandgoodsService orderandgoodsService;

    /**
     * 按条件分页查询所有信息
     */
    @RequestMapping("/checkInfo")
    public ResponseEntity<PageInfo<Orderandgoods>> checkByPaging(Orderandgoods orderandgoods, Integer page, Integer num) {
        PageInfo<Orderandgoods> orderandgoodsPageInfo = orderandgoodsService.selectAllPaging(orderandgoods, page, num);
        ResponseEntity<PageInfo<Orderandgoods>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(1);
        responseEntity.setData(orderandgoodsPageInfo);
        responseEntity.setMessage("查询成功");
        return responseEntity;
    }

    @RequestMapping("/queryAllOrderandgoods")
    public List<Orderandgoods> queryAllOrderandgoods(){
        List<Orderandgoods> orderandgoods = orderandgoodsService.selectAll();
        return orderandgoods;
    }

    @RequestMapping("/queryGidByOid")
    public Orderandgoods queryGidByOid(int oid){
        Orderandgoods orderandgoods = orderandgoodsService.selectById(oid);
        return orderandgoods;
    }

    @RequestMapping("/queryGidByOid1")
    public Orderandgoods queryGidByOid1(int oid){
        Orderandgoods orderandgoods = orderandgoodsService.selectById1(oid);
        return orderandgoods;
    }

    @RequestMapping("/deleteByOid")
    public String deleteByOid(int oid){
        int i = orderandgoodsService.deleteByOid(oid);
        if (i==1){
            return "delete ok";
        }else {
            return "delete false";
        }
    }
    
}