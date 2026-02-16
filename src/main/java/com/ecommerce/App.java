package com.ecommerce;

import com.ecommerce.cart.CartService;
import com.ecommerce.order.OrderService;
import com.ecommerce.product.Product;
import com.ecommerce.product.ProductService;
import com.ecommerce.user.Role;
import com.ecommerce.user.User;
import com.ecommerce.user.UserService;

import java.util.List;


public class App {
    public static void main(String[] args) {

        UserService us = new UserService();

        User u1 = new User(51,"Arush","arush@mail.com","arush123", Role.CUSTOMER);
        User u2 = new User(49,"ram","ram@gmail.com","123",Role.ADMIN);
        User u3 = new User(71,"mohan","mohan@gmail.com","mohan123",Role.CUSTOMER);

        us.registerUser(u1);
        us.registerUser(u2);
        us.registerUser(u3);


        boolean islog=us.login("ram@gmail.com","123");
        if(islog) {
            System.out.println("login successfull");
        }
        Product p1 = new Product(101,"dove","soap",75.2,"Bathing soap");
        Product p2 = new Product(102,"cinthol","soap",64.5,"Mint Bathing soap");

        ProductService ps = new ProductService(us);
        ps.addProduct(p1);
        ps.addProduct(p2);

        ps.getAllProducts();

        ps.search("category","soap");
        us.login("arush@mail.com","arush123");
        CartService cs = new CartService(us);
        cs.addToCart(p1,2);

        OrderService os = new OrderService(us,cs);
        os.placeOrder();

        System.out.println(os.getOrderHistory());

        us.login("mohan@gmail.com","mohan123");

        cs.addToCart(p2,3);
        os.placeOrder();

        User u4 = new User(37,"abhishek","abhishek@gmail.com","123",Role.CUSTOMER);
        us.registerUser(u4);

        us.login("abhishek@gmail.com","123");

        cs.addToCart(p1,2);
        os.placeOrder();
        cs.addToCart(p2,1);

        os.placeOrder();
        os.getOrderHistory();
        System.out.println(os.getOrderHistory());
    }
}
