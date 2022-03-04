package com.hs.controller;

import com.hs.entity.Address;
import com.hs.entity.ResponseEntity;
import com.hs.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Address)控制层
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 通过用户名查询个人收货地址
     * @param address
     * @return
     * @author lt
     */
    @RequestMapping("/selectAllAddressByUid")
    public ResponseEntity<List> selectAllAddressByUid(Address address){
        ResponseEntity<List> responseEntity=new ResponseEntity<>();
        if (address.getUId()!=null && address.getUId()!=' '){
            List<Address> addresses = addressService.selectList(address);
            responseEntity.setData(addresses);
            responseEntity.setStatus(1);
            responseEntity.setMessage("id格式正确 若未接收到data 则id有误");
            return responseEntity;
        }
        else responseEntity.setMessage("没有接收到用户id");
             responseEntity.setStatus(0);
             return responseEntity;
    }
    /**
     * 通过手机号 收货地址 和收货人姓名删除收货地址
     * @author lt
     */
    @RequestMapping("/deleteAddressByThreeParam")
    public int deleteAddressByThreeParam(Address address){
        return addressService.deleteAddressByThreeParam(address);
    }

    /**
     * 查询默认地址状态
     * @author lt
     */
    @RequestMapping("/selectDefaultAddress")
    public ResponseEntity defaultAddress(){
        ResponseEntity responseEntity=new ResponseEntity();
        List<Address> addresses = addressService.selectAll();
        for (Address address : addresses) {
            if (address.getUDef().equals(1))
            {
                responseEntity.setStatus(1);
                responseEntity.setData(address);
                responseEntity.setMessage("是默认地址");
            }
            else
                responseEntity.setStatus(0);
                responseEntity.setMessage("没有默认地址");
        }
        return responseEntity;
    }
    /**
     * 新增收货地址
     */
    @RequestMapping("/addAddress")
    public int addAddress(Address address){
       return addressService.addAddress(address);
    }
}