package com.hs.controller;

import com.hs.entity.Cartnumber;
import com.hs.service.CartnumberService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Cartnumber)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/cartnumber")
public class CartnumberController {
    /**
     * 服务对象
     */
    @Resource
    private CartnumberService cartnumberService;


    
}