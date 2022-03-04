package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                                    
/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 745118352221254265L;
    
    private Integer aId;
    
    private String aAddr;
    
    private Integer uId;
    
    private String uTel;
    
    private String uName;
    
    private Integer uDef;
    
    private String a1;
    
    private String a2;
    
    private String a3;

        
    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }
        
    public String getAAddr() {
        return aAddr;
    }

    public void setAAddr(String aAddr) {
        this.aAddr = aAddr;
    }
        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public String getUTel() {
        return uTel;
    }

    public void setUTel(String uTel) {
        this.uTel = uTel;
    }
        
    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }
        
    public Integer getUDef() {
        return uDef;
    }

    public void setUDef(Integer uDef) {
        this.uDef = uDef;
    }
        
    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }
        
    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }
        
    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    @Override
    public String toString(){
        return "Address {" +
            "aId : " + aId + ", " +
            "aAddr : " + aAddr + ", " +
            "uId : " + uId + ", " +
            "uTel : " + uTel + ", " +
            "uName : " + uName + ", " +
            "uDef : " + uDef + ", " +
            "a1 : " + a1 + ", " +
            "a2 : " + a2 + ", " +
            "a3 : " + a3 + ", " +
        '}';
    }
}