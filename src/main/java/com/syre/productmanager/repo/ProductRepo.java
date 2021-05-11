package com.syre.productmanager.repo;

import com.syre.employeemanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    Product findProductByID(long id);
}
