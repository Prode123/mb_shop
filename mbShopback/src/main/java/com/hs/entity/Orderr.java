package com.hs.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Orderr)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderr implements Serializable {
    private static final long serialVersionUID = 428833687708808360L;
    
    private Integer oId;
    
    private Integer oStatus;
    
    private Integer uId;
    
    private Integer aId;
    
    private Object oPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date oTime;
    
    private Integer mId;
    
    private String o1;
    
    private String o2;
    
    private String o3;

    private Address address;

        
    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }
        
    public Integer getOStatus() {
        return oStatus;
    }

    public void setOStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }
        
    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }
        
    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }
        
    public Object getOPrice() {
        return oPrice;
    }

    public void setOPrice(Object oPrice) {
        this.oPrice = oPrice;
    }
        
    public Date getOTime() {
        return oTime;
    }

    public void setOTime(Date oTime) {
        this.oTime = oTime;
    }
        
    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }
        
    public String getO1() {
        return o1;
    }

    public void setO1(String o1) {
        this.o1 = o1;
    }
        
    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }
        
    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    @Override
    public String toString(){
        return "Orderr {" +
            "oId : " + oId + ", " +
            "oStatus : " + oStatus + ", " +
            "uId : " + uId + ", " +
            "aId : " + aId + ", " +
            "oPrice : " + oPrice + ", " +
            "oTime : " + oTime + ", " +
            "mId : " + mId + ", " +
            "o1 : " + o1 + ", " +
            "o2 : " + o2 + ", " +
            "o3 : " + o3 + ", " +
        '}';
    }
}