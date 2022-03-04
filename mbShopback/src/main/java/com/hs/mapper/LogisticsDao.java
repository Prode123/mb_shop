package com.hs.mapper;

import com.hs.entity.Logistics;
import com.hs.tools.LogisticsTools;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * (Logistics)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface LogisticsDao {

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
    List<Logistics> selectPage(@Param("start") int start, @Param("limit") int limit);

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

    List<Logistics> selectListWithTime(LogisticsTools log);

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
     * @return 影响行数
     */
    int update(Logistics logistics);

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

    Logistics selectLogisticsByOid(int oid);
}