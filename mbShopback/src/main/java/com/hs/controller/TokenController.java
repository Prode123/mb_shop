package com.hs.controller;

import com.hs.entity.Token;
import com.hs.service.TokenService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;

/**
 * (Token)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    /**
     * 服务对象
     */
    @Resource
    private TokenService tokenService;

    
}