package com.hs.service;

import com.hs.entity.Classify2;
import java.util.List;
import java.util.Map;

/**
 * (Classify2)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface Classify2Service {

    /**
     * 通过ID查询单条数据
     *
     * @param c2Id 主键
     * @return 实例对象
     */
    Classify2 selectById(Integer c2Id);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Classify2> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Classify2> selectAll();

    /**
     * 通过c1_id查询数据
     * @param c1Id
     * @return
     */
    List<Classify2> selectByc1id(Integer c1Id);
    
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
     * @return 修改
     */
    Classify2 update(Classify2 classify2);

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