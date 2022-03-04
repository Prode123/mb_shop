package com.hs.service.impl;

import com.hs.entity.Shoppingimg;
import com.hs.mapper.ShoppingimgDao;
import com.hs.service.ShoppingimgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shoppingimg表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("shoppingimgService")
public class ShoppingimgServiceImpl implements ShoppingimgService {
    @Resource
    private ShoppingimgDao shoppingimgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param picId 主键
     * @return 实例对象
     */
    @Override
    public Shoppingimg selectById(Integer picId) {
        return this.shoppingimgDao.selectById(picId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Shoppingimg> selectPage(int start, int limit) {
        return this.shoppingimgDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Shoppingimg> selectAll() {
        return this.shoppingimgDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Shoppingimg> selectList(Shoppingimg shoppingimg) {
        return this.shoppingimgDao.selectList(shoppingimg);
    }
    
    /**
     * 新增数据
     *
     * @param shoppingimg 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Shoppingimg shoppingimg) {
        return this.shoppingimgDao.insert(shoppingimg);
    }

    /**
     * 批量新增
     *
     * @param shoppingimgs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Shoppingimg> shoppingimgs) {
        return this.shoppingimgDao.batchInsert(shoppingimgs);
    }

    /**
     * 修改数据
     *
     * @param shoppingimg 实例对象
     * @return 实例对象
     */
    @Override
    public Shoppingimg update(Shoppingimg shoppingimg) {
        this.shoppingimgDao.update(shoppingimg);
        return this.selectById(shoppingimg.getPicId());
    }

    /**
     * 通过主键删除数据
     *
     * @param picId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer picId) {
        return this.shoppingimgDao.deleteById(picId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.shoppingimgDao.count();
     }

    @Override
    public List<Shoppingimg> findShoppingimgByGid(int gid) {
        List<Shoppingimg> shoppingimgByGid = this.shoppingimgDao.findShoppingimgByGid(gid);
        return shoppingimgByGid;
    }
}