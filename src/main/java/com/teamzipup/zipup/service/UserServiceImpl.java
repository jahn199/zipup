package com.teamzipup.zipup.service;

import com.teamzipup.zipup.dto.User;
import com.teamzipup.zipup.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String, Objects>> getAllUsers() {
        return List.of();
    }

    //판매자 회원가입
    @Override
    public void insertSeller(User user) {
        userMapper.insertSeller(user);
    }



}
