package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                                
/**
 * (Merchant)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable {
    private static final long serialVersionUID = -40542068261935722L;
    
    private Integer mId;
    
    private String mName;
    
    private String mTel;
    
    private String mPasswd;
    
    private Integer gId;
    
    private String m1;
    
    private String m2;
    
    private String m3;

        
    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }
        
    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }
        
    public String getMTel() {
        return mTel;
    }

    public void setMTel(String mTel) {
        this.mTel = mTel;
    }
        
    public String getMPasswd() {
        return mPasswd;
    }

    public void setMPasswd(String mPasswd) {
        this.mPasswd = mPasswd;
    }
        
    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }
        
    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }
        
    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }
        
    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    @Override
    public String toString(){
        return "Merchant {" +
            "mId : " + mId + ", " +
            "mName : " + mName + ", " +
            "mTel : " + mTel + ", " +
            "mPasswd : " + mPasswd + ", " +
            "gId : " + gId + ", " +
            "m1 : " + m1 + ", " +
            "m2 : " + m2 + ", " +
            "m3 : " + m3 + ", " +
        '}';
    }
}