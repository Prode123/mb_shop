package com.hs.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
                            
/**
 * (Shoppingimg)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shoppingimg implements Serializable {
    private static final long serialVersionUID = -97596310650600716L;
    
    private Integer picId;
    
    private String picName;
    
    private String picSrc;
    
    private Integer gId;
    
    private String pic1;
    
    private String pic2;
    
    private String pic3;

        
    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }
        
    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
        
    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }
        
    public Integer getGId() {
        return gId;
    }

    public void setGId(Integer gId) {
        this.gId = gId;
    }
        
    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }
        
    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }
        
    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    @Override
    public String toString(){
        return "Shoppingimg {" +
            "picId : " + picId + ", " +
            "picName : " + picName + ", " +
            "picSrc : " + picSrc + ", " +
            "gId : " + gId + ", " +
            "pic1 : " + pic1 + ", " +
            "pic2 : " + pic2 + ", " +
            "pic3 : " + pic3 + ", " +
        '}';
    }
}