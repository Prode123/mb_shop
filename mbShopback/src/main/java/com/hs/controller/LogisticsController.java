package com.hs.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Logistics;
import com.hs.entity.ResponseEntity;
import com.hs.service.LogisticsService;
import com.hs.tools.LogisticsTools;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Logistics)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/logistics")
public class LogisticsController {
    /**
     * 服务对象
     */
    @Resource
    private LogisticsService logisticsService;

    /**
     * 查询单条信息
     */
    @RequestMapping("/selectByLogId")
    public ResponseEntity<Logistics> selectByLogId(Logistics logistics) {
        Logistics logistics1 = logisticsService.selectById(logistics.getLogId());
        ResponseEntity<Logistics> responseEntity = new ResponseEntity<>();
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
     * 按条件分页查询所有物流信息
     */
    @RequestMapping("/checkInfo")
    public ResponseEntity<PageInfo<Logistics>> checkByPaging(LogisticsTools log,Integer page, Integer num) {
        PageInfo<Logistics> logisticsPageInfo = logisticsService.selectByPageHelper
                (log, page, num);
        ResponseEntity<PageInfo<Logistics>> responseEntity = new ResponseEntity<>();
        responseEntity.setStatus(1);
        responseEntity.setData(logisticsPageInfo);
        responseEntity.setMessage("查询成功");
        return responseEntity;
    }


    /**
     * 添加一条物流信息
     */
    @RequestMapping("/addLogistics")
    public ResponseEntity<Integer> insertLogistics(Logistics logistics) {
        ResponseEntity responseEntity = new ResponseEntity();
        int insert = logisticsService.insert(logistics);
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
     * 删除一条物流信息
     */
    @RequestMapping("/deleteLogistics")
    public ResponseEntity<String> deleteLogistics(Integer lId) {
        ResponseEntity responseEntity = new ResponseEntity();
        int deleteById = logisticsService.deleteById(lId);
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
     * 修改一条物流信息
     */
    @RequestMapping("/updateLog")
    public ResponseEntity<Integer> updateLog(Logistics logistics) {
        ResponseEntity responseEntity = new ResponseEntity();
        Logistics update = logisticsService.update(logistics);
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

    @RequestMapping("/selectByOid")
    public Logistics selectByOid(int oid){
        Logistics logistics = logisticsService.selectByOid(oid);
        return logistics;
    }

}