package com.hs.service.impl;

import com.hs.entity.Classify2;
import com.hs.entity.Goods;
import com.hs.mapper.Classify2Dao;
import com.hs.mapper.GoodsDao;
import com.hs.service.Classify2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classify2表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("classify2Service")
public class Classify2ServiceImpl implements Classify2Service {
    @Resource
    private Classify2Dao classify2Dao;
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param c2Id 主键
     * @return 实例对象
     */
    @Override
    public Classify2 selectById(Integer c2Id) {
        return this.classify2Dao.selectById(c2Id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Classify2> selectPage(int start, int limit) {
        return this.classify2Dao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Classify2> selectAll() {
        return this.classify2Dao.selectAll();
     }

    /**
     * gm
     * 通过c1Id查询c1Id的下所有标签
     * @param c1Id
     * @return
     */
    @Override
    public List<Classify2> selectByc1id(Integer c1Id) {
        return classify2Dao.selectByc1id(c1Id);
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Classify2> selectList(Classify2 classify2) {
        return this.classify2Dao.selectList(classify2);
    }
    
    /**
     * 新增数据
     *
     * @param classify2 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Classify2 classify2) {
        Classify2 classify21 = null;
        System.out.println("二级标签添加");
        int i=0;
        try{
            classify21= classify2Dao.selectByName(classify2.getC2Name());
        }catch (Exception e){
            e.printStackTrace();
        }
        //二级标签不存在  添加
        if(classify21==null){
            return this.classify2Dao.insert(classify2);
        }
        return i;
    }

    /**
     * 批量新增
     *
     * @param classify2s 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Classify2> classify2s) {
        return this.classify2Dao.batchInsert(classify2s);
    }

    /**
     * 修改数据
     *
     * @param classify2 实例对象
     * @return 实例对象
     */
    @Override
    public Classify2 update(Classify2 classify2) {
        this.classify2Dao.update(classify2);
        return this.selectById(classify2.getC2Id());
    }

    /**
     * 通过主键删除数据
     *
     * @param c2Id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer c2Id) {

        List<Goods> goods = goodsDao.selectByC2id(c2Id);
        System.out.println(goods.isEmpty());
        //一级标签下不存在商品  执行删除
        if(goods.isEmpty()){
            return this.classify2Dao.deleteById(c2Id);
        }

        return 0;

    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.classify2Dao.count();
     }
}