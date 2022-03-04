package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.Logistics;
import com.hs.mapper.LogisticsDao;
import com.hs.service.LogisticsService;
import com.hs.tools.LogisticsTools;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Logistics表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("logisticsService")
public class LogisticsServiceImpl implements LogisticsService {
    @Resource
    private LogisticsDao logisticsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    @Override
    public Logistics selectById(Integer logId) {
        return this.logisticsDao.selectById(logId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Logistics> selectPage(int start, int limit) {
        return this.logisticsDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Logistics> selectAll() {
        return this.logisticsDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Logistics> selectList(Logistics logistics) {
        return this.logisticsDao.selectList(logistics);
    }
    
    /**
     * 新增数据
     *
     * @param logistics 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Logistics logistics) {
        return this.logisticsDao.insert(logistics);
    }

    /**
     * 批量新增
     *
     * @param logisticss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Logistics> logisticss) {
        return this.logisticsDao.batchInsert(logisticss);
    }

    /**
     * 修改数据
     *
     * @param logistics 实例对象
     * @return 实例对象
     */
    @Override
    public Logistics update(Logistics logistics) {
        this.logisticsDao.update(logistics);
        return this.selectById(logistics.getLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer logId) {
        return this.logisticsDao.deleteById(logId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.logisticsDao.count();
     }

    /**
     * 使用pageHelper分页查询
     */
    @Override
    public PageInfo<Logistics> selectByPageHelper(LogisticsTools log, int page, int num) {
        PageHelper.startPage(page, num);
        List<Logistics> logisticsList = logisticsDao.selectListWithTime(log);
        return new PageInfo<>(logisticsList);
    }

    @Override
    public Logistics selectByOid(int oid) {
        Logistics logistics = logisticsDao.selectLogisticsByOid(oid);
        return logistics;
    }
}