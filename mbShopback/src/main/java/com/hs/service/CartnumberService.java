package com.hs.service;

import com.hs.entity.Cartnumber;
import java.util.List;
import java.util.Map;

/**
 * (Cartnumber)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface CartnumberService {

    /**
     * 通过ID查询单条数据
     *
     * @param numId 主键
     * @return 实例对象
     */
    Cartnumber selectById(Integer numId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cartnumber> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Cartnumber> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param cartnumber 实例对象
     * @return 对象列表
     */
    List<Cartnumber> selectList(Cartnumber cartnumber);

    /**
     * 新增数据
     *
     * @param cartnumber 实例对象
     * @return 影响行数
     */
    int insert(Cartnumber cartnumber);
	
	/**
     * 批量新增
     *
     * @param cartnumbers 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Cartnumber> cartnumbers);
	
    /**
     * 修改数据
     *
     * @param cartnumber 实例对象
     * @return 修改
     */
    Cartnumber update(Cartnumber cartnumber);

    /**
     * 通过主键删除数据
     *
     * @param numId 主键
     * @return 影响行数
     */
    int deleteById(Integer numId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}