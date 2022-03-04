package com.hs.mapper;

import com.hs.entity.Classify1;
import com.hs.entity.Classify2;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Classify2)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface  Classify2Dao {

    /**
     * 通过ID查询单条数据
     *
     * @param c2Id 主键
     * @return 实例对象
     */
    Classify2 selectById(Integer c2Id);

    /**
     * 通过name查询单条数据(判断数据是否存在)
     * @param c2Name
     * @return
     */
    Classify2 selectByName(String c2Name);

    /**
     * 通过一级标签查询所有二级标签
     * gm
     * @param c1Id
     * @return
     */
    List<Classify2> selectByc1id(Integer c1Id);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Classify2> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Classify2> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param classify2 实例对象
     * @return 对象列表
     */
    List<Classify2> selectList(Classify2 classify2);

    /**
     * 新增数据
     *
     * @param classify2 实例对象
     * @return 影响行数
     */
    int insert(Classify2 classify2);
	
	/**
     * 批量新增
     *
     * @param classify2s 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Classify2> classify2s);
	
    /**
     * 修改数据
     *
     * @param classify2 实例对象
     * @return 影响行数
     */
    int update(Classify2 classify2);

    /**
     * 通过主键删除数据
     *
     * @param c2Id 主键
     * @return 影响行数
     */
    int deleteById(Integer c2Id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();



}