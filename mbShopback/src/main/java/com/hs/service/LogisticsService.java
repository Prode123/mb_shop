package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Logistics;
import com.hs.tools.LogisticsTools;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Logistics)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface LogisticsService {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    Logistics selectById(Integer logId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Logistics> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Logistics> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param logistics 实例对象
     * @return 对象列表
     */
    List<Logistics> selectList(Logistics logistics);



    /**
     * 新增数据
     *
     * @param logistics 实例对象
     * @return 影响行数
     */
    int insert(Logistics logistics);
	
	/**
     * 批量新增
     *
     * @param logisticss 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Logistics> logisticss);
	
    /**
     * 修改数据
     *
     * @param logistics 实例对象
     * @return 修改
     */
    Logistics update(Logistics logistics);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(Integer logId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 使用pageHelper分页查询
     */

    PageInfo<Logistics> selectByPageHelper(LogisticsTools log, int page, int num);

    Logistics selectByOid(int oid);
}