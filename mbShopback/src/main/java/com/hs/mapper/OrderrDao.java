package com.hs.mapper;

import com.hs.entity.BaoBiao;
import com.hs.entity.Logistics;
import com.hs.entity.Orderr;
import com.hs.tools.LogisticsTools;
import com.hs.tools.OrderTool;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Orderr)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
public interface OrderrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    Orderr selectById(Integer oId);

    /**
     * 通过uid和o3查询单个
     */
    Orderr selectByUidAndO3(Orderr orderr);
	
    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orderr> selectPage(@Param("start") int start, @Param("limit") int limit);

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
     * 通过条件查询并分页
     * @param orderTool
     * @return
     */
    List<Orderr> selectListWithTime(OrderTool orderTool);

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
     * @return 影响行数
     */
    int update(Orderr orderr);

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
     * 查询排行前5的订单信息
     * @return
     */
    List<BaoBiao> findAllbb();
}