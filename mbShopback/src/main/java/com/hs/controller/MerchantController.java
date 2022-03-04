package com.hs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Merchant;
import com.hs.entity.ResponseEntity;
import com.hs.entity.Token;
import com.hs.entity.User;
import com.hs.service.MerchantService;
import com.hs.service.TokenService;
import com.hs.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Merchant)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/merchant")
public class MerchantController {


    /**
     * 服务对象
     */
    @Resource
    private MerchantService merchantService;
    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;

    /**
     * 商家通过手机号登录
     *
     * @author lt
     */
    @RequestMapping("/login")
    public ResponseEntity merchantLogin(Merchant merchant, HttpServletResponse resp){
        ResponseEntity res =new ResponseEntity();
//        System.out.println(merchant);
        Merchant merchant1 = merchantService.querryByTel(merchant.getMTel());
//        System.out.println(merchant1.getMName()+"llllllllllllllllllllllll");
        //密码不能为空 前端校验
        //正确返回1登录成功
        if(merchant.getMPasswd().equals(merchant1.getMPasswd())){
            String t_val = resp.getHeader("token");
            Token token = tokenService.selectByUUID(t_val);
           //用于展示的名字
            token.setT1(merchant1.getMName());
             res.setStatus(1);
             res.setData(token);
             return res;
        }
        //密码错误返回2
        else
            res.setStatus(2);
             res.setMessage("用户名或密码错误");
             return res;
    }
    /**
     * 退出登录清除token
     *
     */
    @RequestMapping("/loginOut")
    public int loginOut(HttpServletResponse response){
        String tVal = response.getHeader("token");
        return tokenService.deleteTokenByTval(tVal);
    }
    /**
     * @author lt
     * 商家对用户的查询
     * @return
     */
    @RequestMapping("/findAllUserPage")
    public PageInfo findAllUserPage(int start, int limit){
//        //       一定要在查询之前，设置pageNum和pageSize
//        System.out.println(start+"aaaaaaaaaaaaaaaaaaaaaa");
        PageHelper.startPage(start,limit);
        List<User> users = userService.selectAll();
        com.github.pagehelper.PageInfo  pageInfo=new com.github.pagehelper.PageInfo(users);
        return pageInfo;
    }

    /**
     * 商家操作通过用户id删除用户
     * @author lt
     */
    @RequestMapping("/deleteByUserId")
    public int deleteByUserId(int id){
        return userService.deleteById(id);
    }


    /**
     * 商家通过id修改用户状态
     * @author lt
     */
    @RequestMapping("/updateByUserId")
    public int updateByUserId(Integer id,String u1 ){
//        System.out.println(u1+"aaaaaaaaaaaaaaaaaaaaaaaaaa");
        return userService.updateByUserId(id,u1);
    }
    /**
     *商家通过用户名进行分页查询
     * @param start
     * @param limit
     * @param uUsername
     * @return PageInfo
     * @author lt
     */
    @RequestMapping("/findOneUserById")
    public PageInfo findOneUserById(int start, int limit,String uUsername){
        PageHelper.startPage(start,limit);
//        System.out.println("start:"+start+"  limit:"+limit+"  uName"+uUsername);
        User user=new User();
        user.setUUsername(uUsername);
        List<User> users = userService.selectList(user);
        for (User user1 : users) {
            System.out.println(user1);
            System.out.println("passwd is "+user1.getUPasswd());
        }
        com.github.pagehelper.PageInfo  pageInfo=new com.github.pagehelper.PageInfo(users);
        return pageInfo;
    }

    /**
     * test
     */
    public void test1(){
        System.out.println("something");
    }
}