package com.hs.controller;

import com.hs.entity.Classify1;
import com.hs.service.Classify1Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Classify1)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/classify1")
public class Classify1Controller {
    /**
     * 服务对象
     */
    @Resource
    private Classify1Service classify1Service;

    /**
     * 查询所有一级标签
     * @return
     */
    @GetMapping("/findAll")
    public List<Classify1> findAllClassify1(){
        System.out.println(1254);
        List<Classify1> classify1s = classify1Service.selectAll();
        return classify1s;
    }

//    @RequestMapping("/findAll")
//    public List<Classify1> findByidClassify1(){
//        List<Classify1> classify1s = classify1Service.selectAll();
//        return classify1s;
//    }

    /**
     * 添加一级标签
     * @param classify1
     * @return
     */
    @PostMapping("/addClassify1")
    public int addClassify1(Classify1 classify1) {
        System.out.println(154);
        System.out.println(classify1.getC1Name());
        int i = classify1Service.insert(classify1);
        return i;
    }

    /**
     * 删除一级标签
     * @param c1Id
     * @return
     */
    @GetMapping("/deleteClassif1")
    public int deleteClaaify1(int c1Id){
        return classify1Service.deleteById(c1Id);
    }

}