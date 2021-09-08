package com.study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private int sortId;
    private String goodNam;
    private String address;
    private float price;
    private Date createDate;
    private int remaining;


}
