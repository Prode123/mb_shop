package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                            
/**
 * (Orderandgoods)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderandgoods implements Serializable {
    private static final long serialVersionUID = 681397702476577486L;
    
    private Integer oagId;
    
    private Integer oId;
    
    private Integer gId;
    
    private Integer gNum;
    
    private String oag1;
    
    private String oag2;
    
    private String oag3;

//    商品对象
    private Goods goods;

        
    public Integer getOagId() {
        return oagId;
    }

    public void setOagId(Integer oagId) {
        this.oagId = oagId;
    }
        
    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }
        
    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }
        
    public Integer getGNum() {
        return gNum;
    }

    public void setGNum(Integer gNum) {
        this.gNum = gNum;
    }
        
    public String getOag1() {
        return oag1;
    }

    public void setOag1(String oag1) {
        this.oag1 = oag1;
    }
        
    public String getOag2() {
        return oag2;
    }

    public void setOag2(String oag2) {
        this.oag2 = oag2;
    }
        
    public String getOag3() {
        return oag3;
    }

    public void setOag3(String oag3) {
        this.oag3 = oag3;
    }

    @Override
    public String toString(){
        return "Orderandgoods {" +
            "oagId : " + oagId + ", " +
            "oId : " + oId + ", " +
            "gId : " + gId + ", " +
            "gNum : " + gNum + ", " +
            "oag1 : " + oag1 + ", " +
            "oag2 : " + oag2 + ", " +
            "oag3 : " + oag3 + ", " +
        '}';
    }
}