package com.hs.service.impl;

import com.hs.entity.Address;
import com.hs.mapper.AddressDao;
import com.hs.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    @Override
    public Address selectById(Integer aId) {
        return this.addressDao.selectById(aId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Address> selectPage(int start, int limit) {
        return this.addressDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Address> selectAll() {
        return this.addressDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Address> selectList(Address address) {
        return this.addressDao.selectList(address);
    }
    
    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Address address) {
        return this.addressDao.insert(address);
    }

    /**
     * 批量新增
     *
     * @param addresss 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Address> addresss) {
        return this.addressDao.batchInsert(addresss);
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.selectById(address.getAId());
    }

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer aId) {
        return this.addressDao.deleteById(aId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.addressDao.count();
     }

    /**
     * 通过三个参数删除收货地址
     * @author lt
     */
    @Override
    public int deleteAddressByThreeParam(Address address) {
        return addressDao.deleteAddressByThreeParam(address);
    }
    /**
     * 通过用户id新增收货地址
     * @author lt
     */

    @Override
    public int addAddress(Address address) {
        return addressDao.addAddress(address);
    }
}