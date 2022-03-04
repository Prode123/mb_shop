package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                            
/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = 999430646558752454L;
    
    private Integer carId;
    
    private Integer uId;
    
    private Integer gId;
    
    private Integer numId;
    
    private String car1;
    
    private String car2;
    
    private String car3;

        
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }
        
    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }
        
    public String getCar1() {
        return car1;
    }

    public void setCar1(String car1) {
        this.car1 = car1;
    }
        
    public String getCar2() {
        return car2;
    }

    public void setCar2(String car2) {
        this.car2 = car2;
    }
        
    public String getCar3() {
        return car3;
    }

    public void setCar3(String car3) {
        this.car3 = car3;
    }

    @Override
    public String toString(){
        return "Cart {" +
            "carId : " + carId + ", " +
            "uId : " + uId + ", " +
            "gId : " + gId + ", " +
            "numId : " + numId + ", " +
            "car1 : " + car1 + ", " +
            "car2 : " + car2 + ", " +
            "car3 : " + car3 + ", " +
        '}';
    }
}