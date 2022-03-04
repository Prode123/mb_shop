package com.hs.mapper;

import com.hs.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    User selectById(Integer uId);

    /**
     * 通过ID查询单条数据
     *
     * @param uTel
     * @return 实例对象
     */
    User selectByTel(String uTel);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<User> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> selectList(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);
	
	/**
     * 批量新增
     *
     * @param users 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<User> users);
	
    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 影响行数
     */
    int deleteById(Integer uId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 登录查询头像
     * 新增 登录后查询头像和用户名
     * @author lt
     * @param uTel
     * @return
     */
    User txSelect(String uTel);

    /**
     * 用户注册
     * @author lt
     */
    int register(User user);
}