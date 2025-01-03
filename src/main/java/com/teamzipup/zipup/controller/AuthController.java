package com.teamzipup.zipup.controller;


import com.teamzipup.zipup.dto.User;
import com.teamzipup.zipup.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    // 판매자 회원가입
    @PostMapping("/signup/seller")
    public String sellerSignup(@ModelAttribute("user") User user, Model model) {
        user.setRole("seller"); // 판매자 역할 설정
        userService.insertSeller(user);
        model.addAttribute("msg", "회원가입 성공 (판매자)");
        return "login";
    }



}
