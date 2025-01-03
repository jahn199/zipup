package com.teamzipup.zipup.mapper;

import com.teamzipup.zipup.dto.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

    // 상품 ID로 조회
    Product findById(long id);
}