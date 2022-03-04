package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.BaoBiao;
import com.hs.entity.Orderr;
import com.hs.entity.Orderr;
import com.hs.entity.ResponseEntity;
import com.hs.service.OrderandgoodsService;
import com.hs.service.OrderrService;
import com.hs.tools.OrderTool;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Orderr)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/orderr")
public class OrderrController {
    /**
     * 服务对象
     */
    @Resource
    private OrderrService orderrService;


    /**
     * 查询单条信息
     */
    @RequestMapping("/selectByoId")
    public ResponseEntity<Orderr> selectByLogId(Orderr orderr) {
        Orderr logistics1 = orderrService.selectById(orderr.getOId());
        ResponseEntity<Orderr> responseEntity = new ResponseEntity<>();
        if (logistics1 == null) {
            responseEntity.setStatus(2);
            responseEntity.setMessage("查询失败");
        } else {
            responseEntity.setStatus(1);
            responseEntity.setData(logistics1);
            responseEntity.setMessage("查询成功");
        }
        return responseEntity;
    }

    /**
     * 按条件分页查询所有订单信息
     */
    @RequestMapping("/checkInfo")
    public ResponseEntity<PageInfo<Orderr>> checkByPaging(OrderTool orderTool, Integer page, Integer num) {
        PageInfo<Orderr> logisticsPageInfo = orderrService.selectByPageHelper
                (orderTool, page, num);
        ResponseEntity<PageInfo<Orderr>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(1);
        responseEntity.setData(logisticsPageInfo);
        responseEntity.setMessage("查询成功");
        return responseEntity;
    }


    /**
     * 添加一条订单信息
     */
    @RequestMapping("/addOrderr")
    public ResponseEntity<Integer> insertOrderr(Orderr orderr) {
        orderr.setOTime(new Date());
        ResponseEntity responseEntity = new ResponseEntity();
        int insert = orderrService.insert(orderr);
        if (insert > 0) {
            responseEntity.setStatus(1);
            responseEntity.setData(insert);
            responseEntity.setMessage("插入成功");
        } else {
            responseEntity.setStatus(2);
            responseEntity.setData(insert);
            responseEntity.setMessage("插入失败");
        }
        return responseEntity;
    }

    /**
     * 删除一条订单信息
     */
    @RequestMapping("/deleteOrderr")
    public ResponseEntity<String> deleteOrderr(Integer oId) {
        ResponseEntity responseEntity = new ResponseEntity();
        int deleteById = orderrService.deleteById(oId);
        if (deleteById > 0) {
            responseEntity.setStatus(1);
            responseEntity.setData(deleteById);
            responseEntity.setMessage("删除成功");
        } else {
            responseEntity.setStatus(2);
            responseEntity.setData(deleteById);
            responseEntity.setMessage("删除失败");
        }
        return responseEntity;
    }


    /**
     * 修改一条订单信息
     */
    @RequestMapping("/updateOrderr")
    public ResponseEntity<Integer> updateLog(Orderr orderr) {
        ResponseEntity responseEntity = new ResponseEntity();
        Orderr update = orderrService.update(orderr);
        if (update != null) {
            responseEntity.setStatus(1);
            responseEntity.setData(update);
            responseEntity.setMessage("修改成功");
        } else {
            responseEntity.setStatus(2);
            responseEntity.setData(update);
            responseEntity.setMessage("修改失败");
        }
        return responseEntity;
    }

    /**
     * 提交支付时，将订单o3置为0,并生成物流等信息
     */
    @RequestMapping("/updateOrderr1")
    public ResponseEntity<Integer> updateLog1(Orderr orderr) {
        ResponseEntity responseEntity = new ResponseEntity();
        Orderr update = orderrService.update1(orderr);
        if (update != null) {
            responseEntity.setStatus(1);
            responseEntity.setData(update);
            responseEntity.setMessage("修改成功");
        } else {
            responseEntity.setStatus(2);
            responseEntity.setData(update);
            responseEntity.setMessage("修改失败");
        }
        return responseEntity;
    }

    @RequestMapping("/queryAllOrderr")
    public List<Orderr> queryAllOrderr(){
        List<Orderr> orderrs = orderrService.selectAll();
        return orderrs;
    }

    /**
     * gm  查询订单前5的信息
     * @return
     */
    @GetMapping("/findAllBB")
    public List<BaoBiao> findAllBB(){
        return orderrService.findAllBB();
    }

}