package com.hs.service.impl;

import com.hs.entity.Classify1;
import com.hs.entity.Classify2;
import com.hs.mapper.Classify1Dao;
import com.hs.mapper.Classify2Dao;
import com.hs.service.Classify1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Classify1表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("classify1Service")
public class Classify1ServiceImpl implements Classify1Service {
    @Resource
    private Classify1Dao classify1Dao;
    @Resource
    private Classify2Dao classify2Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param c1Id 主键
     * @return 实例对象
     */
    @Override
    public Classify1 selectById(Integer c1Id) {
        return this.classify1Dao.selectById(c1Id);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Classify1> selectPage(int start, int limit) {
        return this.classify1Dao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Classify1> selectAll() {
        return this.classify1Dao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Classify1> selectList(Classify1 classify1) {
        return this.classify1Dao.selectList(classify1);
    }
    
    /**
     * 新增数据
     *数据存在添加失败
     * @param classify1 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Classify1 classify1) {
        Classify1 byc1Name =null;
        int i = 0;
        try {
            byc1Name= classify1Dao.findByc1Name(classify1.getC1Name());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(byc1Name==null){
            return this.classify1Dao.insert(classify1);
        }
        return i;
    }

    /**
     * 批量新增
     *
     * @param classify1s 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Classify1> classify1s) {
        return this.classify1Dao.batchInsert(classify1s);
    }

    /**
     * 修改数据
     *
     * @param classify1 实例对象
     * @return 实例对象
     */
    @Override
    public Classify1 update(Classify1 classify1) {
        this.classify1Dao.update(classify1);
        return this.selectById(classify1.getC1Id());
    }

    /**
     * 通过主键删除数据
     * 查询二级标签是否有数据（无删除一级标签）
     * @param c1Id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer c1Id) {
        List<Classify2> classify2s = classify2Dao.selectByc1id(c1Id);
        System.out.println(classify2s.isEmpty());
        //一级标签下不存在二级标签  执行删除
        if(classify2s.isEmpty()){
            return this.classify1Dao.deleteById(c1Id);
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
        return this.classify1Dao.count();
     }
}