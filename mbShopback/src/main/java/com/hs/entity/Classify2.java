package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                        
/**
 * (Classify2)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classify2 implements Serializable {
    private static final long serialVersionUID = -77994808758294788L;
    
    private Integer c2Id;
    
    private String c2Name;
    
    private Integer c1Id;
    
    private String c21;
    
    private String c22;
    
    private String c23;

        
    public Integer getC2Id() {
        return c2Id;
    }

    public void setC2Id(Integer c2Id) {
        this.c2Id = c2Id;
    }
        
    public String getC2Name() {
        return c2Name;
    }

    public void setC2Name(String c2Name) {
        this.c2Name = c2Name;
    }
        
    public Integer getC1Id() {
        return c1Id;
    }

    public void setC1Id(Integer c1Id) {
        this.c1Id = c1Id;
    }
        
    public String getC21() {
        return c21;
    }

    public void setC21(String c21) {
        this.c21 = c21;
    }
        
    public String getC22() {
        return c22;
    }

    public void setC22(String c22) {
        this.c22 = c22;
    }
        
    public String getC23() {
        return c23;
    }

    public void setC23(String c23) {
        this.c23 = c23;
    }

    @Override
    public String toString(){
        return "Classify2 {" +
            "c2Id : " + c2Id + ", " +
            "c2Name : " + c2Name + ", " +
            "c1_Id : " + c1Id + ", " +
            "c21 : " + c21 + ", " +
            "c22 : " + c22 + ", " +
            "c23 : " + c23 + ", " +
        '}';
    }
}