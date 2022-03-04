package com.hs.mapper;

import com.hs.entity.Shoppingimg;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Shoppingimg)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface ShoppingimgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param picId 主键
     * @return 实例对象
     */
    Shoppingimg selectById(Integer picId);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shoppingimg> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Shoppingimg> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param shoppingimg 实例对象
     * @return 对象列表
     */
    List<Shoppingimg> selectList(Shoppingimg shoppingimg);

    /**
     * 新增数据
     *
     * @param shoppingimg 实例对象
     * @return 影响行数
     */
    int insert(Shoppingimg shoppingimg);
	
	/**
     * 批量新增
     *
     * @param shoppingimgs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Shoppingimg> shoppingimgs);
	
    /**
     * 修改数据
     *
     * @param shoppingimg 实例对象
     * @return 影响行数
     */
    int update(Shoppingimg shoppingimg);

    /**
     * 通过主键删除数据
     *
     * @param picId 主键
     * @return 影响行数
     */
    int deleteById(Integer picId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    List<Shoppingimg> findShoppingimgByGid(int gid);
}