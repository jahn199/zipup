package com.teamzipup.zipup.mapper;

import com.teamzipup.zipup.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 모든 유저 목록 조회
    List<User> getAllUsers();

    //판매자 저장
    void insertSeller(User user);

}