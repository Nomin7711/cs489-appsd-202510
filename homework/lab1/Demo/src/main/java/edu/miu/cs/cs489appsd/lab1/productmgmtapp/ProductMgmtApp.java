package edu.miu.cs.cs489appsd.lab1.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1.productmgmtapp.model.Product;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product product1 = new Product(new BigInteger("31288741190182539912"), "Banana", "2025-01-24", 124, 0.55);
        Product product2 = new Product(new BigInteger("29274582650152771644"), "Apple", "2024-12-09", 18, 1.09);
        Product product3 = new Product(new BigInteger("91899274600128155167"), "Carrot", "2025-03-31", 89, 2.99);
        Product product4 = new Product(new BigInteger("31288741190182539913"), "Banana", "2025-02-13", 240, 0.65);
        List<Product> products = new ArrayList<>(List.of(product1, product2, product3, product4));
        printProducts(products);
    }
    public static void printProducts(List<Product> products) {
        products.sort(Comparator.comparing(Product::getName).thenComparing(Comparator.comparing(Product::getUnitPrice).reversed()));
        // JSON format
        System.out.println("---- JSON Format ----");
        System.out.println("[");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println("  { \"productId\": \"" + p.getProductId() + "\", " +
                    "\"name\": \"" + p.getName() + "\", " +
                    "\"dateSupplied\": \"" + p.getDateSupplied() + "\", " +
                    "\"quantityInStock\": " + p.getQuantityInStock() + ", " +
                    "\"unitPrice\": " + p.getUnitPrice() + " }" +
                    (i < products.size() - 1 ? "," : ""));
        }
        System.out.println("]");

        // XML format
        System.out.println("\n---- XML Format ----");
        System.out.println("<products>");
        for (Product p : products) {
            System.out.println("  <product>");
            System.out.println("    <productId>" + p.getProductId() + "</productId>");
            System.out.println("    <name>" + p.getName() + "</name>");
            System.out.println("    <dateSupplied>" + p.getDateSupplied() + "</dateSupplied>");
            System.out.println("    <quantityInStock>" + p.getQuantityInStock() + "</quantityInStock>");
            System.out.println("    <unitPrice>" + p.getUnitPrice() + "</unitPrice>");
            System.out.println("  </product>");
        }
        System.out.println("</products>");

        // CSV format
        System.out.println("\n---- CSV Format ----");
        System.out.println("productId,name,expiryDate,quantity,unitPrice");
        for (Product p : products) {
            System.out.println(p.getProductId() + "," + p.getName() + "," + p.getDateSupplied() + "," +
                    p.getQuantityInStock() + "," + p.getUnitPrice());
        }
    }
}