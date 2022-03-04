package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Orderandgoods;
import com.hs.mapper.OrderandgoodsDao;
import com.hs.service.OrderandgoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderandgoods表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("orderandgoodsService")
public class OrderandgoodsServiceImpl implements OrderandgoodsService {
    @Resource
    private OrderandgoodsDao orderandgoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param oagId 主键
     * @return 实例对象
     */
    @Override
    public Orderandgoods selectById(Integer oagId) {
        return this.orderandgoodsDao.selectById(oagId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orderandgoods> selectPage(int start, int limit) {
        return this.orderandgoodsDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Orderandgoods> selectAll() {
        return this.orderandgoodsDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Orderandgoods> selectList(Orderandgoods orderandgoods) {
        return this.orderandgoodsDao.selectList(orderandgoods);
    }
    
    /**
     * 新增数据
     *
     * @param orderandgoods 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Orderandgoods orderandgoods) {
        return this.orderandgoodsDao.insert(orderandgoods);
    }

    /**
     * 批量新增
     *
     * @param orderandgoodss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Orderandgoods> orderandgoodss) {
        return this.orderandgoodsDao.batchInsert(orderandgoodss);
    }

    /**
     * 修改数据
     *
     * @param orderandgoods 实例对象
     * @return 实例对象
     */
    @Override
    public Orderandgoods update(Orderandgoods orderandgoods) {
        this.orderandgoodsDao.update(orderandgoods);
        return this.selectById(orderandgoods.getOagId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oagId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer oagId) {
        return this.orderandgoodsDao.deleteById(oagId);
    }

    @Override
    public int deleteByOid(int oid) {
        int i = orderandgoodsDao.deleteByOid(oid);
        return i;
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.orderandgoodsDao.count();
     }

    @Override
    public Orderandgoods selectById1(Integer oid) {
        Orderandgoods orderandgoods = orderandgoodsDao.selectById1(oid);
        return orderandgoods;
    }

    @Override
    public PageInfo<Orderandgoods> selectAllPaging(Orderandgoods orderandgoods, int page, int num) {
        PageHelper.startPage(page, num);
        List<Orderandgoods> orderandgoods1 = orderandgoodsDao.selectAllWithGoods(orderandgoods);
        return new PageInfo<>(orderandgoods1);
    }
}