package com.hs.service;

import com.hs.entity.Cart;
import java.util.List;
import java.util.Map;

/**
 * (Cart)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface CartService {

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    Cart selectById(Integer carId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cart> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Cart> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param cart 实例对象
     * @return 对象列表
     */
    List<Cart> selectList(Cart cart);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int insert(Cart cart);
	
	/**
     * 批量新增
     *
     * @param carts 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Cart> carts);
	
    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 修改
     */
    Cart update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 影响行数
     */
    int deleteById(Integer carId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 批量修改数据1
     *
     */
    int updateDaoCar1(Integer[] array);

    /**
     * 批量修改数据1将其置零
     *
     */
    int updateDaoCar1To0(Cart cart);
}