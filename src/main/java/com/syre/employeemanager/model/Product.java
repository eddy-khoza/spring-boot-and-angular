package com.syre.employeemanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private long pid;
    private String productName;
    private String productDescription;
    private String productCode;
    private Double productPrice;
    private int productQuantity;

    public Product() {
    }

    public Product(long pid, String productName, String productDescription, String productCode, Double productPrice, int productQuantity) {
        this.pid = pid;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
