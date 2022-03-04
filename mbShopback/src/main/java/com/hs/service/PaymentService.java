package com.hs.service;

import com.hs.entity.Payment;
import java.util.List;
import java.util.Map;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param payId 主键
     * @return 实例对象
     */
    Payment selectById(Integer payId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Payment> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Payment> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param payment 实例对象
     * @return 对象列表
     */
    List<Payment> selectList(Payment payment);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);
	
	/**
     * 批量新增
     *
     * @param payments 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Payment> payments);
	
    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 修改
     */
    Payment update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param payId 主键
     * @return 影响行数
     */
    int deleteById(Integer payId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}