package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageInfo<T> {
    private  int   pageSize;
    private  int   pageNum;
    private  int   preNum;
    private  int   nextNum;
    private  int   start;
    private  int   total;
    private  int   count;

    private List<T>   list;
}
