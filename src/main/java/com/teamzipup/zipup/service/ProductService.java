package com.teamzipup.zipup.service;

import com.teamzipup.zipup.dto.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    // 상품 검색
    List<Product> searchProducts(String productName);
}