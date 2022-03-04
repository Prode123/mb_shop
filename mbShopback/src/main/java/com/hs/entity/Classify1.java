package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                    
/**
 * (Classify1)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classify1 implements Serializable {
    private static final long serialVersionUID = 461763653707730150L;
    
    private Integer c1Id;
    
    private String c1Name;
    
    private String c11;
    
    private String c12;
    
    private String c13;

        
    public Integer getC1Id() {
        return c1Id;
    }

    public void setC1Id(Integer c1Id) {
        this.c1Id = c1Id;
    }
        
    public String getC1Name() {
        return c1Name;
    }

    public void setC1Name(String c1Name) {
        this.c1Name = c1Name;
    }
        
    public String getC11() {
        return c11;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }
        
    public String getC12() {
        return c12;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }
        
    public String getC13() {
        return c13;
    }

    public void setC13(String c13) {
        this.c13 = c13;
    }

    @Override
    public String toString(){
        return "Classify1 {" +
            "c1Id : " + c1Id + ", " +
            "c1Name : " + c1Name + ", " +
            "c11 : " + c11 + ", " +
            "c12 : " + c12 + ", " +
            "c13 : " + c13 + ", " +
        '}';
    }
}