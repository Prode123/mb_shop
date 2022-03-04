package com.hs.mapper;

import com.hs.entity.Merchant;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Merchant)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface MerchantDao {

    /**
     * 通过ID查询单条数据
     *
     * @param mId 主键
     * @return 实例对象
     */
    Merchant selectById(Integer mId);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Merchant> selectPage(@Param("start") int start, @Param("limit") int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Merchant> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param merchant 实例对象
     * @return 对象列表
     */
    List<Merchant> selectList(Merchant merchant);

    /**
     * 新增数据
     *
     * @param merchant 实例对象
     * @return 影响行数
     */
    int insert(Merchant merchant);
	
	/**
     * 批量新增
     *
     * @param merchants 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Merchant> merchants);
	
    /**
     * 修改数据
     *
     * @param merchant 实例对象
     * @return 影响行数
     */
    int update(Merchant merchant);

    /**
     * 通过主键删除数据
     *
     * @param mId 主键
     * @return 影响行数
     */
    int deleteById(Integer mId);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 通过手机号查询密码,仅用于登录
     * @param mTel
     * @author lt
     */
    Merchant querryByTel(String mTel);
}