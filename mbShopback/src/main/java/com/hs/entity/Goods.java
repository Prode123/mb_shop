package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                                            
/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private static final long serialVersionUID = 382134418413913593L;
    
    private Integer gId;
    
    private String gName;
    
    private Integer c2Id;
    
    private double gPrice;
    
    private Integer oId;
    
    private Integer gNum;
    
    private Integer gStatus;
    
    private String gPic;
    
    private String g1;
    
    private String g2;
    
    private String g3;

        
    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }
        
    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }
        
    public Integer getC2Id() {
        return c2Id;
    }

    public void setC2Id(Integer c2Id) {
        this.c2Id = c2Id;
    }
        
    public double getGPrice() {
        return gPrice;
    }

    public void setGPrice(double gPrice) {
        this.gPrice = gPrice;
    }
        
    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }
        
    public Integer getGNum() {
        return gNum;
    }

    public void setGNum(Integer gNum) {
        this.gNum = gNum;
    }
        
    public Integer getGStatus() {
        return gStatus;
    }

    public void setGStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }
        
    public String getGPic() {
        return gPic;
    }

    public void setGPic(String gPic) {
        this.gPic = gPic;
    }
        
    public String getG1() {
        return g1;
    }

    public void setG1(String g1) {
        this.g1 = g1;
    }
        
    public String getG2() {
        return g2;
    }

    public void setG2(String g2) {
        this.g2 = g2;
    }
        
    public String getG3() {
        return g3;
    }

    public void setG3(String g3) {
        this.g3 = g3;
    }

    @Override
    public String toString(){
        return "Goods {" +
            "gId : " + gId + ", " +
            "gName : " + gName + ", " +
            "c2Id : " + c2Id + ", " +
            "gPrice : " + gPrice + ", " +
            "oId : " + oId + ", " +
            "gNum : " + gNum + ", " +
            "gStatus : " + gStatus + ", " +
            "gPic : " + gPic + ", " +
            "g1 : " + g1 + ", " +
            "g2 : " + g2 + ", " +
            "g3 : " + g3 + ", " +
        '}';
    }
}