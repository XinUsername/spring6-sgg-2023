package com.cjx.mybatisplusdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjx.mybatisplusdatasource.dao.ProductMapper;
import com.cjx.mybatisplusdatasource.pojo.Product;
import com.cjx.mybatisplusdatasource.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1") //指定所操作的数据源
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
