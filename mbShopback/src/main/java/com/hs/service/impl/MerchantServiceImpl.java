package com.hs.service.impl;

import com.hs.entity.Merchant;
import com.hs.mapper.MerchantDao;
import com.hs.service.MerchantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Merchant表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {
    @Resource
    private MerchantDao merchantDao;

    /**
     * 通过ID查询单条数据
     *
     * @param mId 主键
     * @return 实例对象
     */
    @Override
    public Merchant selectById(Integer mId) {
        return this.merchantDao.selectById(mId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Merchant> selectPage(int start, int limit) {
        return this.merchantDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Merchant> selectAll() {
        return this.merchantDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Merchant> selectList(Merchant merchant) {
        return this.merchantDao.selectList(merchant);
    }
    
    /**
     * 新增数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Merchant merchant) {
        return this.merchantDao.insert(merchant);
    }

    /**
     * 批量新增
     *
     * @param merchants 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Merchant> merchants) {
        return this.merchantDao.batchInsert(merchants);
    }

    /**
     * 修改数据
     *
     * @param merchant 实例对象
     * @return 实例对象
     */
    @Override
    public Merchant update(Merchant merchant) {
        this.merchantDao.update(merchant);
        return this.selectById(merchant.getMId());
    }

    /**
     * 通过主键删除数据
     *
     * @param mId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer mId) {
        return this.merchantDao.deleteById(mId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.merchantDao.count();
     }

    /**
     * 通过手机号查询密码,仅用于登录
     * @param mTel
     * @author lt
     */
    @Override
    public Merchant querryByTel(String mTel) {
        return merchantDao.querryByTel(mTel);
    }
}