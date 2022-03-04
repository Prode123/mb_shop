package com.hs.service.impl;

import com.hs.entity.User;
import com.hs.mapper.UserDao;
import com.hs.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public User selectById(Integer uId) {
        return this.userDao.selectById(uId);
    }

    @Override
    public User selectByTel(User user) {
//        User user1 = userDao.selectByTel(user.getUTel());
//        if (user1 == null) {
//            return 0;//没有该用户
//        } else if (user1.getUPasswd().equals(user.getUPasswd())) {
//            return 1;//登录成功
//        } else {
//            return 2;//登录失败
//        }
        return userDao.selectByTel(user.getUTel());

    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> selectPage(int start, int limit) {
        return this.userDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<User> selectAll() {
        return this.userDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<User> selectList(User user) {
        return this.userDao.selectList(user);
    }
    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 批量新增
     *
     * @param users 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<User> users) {
        return this.userDao.batchInsert(users);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.selectById(user.getUId());
    }


    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer uId) {
        return this.userDao.deleteById(uId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.userDao.count();
     }

    /**
     * 商家通过id修改用户状态
     * @author lt
     */
    @Override
    public int updateByUserId(Integer id,String u1) {
        User user=new User();
        user.setUId(id);
        user.setU1(u1);
        return userDao.update(user);
    }
    /**
     * 登录查询头像
     * 新增 登录后查询头像和用户名
     * @author lt
     * @param uTel
     * @return
     */
    @Override
    public User txSelect(String uTel) {
        return userDao.selectByTel(uTel);
    }

    /**
     * 修改个人数据
     * @return int
     * @author lt
     *
     */
    @Override
    public int updateUser(User user) {
        return this.userDao.update(user);
    }
    /**
     * 用户注册
     * @author lt
     */

    @Override
    public int register(User user) {
        return userDao.register(user);
    }


}