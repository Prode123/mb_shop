package com.hs.mapper;

import com.hs.entity.Classify1;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Classify1)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface Classify1Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param c1Id 主键
     * @return 实例对象
     */
    Classify1 selectById(Integer c1Id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Classify1> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Classify1> selectAll();

    /**
     * gm
     * 通过一级标签名字（c1Name）判断是否存在
     * @param c1Name
     * @return
     */
    Classify1 findByc1Name(String c1Name);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param classify1 实例对象
     * @return 对象列表
     */
    List<Classify1> selectList(Classify1 classify1);

    /**
     * 新增数据
     *
     * @param classify1 实例对象
     * @return 影响行数
     */
    int insert(Classify1 classify1);
	
	/**
     * 批量新增
     *
     * @param classify1s 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Classify1> classify1s);
	
    /**
     * 修改数据
     *
     * @param classify1 实例对象
     * @return 影响行数
     */
    int update(Classify1 classify1);

    /**
     * 通过主键删除数据
     *
     * @param c1Id 主键
     * @return 影响行数
     */
    int deleteById(Integer c1Id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}