package com.hs.service;

import com.hs.entity.Token;
import java.util.List;
import java.util.Map;

/**
 * (Token)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface TokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    Token selectById(Integer tId);

    /**
     * 通过ID查询单条数据
     *
     * @param tVal 主键
     * @return 实例对象
     */
    Token selectByUUID(String tVal);

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    Token selectByuId(Integer uId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Token> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Token> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param token 实例对象
     * @return 对象列表
     */
    List<Token> selectList(Token token);

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 影响行数
     */
    int insert(Token token);
	
	/**
     * 批量新增
     *
     * @param tokens 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Token> tokens);
	
    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 修改
     */
    Token update(Token token);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 影响行数
     */
    int deleteById(Integer tId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 通过tVal删除token表 用于商家退出登录
     * @author lt
     */
    int deleteTokenByTval(String tVal);

    /**
     * 登录业务时，将实体类token的值插入到token表 主要是插入status和uid
     * @author lt
     */
    int tokenUpdateBytVal(Token token);
}