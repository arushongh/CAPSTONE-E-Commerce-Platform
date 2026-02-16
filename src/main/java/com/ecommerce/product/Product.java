package com.ecommerce.product;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private String description;

    public Product(int id,String name,String category,double price,String description) {
        this.id=id;
        this.name=name;
        this.category=category;
        this.price = price;
        this.description=description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
