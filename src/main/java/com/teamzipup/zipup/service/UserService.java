package com.teamzipup.zipup.service;

import com.teamzipup.zipup.dto.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserService {

    // 모든 유저 보기 기능
    List<Map<String, Objects>> getAllUsers();

    // 판매자 저장
    void insertSeller(User user);

}
