package com.hs.controller;

import com.hs.entity.ResponseEntity;
import com.hs.entity.Token;
import com.hs.entity.User;
import com.hs.service.TokenService;
import com.hs.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (User)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private TokenService tokenService;

    /**
     *
     * @param user
     * @param resp
     * @author zf
     * @return
     */
    @RequestMapping("/login")
    public ResponseEntity<Token> userLogin(User user, HttpServletResponse resp) {
        //创建实体类token接收前端传过来的token
        Token token=new Token();
        token.setTVal(resp.getHeader("token"));
        ResponseEntity<Token> responseEntity = new ResponseEntity<>();
        //判断登录是否成功
        User user1 = userService.selectByTel(user);
        if (user1 == null|| !user1.getU1().equals("1")) {
            //将status置为0 返回给前端 0仅表示没有该用户或账号已被冻结
            token.setUStatus(0);
            //通过token的值将status和uid插入到token表   
            tokenService.tokenUpdateBytVal(token);
            //通过token取出status和uid  先从数据库中查询 直接给前端
            Token token1 = tokenService.selectByUUID(token.getTVal());
            responseEntity.setStatus(token1.getUStatus());
            responseEntity.setMessage("没有该用户或账号已被冻结");
            responseEntity.setData(token);
        }

        else if (user.getUPasswd().equals(user1.getUPasswd())){
            token.setUStatus(1);
            token.setUId(user1.getUId());
           //token的status是1，表示已登录
            //如果登录成功将uid和登录状态插入到token表中
            tokenService.tokenUpdateBytVal(token);
            //通过token取出status和uid  先从数据库中查询 直接给前端
            Token token1 = tokenService.selectByUUID(token.getTVal());
            responseEntity.setStatus(token1.getUStatus());
            responseEntity.setMessage("登录成功");
            responseEntity.setData(token);
        }else {
            token.setUStatus(2);
            tokenService.tokenUpdateBytVal(token);
            //通过token取出status和uid  先从数据库中查询 直接给前端
            Token token1 = tokenService.selectByUUID(token.getTVal());
            responseEntity.setStatus(token1.getUStatus());
            responseEntity.setMessage("密码错误");
            responseEntity.setData(token);
        }
        return responseEntity;
    }

    /**
     * 查询头像 可用于登录页面的头像验证 也可用于个人资料的头像展示
     * 新增 查询用户名 用于登录后的显示
     * @author lt
     */
      @RequestMapping("/txSelect")
      public ResponseEntity txSelect (User user) throws NullPointerException{
//          System.out.println(uTel);
//          通过手机号查询到这个用户
          User user1 = userService.txSelect( user.getUTel());

//          u2为头像地址
          String u2 = user1.getU2();
//          查询到用户名
          String name = user1.getUUsername();
          ResponseEntity responseEntity=new ResponseEntity();
          if(name!=null){
          responseEntity.setMessage(u2);
          responseEntity.setStatus(1);
          responseEntity.setData(user1);
           }
          if(name==null){
                  responseEntity.setStatus(0);
          }
          return responseEntity;
      }
    /**
     * 个人资料的修改
     * @author lt
     */
    @RequestMapping("/updateUser")
    public ResponseEntity updateUser(User user){
        ResponseEntity responseEntity=new ResponseEntity();
        User user1 = userService.update(user);
        if (user1!=null) {
            responseEntity.setStatus(1);
            responseEntity.setData(user1);
        }
        else
        {
             responseEntity.setStatus(0);
             responseEntity.setData(user);
        }
             return responseEntity;
        }

    /**
     * 用户注册 手机号唯一查询
     * @author lt
     */
    @RequestMapping("/selectTelExist")
    public ResponseEntity selectTelExist(User user){
        ResponseEntity responseEntity=new ResponseEntity();

        User user1 = userService.selectByTel(user);
        if(user1!=null){
            responseEntity.setStatus(0);
            responseEntity.setMessage("手机号已注册");
        }
        else {
            responseEntity.setStatus(1);
            responseEntity.setMessage("手机号未注册");
        }
        return responseEntity;
    }

    /**
     * 用户注册
     * @author lt
     */
     @RequestMapping("/register")
    public ResponseEntity register(User user){
         user.setU1("1");
         user.setU2("http://localhost/img/tx/tx.png");
         ResponseEntity responseEntity=new ResponseEntity();

         User user1 = userService.selectByTel(user);
         if(user1!=null){
//             手机号已存在
             responseEntity.setStatus(0);
             responseEntity.setMessage("手机号已存在");
         }
          else{
             int i = userService.register(user);
             if(i==1){
                 // 注册成功
                 responseEntity.setStatus(1);
                 responseEntity.setMessage("注册成功");
             }
             else {
                 responseEntity.setStatus(2);
                 responseEntity.setMessage("注册失败");
             }
         }

         return responseEntity;

     }

    /**
     * 修改密码
     * @author lt
     */
    @RequestMapping("/updatePasswd")
    public int updatePasswd(String npasswd,String passwd,User user){

//      通过id查询单个 和原密码比较
        User user1 = userService.selectById(user.getUId());
        if(!user1.getUPasswd().equals(passwd)){
//            密码错误
            return 0;
        }
        else{
            user.setUId(user.getUId());
            user.setUPasswd(npasswd);
            int i = userService.updateUser(user);
            if(i==1){
//            修改成功
              return 1;
            }else
//            修改失败
              return 2;
    }
    }


}