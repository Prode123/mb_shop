package com.hs.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
        import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Logistics)实体类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistics implements Serializable {
    private static final long serialVersionUID = 350376193779254973L;
    
    private Integer logId;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date logTime;
    
    private String logAdd;
    
    private Integer oId;
    
    private Integer logStatus;
    
    private String log1;
    
    private String log2;
    
    private String log3;

        
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }
        
    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
        
    public String getLogAdd() {
        return logAdd;
    }

    public void setLogAdd(String logAdd) {
        this.logAdd = logAdd;
    }
        
    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }
        
    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }
        
    public String getLog1() {
        return log1;
    }

    public void setLog1(String log1) {
        this.log1 = log1;
    }
        
    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2;
    }
        
    public String getLog3() {
        return log3;
    }

    public void setLog3(String log3) {
        this.log3 = log3;
    }

    @Override
    public String toString(){
        return "Logistics {" +
            "logId : " + logId + ", " +
            "logTime : " + logTime + ", " +
            "logAdd : " + logAdd + ", " +
            "oId : " + oId + ", " +
            "logStatus : " + logStatus + ", " +
            "log1 : " + log1 + ", " +
            "log2 : " + log2 + ", " +
            "log3 : " + log3 + ", " +
        '}';
    }
}