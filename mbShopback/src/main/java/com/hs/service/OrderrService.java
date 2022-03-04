package com.hs.service;

import com.github.pagehelper.PageInfo;
import com.hs.entity.BaoBiao;
import com.hs.entity.Orderr;
import com.hs.tools.OrderTool;

import java.util.List;
import java.util.Map;

/**
 * (Orderr)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface OrderrService {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orderr selectById(Integer oId);

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orderr> selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<Orderr> selectAll();
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderr 实例对象
     * @return 对象列表
     */
    List<Orderr> selectList(Orderr orderr);

    /**
     * 新增数据
     *
     * @param orderr 实例对象
     * @return 影响行数
     */
    int insert(Orderr orderr);
	
	/**
     * 批量新增
     *
     * @param orderrs 实例对象的集合
     * @return 影响行数
     */
	int batchInsert(List<Orderr> orderrs);
	
    /**
     * 修改数据
     *
     * @param orderr 实例对象
     * @return 修改
     */
    Orderr update(Orderr orderr);


    Orderr update1(Orderr orderr);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 影响行数
     */
    int deleteById(Integer oId);
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();

    /**
     * 使用pageHelper分页查询
     */
    PageInfo<Orderr> selectByPageHelper(OrderTool orderTool, int page, int num);

    /**
     * 查询订单前5的信息
     * @return
     */
    List<BaoBiao> findAllBB();
}