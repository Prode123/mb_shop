package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                                
/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -69963387927729943L;
    
    private Integer payId;
    
    private Integer oId;
    
    private Integer payStatus;
    
    private Object payPrice;
    
    private Integer uId;
    
    private String pay1;
    
    private String pay2;
    
    private String pay3;

        
    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }
        
    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }
        
    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }
        
    public Object getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Object payPrice) {
        this.payPrice = payPrice;
    }
        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public String getPay1() {
        return pay1;
    }

    public void setPay1(String pay1) {
        this.pay1 = pay1;
    }
        
    public String getPay2() {
        return pay2;
    }

    public void setPay2(String pay2) {
        this.pay2 = pay2;
    }
        
    public String getPay3() {
        return pay3;
    }

    public void setPay3(String pay3) {
        this.pay3 = pay3;
    }

    @Override
    public String toString(){
        return "Payment {" +
            "payId : " + payId + ", " +
            "oId : " + oId + ", " +
            "payStatus : " + payStatus + ", " +
            "payPrice : " + payPrice + ", " +
            "uId : " + uId + ", " +
            "pay1 : " + pay1 + ", " +
            "pay2 : " + pay2 + ", " +
            "pay3 : " + pay3 + ", " +
        '}';
    }
}