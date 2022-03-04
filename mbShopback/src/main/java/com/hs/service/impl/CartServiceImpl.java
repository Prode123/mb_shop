package com.hs.service.impl;

import com.hs.entity.Cart;
import com.hs.mapper.CartDao;
import com.hs.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    @Override
    public Cart selectById(Integer carId) {
        return this.cartDao.selectById(carId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Cart> selectPage(int start, int limit) {
        return this.cartDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Cart> selectAll() {
        return this.cartDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Cart> selectList(Cart cart) {
        return this.cartDao.selectList(cart);
    }
    
    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Cart cart) {
        return this.cartDao.insert(cart);
    }

    /**
     * 批量新增
     *
     * @param carts 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Cart> carts) {
        return this.cartDao.batchInsert(carts);
    }

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart update(Cart cart) {
        this.cartDao.update(cart);
        return this.selectById(cart.getCarId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer carId) {
        return this.cartDao.deleteById(carId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.cartDao.count();
     }

    /**
     * 批量修改数据1
     *
     */
    @Override
    public int updateDaoCar1(Integer[] array) {
        return cartDao.updateDaoCar1(array);
    }

    /**
     * 批量修改数据1
     *
     */
    @Override
    public int updateDaoCar1To0(Cart cart) {
        return cartDao.updateDaoCar1To0(cart);
    }
}