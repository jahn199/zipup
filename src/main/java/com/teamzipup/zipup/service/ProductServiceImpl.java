package com.teamzipup.zipup.service;

import com.teamzipup.zipup.dto.Product;
import com.teamzipup.zipup.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    // 상품 판매자 조회
    @Override
    public Product getProductById(long id) {
        return productMapper.findById(id);
    }
}

