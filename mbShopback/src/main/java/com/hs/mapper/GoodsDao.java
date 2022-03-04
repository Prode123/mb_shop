package com.hs.mapper;

import com.hs.entity.Goods;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface GoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gId 主键
     * @return 实例对象
     */
    Goods selectById(Integer gId);

    /**
     * 通过c2Id查询符合的所有数据
     * @param c2Id
     * @return
     */
    List<Goods> selectByC2id(Integer c2Id);


    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Goods> selectAll();
    
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
     * @return 影响行数
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
     * 模糊查询
     */
    List<Goods> mHFindGoodsByInput1(String input1);
}