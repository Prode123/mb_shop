package com.hs.controller;

import com.hs.entity.Cart;
import com.hs.entity.Goods;
import com.hs.entity.ResponseEntity;
import com.hs.service.CartService;
import com.hs.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Cart)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;
    @Resource
    private GoodsService goodsService;

    /**
     * 通过用户id查询出购物车中对应所有商品的id，之后根据商品id去商品表查询所有对应商品
     *
     * 张帆
     */
    @RequestMapping("/queryAll")
    private ResponseEntity<List<Goods>> queryAll(Cart cart) {
        ResponseEntity<List<Goods>> responseEntity = new ResponseEntity<>();

        List<Cart> carts = cartService.selectList(cart);
        //商品列表
        List<Goods> goodsList = new LinkedList<>();
        for (Cart cart1 : carts) {
            Goods goods = goodsService.selectById(cart1.getGId());
            //将购物车表中的主键作为每个商品对象的备用字段1
            try {
                goods.setG1(String.valueOf(cart1.getCarId()));
                //将数量作为每个对象（不是表中的数据，只是new的对象）
                goods.setG2(String.valueOf(cart1.getNumId()));
            } catch (NullPointerException e){

            }
            //将商品一条条放入商品列表
            goodsList.add(goods);
        }
        if (goodsList.size() == 0) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        responseEntity.setData(goodsList);
        return responseEntity;
    }

    /**
     * 通过用户id查询出购物车中对应所有商品的id，之后根据商品id去商品表查询所有对应商品
     *
     * 张帆
     */
    @RequestMapping("/queryAllIsChecked")
    private ResponseEntity<List<Goods>> queryAllIsChecked(Cart cart) {
        ResponseEntity<List<Goods>> responseEntity = new ResponseEntity<>();
        cart.setCar1("1");
        List<Cart> carts = cartService.selectList(cart);
        //商品列表
        List<Goods> goodsList = new LinkedList<>();
        for (Cart cart1 : carts) {
            Goods goods = goodsService.selectById(cart1.getGId());
            //将购物车表中的主键作为每个商品对象的备用字段1
            try {
                goods.setG1(String.valueOf(cart1.getCarId()));
                //将数量作为每个对象（不是表中的数据，只是new的对象）
                goods.setG2(String.valueOf(cart1.getNumId()));
            } catch (NullPointerException e){

            }
            //将商品一条条放入商品列表
            goodsList.add(goods);
        }
        if (goodsList.size() == 0) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        responseEntity.setData(goodsList);
        return responseEntity;
    }

    /**
     * 将一条商品信息移出购物车
     *
     * 张帆
     */
    @RequestMapping("/deleteByCarId")
    public ResponseEntity<String> delete(Cart cart){
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        int deleteById = cartService.deleteById(cart.getCarId());
        if (deleteById > 0) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        return responseEntity;
    }

    /**
     * 前端点击加减时改变数据库中的数量
     *
     * 张帆
     */
    @RequestMapping("/updateNum")
    public ResponseEntity<String> updateNum(Cart cart){
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        Cart update = cartService.update(cart);
        if (update != null) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        return responseEntity;
    }

    /**
     * 在购物车中标记该买家此次选中了哪些商品，使用备用字段1，设为值1，以便生成订单时知道是购物车中的哪些商品
     *
     * 张帆
     */
    @RequestMapping("/updateCar1")
    public ResponseEntity<String> updateCar1(Integer[] goodsChecked){
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        int i = cartService.updateDaoCar1(goodsChecked);
        if (i > 0) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        return responseEntity;
    }

    /**
     * 在购物车中标记该买家此次选中了哪些商品，使用备用字段1，但是没有提交订单，而是直接返回，所以将该字段置为零
     *
     * 张帆
     */
    @RequestMapping("/updateCar1To0")
    public ResponseEntity<String> updateCar1To0(Cart cart){
        ResponseEntity<String> responseEntity = new ResponseEntity<>();
        int i = cartService.updateDaoCar1To0(cart);
        if (i > 0) {
            responseEntity.setStatus(1);
        } else {
            responseEntity.setStatus(2);
        }
        return responseEntity;
    }

    @RequestMapping("/addCart")
    public String addCart(Cart cart){
        int i = cartService.insert(cart);
        if (i==1){
            return "register ok";
        }else {
            return "register false";
        }
    }

}