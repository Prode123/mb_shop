package com.hs.controller;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Goods;
import com.hs.entity.ResponseEntity;
import com.hs.entity.Shoppingimg;
import com.hs.service.GoodsService;
import com.hs.service.ShoppingimgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * (Goods)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    @Resource
    private ShoppingimgService shoppingimgService;

    /**
     * @author 陈伟明
     */
    @GetMapping("/queryAllGoods")
    public PageInfo<Goods> queryAllGoods(int pageNum,int pageSize){
        return goodsService.selectAll(pageNum,pageSize);
    }

    @GetMapping("/queryAllGoods1")
    public ResponseEntity<List<Goods>> queryAllGoods1(HttpServletResponse response){
        ResponseEntity<List<Goods>> responseEntity = new ResponseEntity<>();
        List<Goods> goods = goodsService.selectAll1();
        responseEntity.setData(goods);
        responseEntity.setMessage(response.getHeader("token"));
        return responseEntity;
    }

    /**
     * @author 陈伟明
     */
    @GetMapping("/queryGoodsByGid")
    public Goods queryGoodByGid(int gId){
        Goods good = goodsService.selectById(gId);
        System.out.println(good);
        return good;
    }

    /**
     * @author 陈伟明
     */
    @RequestMapping("/register")
    public String register(MultipartFile[] photos,Goods goods) throws IOException {

            int k=0;
            for (int i = 0; i < photos.length; i++) {
                if (i==0){
                    String originalFilename = photos[0].getOriginalFilename();
                    String uniqueFilename= UUID.randomUUID().toString()+originalFilename;
                    String path="\\\\169.254.40.220\\img\\"+uniqueFilename;
                    File file = new File(path);
                    photos[0].transferTo(file);
                    goods.setGPic(path);
                    int j = goodsService.insert(goods);
//                    System.out.println(j);
                    k+=j;
//                    System.out.println(j);
//                    System.out.println();
                }else {
                    String originalFilename = photos[i].getOriginalFilename();
                    String uniqueFilename= UUID.randomUUID().toString()+originalFilename;
                    String path="\\\\169.254.40.220\\img\\"+uniqueFilename;
                    File file = new File(path);
                    photos[i].transferTo(file);
                    Shoppingimg shoppingimg=new Shoppingimg();
                    shoppingimg.setGId(goods.getGId());
                    shoppingimg.setPicName(uniqueFilename);
                    shoppingimg.setPicSrc(path);
                    int j = shoppingimgService.insert(shoppingimg);
                    k+=j;
//                    System.out.println(j);
//                    System.out.println();
                }
            }
            if (k>=1){
                return "register ok";
            }else {
                return "register false";
            }

    }

    @RequestMapping("/delete")
    public String delete(int gId,HttpServletResponse resp){
        int i = goodsService.deleteById(gId);
        return "delete ok";
    }

    @RequestMapping("/update")
    public String update(Goods goods){
        int i = goodsService.update(goods);
        return "update ok";
    }

    @RequestMapping("/findPhoto")
    public String findPhoto(String gpic,HttpServletResponse resp) throws IOException {
        String path="http://localhost/img/"+gpic.substring(gpic.indexOf("g")+2);
        return path;
    }

    @RequestMapping("/test1")
    public void test1(HttpServletResponse resp) throws IOException {
        String gpic="D:\\img\\7d9d7072-f52e-4755-9411-3b003a9ecf0awallhaven-8ok7vk.jpg";
        String path="http://localhost:8080/img1/03d71b65-75a4-43a0-be8d-f75688f7c8a1wallhaven-8ok7vk.jpg";
        resp.sendRedirect(path);
    }

    @GetMapping("/c2IdPageInfo")
    public PageInfo<Goods> AllByStudent(int pageNum, int pageSize,int c2Id){
        PageInfo<Goods> goodsPageInfo = goodsService.AllByStudent(pageNum, pageSize, c2Id);
        return goodsPageInfo;
    }

    @GetMapping("/mHFindGoodsByInput1")
    public List<Goods> mHFindGoodsByInput1(String input1){
        List<Goods> goods = goodsService.mHFindGoodsByInput1(input1);
        return goods;
    }

    @GetMapping("/findC2IdGoods")
    public List<Goods>  findByC2Id(int c2Id){
        List<Goods> goods = goodsService.selectByC2id(c2Id);
        return goods;
    }
}