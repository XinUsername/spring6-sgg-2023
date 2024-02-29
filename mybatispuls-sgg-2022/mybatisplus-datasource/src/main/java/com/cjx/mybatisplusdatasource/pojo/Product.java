package com.cjx.mybatisplusdatasource.pojo;

import lombok.Data;

@Data
public class Product {
    private Long id ;
    private String name;
    private Integer price;
    private Integer version;
}
