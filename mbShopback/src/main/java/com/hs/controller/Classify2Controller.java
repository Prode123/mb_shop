package com.hs.controller;

import com.hs.entity.Classify1;
import com.hs.entity.Classify2;
import com.hs.service.Classify2Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Classify2)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/classify2")
public class Classify2Controller {
    /**
     * 服务对象
     */
    @Resource
    private Classify2Service classify2Service;

    /**
     * @author 陈伟明
     */
    @GetMapping("/findC2nameByC2id")
    public String findC2nameByC2id(int c2Id){
        Classify2 classify2 = classify2Service.selectById(c2Id);
        return classify2.getC2Name();
    }

    @RequestMapping("/queryAllClassify2")
    public List<Classify2> queryAllClassify2(){
        List<Classify2> classify2s = classify2Service.selectAll();
        return classify2s;
    }
    /**
     * gm
     * 查询所有数据
     * @return
     */
    @GetMapping("/findAll")
    public List<Classify2> findAll(){
        List<Classify2> classify2s = classify2Service.selectAll();
        return classify2s;
    }

    /**
     * gm
     * 通过c1_id查询所有数据
     * @param c1_id
     * @return
     */
    @GetMapping("/findIdAll")
    public List<Classify2> findByc1id(int c1_id){
        return classify2Service.selectByc1id(c1_id);
    }

    /**
     * gm
     * 添加二级标签
     * @param classify2
     * @return
     */
    @PostMapping("/addClassify2")
    public int addClassfy2(Classify2 classify2){
        return classify2Service.insert(classify2);
    }

    /**
     * gm
     * 二级标签的删除
     * 若不存在商品可执行删除
     * @param c2Id
     * @return
     */
    @GetMapping("/delectClassfy2")
    public int delectClassfy2(int c2Id){
        int i = classify2Service.deleteById(c2Id);
        return i;
    }
}