package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.Goods;
import java.util.List;
import java.util.Map;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    Goods selectById(Integer gId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    PageInfo<Goods> selectAll(int pageNum,int pageSize);
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    List<Goods> selectList(Goods goods);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);
	
	/**
     * 批量新增
     *
     * @param goodss 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Goods> goodss);
	
    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 修改
     */
    int update(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param gId 主键
     * @return 影响行数
     */
    int deleteById(Integer gId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 分页查询
     * 通过c2Id查询相关数据
     * @param pageNum
     * @param pageSize
     * @param c2Id
     * @return
     */
    PageInfo<Goods> AllByStudent(int pageNum, int pageSize,int c2Id);


    List<Goods> mHFindGoodsByInput1(String input1);

    List<Goods> selectAll1();

    /**
     * GM
     * 通过c2Id  查询相对应的商品
     * @param c2Id
     * @return
     */
    List<Goods> selectByC2id(Integer c2Id);
}