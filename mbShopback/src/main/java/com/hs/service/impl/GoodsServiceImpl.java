package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Goods;
import com.hs.mapper.GoodsDao;
import com.hs.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Goods表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    @Override
    public Goods selectById(Integer gId) {
        return this.goodsDao.selectById(gId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> selectPage(int start, int limit) {
        return this.goodsDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public PageInfo<Goods> selectAll(int pageNum,int pageSize) {

         PageHelper.startPage(pageNum,pageSize);
         List<Goods> goods = goodsDao.selectAll();
         PageInfo pageInfo=new PageInfo(goods);
         return pageInfo;
     }

     public void findPhoto(){
         String gpic="D:\\img\\7d9d7072-f52e-4755-9411-3b003a9ecf0awallhaven-8ok7vk.jpg";
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Goods> selectList(Goods goods) {
        return this.goodsDao.selectList(goods);
    }
    
    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Goods goods) {
        return this.goodsDao.insert(goods);
    }

    /**
     * 批量新增
     *
     * @param goodss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Goods> goodss) {
        return this.goodsDao.batchInsert(goodss);
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Goods goods) {
        int i = this.goodsDao.update(goods);
        return i;
    }

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer gId) {
        return this.goodsDao.deleteById(gId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.goodsDao.count();
     }

    /**
     * 分页查询
     * 通过c2id查询相关数据
     * @param pageNum
     * @param pageSize
     * @param c2Id
     * @return
     */
    @Override
    public PageInfo<Goods> AllByStudent(int pageNum, int pageSize, int c2Id) {
        //1、设置pageHelper
        PageHelper.startPage(pageNum,pageSize);

        List<Goods> goods = goodsDao.selectByC2id(c2Id);

        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);


        return goodsPageInfo;
    }

    @Override
    public List<Goods> mHFindGoodsByInput1(String input1) {
        List<Goods> goods = goodsDao.mHFindGoodsByInput1(input1);
        return goods;
    }

    @Override
    public List<Goods> selectAll1() {
        List<Goods> goods = goodsDao.selectAll();
        return goods;
    }

    @Override
    public List<Goods> selectByC2id(Integer c2Id) {
        return goodsDao.selectByC2id(c2Id);
    }
}