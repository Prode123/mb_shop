package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                                        
/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 809282116237917070L;
    
    private Integer uId;
    
    private String uName;
    
    private String uUsername;
    
    private String uPasswd;
    
    private String uSex;
    
    private String uTel;
    
    private String uHeader;
    
    private String u1;
    
    private String u2;
    
    private String u3;

        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }
        
    public String getUUsername() {
        return uUsername;
    }

    public void setUUsername(String uUsername) {
        this.uUsername = uUsername;
    }
        
    public String getUPasswd() {
        return uPasswd;
    }

    public void setUPasswd(String uPasswd) {
        this.uPasswd = uPasswd;
    }
        
    public String getUSex() {
        return uSex;
    }

    public void setUSex(String uSex) {
        this.uSex = uSex;
    }
        
    public String getUTel() {
        return uTel;
    }

    public void setUTel(String uTel) {
        this.uTel = uTel;
    }
        
    public String getUHeader() {
        return uHeader;
    }

    public void setUHeader(String uHeader) {
        this.uHeader = uHeader;
    }
        
    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }
        
    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }
        
    public String getU3() {
        return u3;
    }

    public void setU3(String u3) {
        this.u3 = u3;
    }

    @Override
    public String toString(){
        return "User {" +
            "uId : " + uId + ", " +
            "uName : " + uName + ", " +
            "uUsername : " + uUsername + ", " +
            "uPasswd : " + uPasswd + ", " +
            "uSex : " + uSex + ", " +
            "uTel : " + uTel + ", " +
            "uHeader : " + uHeader + ", " +
            "u1 : " + u1 + ", " +
            "u2 : " + u2 + ", " +
            "u3 : " + u3 + ", " +
        '}';
    }
}