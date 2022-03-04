package com.hs.service.impl;

import com.hs.entity.Payment;
import com.hs.mapper.PaymentDao;
import com.hs.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param payId 主键
     * @return 实例对象
     */
    @Override
    public Payment selectById(Integer payId) {
        return this.paymentDao.selectById(payId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Payment> selectPage(int start, int limit) {
        return this.paymentDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Payment> selectAll() {
        return this.paymentDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Payment> selectList(Payment payment) {
        return this.paymentDao.selectList(payment);
    }
    
    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Payment payment) {
        return this.paymentDao.insert(payment);
    }

    /**
     * 批量新增
     *
     * @param payments 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Payment> payments) {
        return this.paymentDao.batchInsert(payments);
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public Payment update(Payment payment) {
        this.paymentDao.update(payment);
        return this.selectById(payment.getPayId());
    }

    /**
     * 通过主键删除数据
     *
     * @param payId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer payId) {
        return this.paymentDao.deleteById(payId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.paymentDao.count();
     }
}