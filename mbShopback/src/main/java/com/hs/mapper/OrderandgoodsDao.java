package com.hs.mapper;

import com.hs.entity.Orderandgoods;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Orderandgoods)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface OrderandgoodsDao {

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
    List<Orderandgoods> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Orderandgoods> selectAll();

    /**
     * 查询全部包括goods
     *
     * @return 对象列表
     */
    List<Orderandgoods> selectAllWithGoods(Orderandgoods orderandgoods);
    
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
     * @return 影响行数
     */
    int update(Orderandgoods orderandgoods);

    /**
     * 通过主键删除数据
     *
     * @param oagId 主键
     * @return 影响行数
     */
    int deleteById(Integer oagId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    int deleteByOid(int oid);

    Orderandgoods selectById1(Integer oid);
}