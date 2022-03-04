package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther GM
 * @date 2021/10/30  11:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaoBiao {
    private String pName;
    private double price;
    private Integer sales;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
