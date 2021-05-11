package com.syre.productmanager.controller;

import com.syre.employeemanager.model.Product;
import com.syre.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductResource {
    final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.findAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") long id) throws Throwable {
        Product product = productService.findProductByID(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping ("/update")
    public ResponseEntity<Product> updateProduct(Product product){
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
