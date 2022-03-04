package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Orderandgoods;
import java.util.List;
import java.util.Map;

/**
 * (Orderandgoods)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface OrderandgoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param oagId 主键
     * @return 实例对象
     */
    Orderandgoods selectById(Integer oagId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orderandgoods> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Orderandgoods> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderandgoods 实例对象
     * @return 对象列表
     */
    List<Orderandgoods> selectList(Orderandgoods orderandgoods);

    /**
     * 新增数据
     *
     * @param orderandgoods 实例对象
     * @return 影响行数
     */
    int insert(Orderandgoods orderandgoods);
	
	/**
     * 批量新增
     *
     * @param orderandgoodss 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Orderandgoods> orderandgoodss);
	
    /**
     * 修改数据
     *
     * @param orderandgoods 实例对象
     * @return 修改
     */
    Orderandgoods update(Orderandgoods orderandgoods);

    /**
     * 通过主键删除数据
     *
     * @param oagId 主键
     * @return 影响行数
     */
    int deleteById(Integer oagId);

    int deleteByOid(int oid);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    Orderandgoods selectById1(Integer oid);


    /**
     * 包括goods的分页查询
     */
    PageInfo<Orderandgoods> selectAllPaging(Orderandgoods orderandgoods, int page, int num);
}