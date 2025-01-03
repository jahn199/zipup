package com.teamzipup.zipup.service;

import com.teamzipup.zipup.dto.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    // 상품 ID로 조회
    Product getProductById(long id);
}