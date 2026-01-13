package com.masood.springbootcarnet.modules.m_8.service;
import com.masood.springbootcarnet.modules.m_8.model.Product;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(BeanDefinition.SCOPE_SINGLETON)
public class ProductService {


    private List<Product> mProductsList = new ArrayList<>();

    public void addProduct(Product _product) {
        mProductsList.add(_product);
    }

    public List<Product> getProductsList() {
        return this.mProductsList;
    }

}
