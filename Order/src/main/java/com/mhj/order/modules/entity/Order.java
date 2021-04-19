package com.mhj.order.modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/4/15 10:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String uid;
    private String userName;
    private String pName;
    private Integer pPrice;
}
