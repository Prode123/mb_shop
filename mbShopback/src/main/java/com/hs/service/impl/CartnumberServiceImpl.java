package com.hs.service.impl;

import com.hs.entity.Cartnumber;
import com.hs.mapper.CartnumberDao;
import com.hs.service.CartnumberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cartnumber表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("cartnumberService")
public class CartnumberServiceImpl implements CartnumberService {
    @Resource
    private CartnumberDao cartnumberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param numId 主键
     * @return 实例对象
     */
    @Override
    public Cartnumber selectById(Integer numId) {
        return this.cartnumberDao.selectById(numId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Cartnumber> selectPage(int start, int limit) {
        return this.cartnumberDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Cartnumber> selectAll() {
        return this.cartnumberDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Cartnumber> selectList(Cartnumber cartnumber) {
        return this.cartnumberDao.selectList(cartnumber);
    }
    
    /**
     * 新增数据
     *
     * @param cartnumber 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Cartnumber cartnumber) {
        return this.cartnumberDao.insert(cartnumber);
    }

    /**
     * 批量新增
     *
     * @param cartnumbers 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Cartnumber> cartnumbers) {
        return this.cartnumberDao.batchInsert(cartnumbers);
    }

    /**
     * 修改数据
     *
     * @param cartnumber 实例对象
     * @return 实例对象
     */
    @Override
    public Cartnumber update(Cartnumber cartnumber) {
        this.cartnumberDao.update(cartnumber);
        return this.selectById(cartnumber.getNumId());
    }

    /**
     * 通过主键删除数据
     *
     * @param numId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer numId) {
        return this.cartnumberDao.deleteById(numId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.cartnumberDao.count();
     }
}