package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.*;
import com.hs.mapper.*;
import com.hs.service.OrderrService;
import com.hs.tools.OrderTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Orderr表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("orderrService")
public class OrderrServiceImpl implements OrderrService {
    @Resource
    private OrderrDao orderrDao;
    @Resource
    private OrderandgoodsDao orderandgoodsDao;
    @Resource
    private CartDao CartDao;
    @Resource
    private LogisticsDao logisticsDao;
    @Resource
    private AddressDao addressDao;
    @Resource
    private GoodsDao goodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param oId 主键
     * @return 实例对象
     */
    @Override
    public Orderr selectById(Integer oId) {
        return this.orderrDao.selectById(oId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Orderr> selectPage(int start, int limit) {
        return this.orderrDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Orderr> selectAll() {
        return this.orderrDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Orderr> selectList(Orderr orderr) {
        return this.orderrDao.selectList(orderr);
    }
    
    /**
     * 新增数据
     *
     * @param orderr 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Orderr orderr) {
        return this.orderrDao.insert(orderr);
    }

    /**
     * 批量新增
     *
     * @param orderrs 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Orderr> orderrs) {
        return this.orderrDao.batchInsert(orderrs);
    }

    @Override
    public Orderr update(Orderr orderr) {
        this.orderrDao.update(orderr);
        return this.selectById(orderr.getOId());
    }

    /**
     * 支付，生成各种数据
     *
     * @param orderr 实例对象
     * @return 实例对象
     */
    @Override
    public Orderr update1(Orderr orderr) {
        //o3为1表示正在操作的这一条订单
        //通过uid和o3为1查找到需要支付的那个订单，得到oid
        Orderr orderr1 = orderrDao.selectByUidAndO3(orderr);
        orderr.setOId(orderr1.getOId());
        //设置订单id
        Cart cart = new Cart();
        cart.setUId(orderr.getUId());
        cart.setCar1("1");
        //获得对应id的购物车信息，以便获取商品信息
        List<Cart> carts = CartDao.selectList(cart);
        for (Cart cart1 : carts) {
            Orderandgoods orderandgoods = new Orderandgoods();
            orderandgoods.setOId(orderr.getOId());
            orderandgoods.setGId(cart1.getGId());
            orderandgoods.setGNum(cart1.getNumId());
            //插入订单对应商品信息
            orderandgoodsDao.insert(orderandgoods);
            //通过gid得到商品
            Goods goods = goodsDao.selectById(cart1.getGId());
            //修改商品的库存
            Integer gNum = goods.getGNum();
            goods.setGNum(gNum-cart1.getNumId());
            goodsDao.update(goods);
        }
        //删除购物车中已购物的记录
        CartDao.deleteBuyAlready(cart);
        //获得地址
        Address address = new Address();
        address.setUId(orderr.getUId());
        address.setUDef(1);
        List<Address> addresses = addressDao.selectList(address);
        Address address1 = new Address();
        if (addresses.size()!=0){
            address1 = addresses.get(0);
        }
        //生成物流信息
        Logistics logistics = new Logistics();
        logistics.setOId(orderr.getOId());
        logistics.setLogTime(new Date());
        logistics.setLogStatus(1);
        logistics.setLogAdd(address1.getAAddr());
        logisticsDao.insert(logistics);
        //将该条订单o3置为0
        orderr.setO3("0");
        orderr.setOStatus(2);
        //修改订单状态，为已支付
        this.orderrDao.update(orderr);
        return this.selectById(orderr.getOId());
    }

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer oId) {
        return this.orderrDao.deleteById(oId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.orderrDao.count();
     }

    /**
     * 分页查询
     * @param orderTool
     * @param page
     * @param num
     * @return
     */
    @Override
    public PageInfo<Orderr> selectByPageHelper(OrderTool orderTool, int page, int num) {
        PageHelper.startPage(page, num);
        List<Orderr> orderrs = orderrDao.selectListWithTime(orderTool);
        return new PageInfo<>(orderrs);
    }

    /**
     * gm  查询订单前5的信息
     * @return
     */
    @Override
    public List<BaoBiao> findAllBB() {
        return orderrDao.findAllbb();
    }


}