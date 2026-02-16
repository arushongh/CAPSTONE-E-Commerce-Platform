package com.ecommerce.order;

import com.ecommerce.cart.Cart;
import com.ecommerce.product.Product;
import com.ecommerce.user.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class Order {
    private String id;
    private User user;
    Map<Product,Integer> item;
    private double totalAmount;
    private LocalDateTime date;

    public Order(String id,User user,Map<Product,Integer>item,double totalAmount,LocalDateTime date) {
        this.id=id;
        this.user=user;
        this.item=item;
        this.totalAmount=totalAmount;
        this.date=date;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n================= ORDER DETAILS =================\n");
        sb.append("Order ID      : ").append(id).append("\n");
        sb.append("Customer Name : ").append(user.getName()).append("\n");
        sb.append("Order Date    : ").append(date).append("\n");
        sb.append("\nItems:\n");

        for (Map.Entry<Product, Integer> entry : item.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            sb.append(" - ")
                    .append(product.getName())
                    .append(" | Price: ₹")
                    .append(product.getPrice())
                    .append(" | Quantity: ")
                    .append(quantity)
                    .append("\n");
        }

        sb.append("\nTotal Amount  : ₹").append(totalAmount);
        sb.append("\n=================================================\n");

        return sb.toString();
    }

}


