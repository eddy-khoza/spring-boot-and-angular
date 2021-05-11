package com.syre.productmanager.service;

import com.syre.employeemanager.model.Product;
import com.syre.productmanager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        product.setProductCode(UUID.randomUUID().toString().substring(1,20));
        productRepo.save(product);
        return product;
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        productRepo.save(product);
        return product;
    }

    public void deleteProduct(long id){
        productRepo.deleteById(id);
    }

    public Product findProductByID(long id) throws Throwable{
        return productRepo.findProductByID(id);
    }
}
