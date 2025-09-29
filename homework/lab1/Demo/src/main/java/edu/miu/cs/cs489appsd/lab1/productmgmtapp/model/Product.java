package edu.miu.cs.cs489appsd.lab1.productmgmtapp.model;

import java.math.BigInteger;

public class Product {
    private BigInteger productId;
    private String name;
    private String dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product(BigInteger productId, String name, String dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }
    public Product() {

    }
    public BigInteger getProductId() {
        return productId;
    }
    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateSupplied() {
        return dateSupplied;
    }
    public void setDateSupplied(String dateSupplied) {
        this.dateSupplied = dateSupplied;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", dateSupplied='" + dateSupplied + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
