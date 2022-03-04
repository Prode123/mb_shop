package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                    
/**
 * (Cartnumber)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartnumber implements Serializable {
    private static final long serialVersionUID = 570320574867157003L;
    
    private Integer numId;
    
    private Integer numCount;
    
    private String num1;
    
    private String num2;
    
    private String num3;

        
    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }
        
    public Integer getNumCount() {
        return numCount;
    }

    public void setNumCount(Integer numCount) {
        this.numCount = numCount;
    }
        
    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }
        
    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }
        
    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

    @Override
    public String toString(){
        return "Cartnumber {" +
            "numId : " + numId + ", " +
            "numCount : " + numCount + ", " +
            "num1 : " + num1 + ", " +
            "num2 : " + num2 + ", " +
            "num3 : " + num3 + ", " +
        '}';
    }
}