package com.masood.springbootcarnet.modules.m_8.controllers;


import com.masood.springbootcarnet.modules.m_8.model.Product;
import com.masood.springbootcarnet.modules.m_8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {


    private final ProductService mProductService;

    @Autowired
    public ProductController(ProductService _productService) {
        this.mProductService = _productService;
    }


    @GetMapping(path = "/product")
    public String getProducts(Model page) {

        List<Product> products = mProductService.getProductsList();
        page.addAttribute("products", products);

        return "product.html";
    }



    @PostMapping(path = "/product")
    public String addProduct(
            Product p,
            Model page
    ) {

        mProductService.addProduct(p);
        var products = mProductService.getProductsList();
        page.addAttribute("products", products);
        return "product.html";

    }


}
