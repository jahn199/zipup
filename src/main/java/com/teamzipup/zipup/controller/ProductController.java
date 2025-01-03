package com.teamzipup.zipup.controller;

import com.teamzipup.zipup.dto.Product;
import com.teamzipup.zipup.dto.User;
import com.teamzipup.zipup.service.ProductService;
import com.teamzipup.zipup.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    /* 상품 검색 */
    @GetMapping("/productList")
    public String searchProducts
    (@RequestParam(required = false) String productName, Model model ) {

        List<Product> products = productService.searchProducts(productName);

        model.addAttribute("products", products);

        return "index";
    }

    /* 상품 상세 페이지 이동 */
    @GetMapping("/product/{id}")
    public String viewProductDetail(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id); // ID로 상품 조회
        model.addAttribute("product", product);
        return "productDetail";
    }


}
