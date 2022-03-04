package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                            
/**
 * (Token)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {
    private static final long serialVersionUID = -66726707340586591L;
    
    private Integer tId;
    
    private String tVal;
    
    private Integer uId;
    
    private Integer uStatus;
    
    private String t1;
    
    private String t2;
    
    private String t3;

        
    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }
        
    public String getTVal() {
        return tVal;
    }

    public void setTVal(String tVal) {
        this.tVal = tVal;
    }
        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public Integer getUStatus() {
        return uStatus;
    }

    public void setUStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }
        
    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }
        
    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }
        
    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    @Override
    public String toString(){
        return "Token {" +
            "tId : " + tId + ", " +
            "tVal : " + tVal + ", " +
            "uId : " + uId + ", " +
            "uStatus : " + uStatus + ", " +
            "t1 : " + t1 + ", " +
            "t2 : " + t2 + ", " +
            "t3 : " + t3 + ", " +
        '}';
    }
}