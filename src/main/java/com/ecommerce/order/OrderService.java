package com.ecommerce.order;

import com.ecommerce.cart.CartService;
import com.ecommerce.product.Product;
import com.ecommerce.user.User;
import com.ecommerce.user.UserService;

import java.time.LocalDateTime;
import java.util.*;

public class OrderService {
    private UserService userService;
    private CartService cartService;

    private Map<Integer, List<Order>> orderHistory = new HashMap<>();

    public OrderService(UserService userService,CartService cartService) {
        this.userService=userService;
        this.cartService=cartService;
    }
    public void placeOrder() {
        Optional<User> user = userService.getLoggedInUser();
        if(user.isPresent()) {
            if(cartService.isEmpty()) {
                System.out.println("Add products to place order");
                return;
            }
            double total = cartService.calculateTotal();
            System.out.println("Order Placed successfully");
            System.out.println("Total Amount : "+total);

            Map<Product,Integer>item = new HashMap<>(cartService.getCartItems());
            Order order = new Order(UUID.randomUUID().toString(),user.get(),item,total, LocalDateTime.now());
            orderHistory.computeIfAbsent(user.get().getId(),k->new ArrayList<>())
                            .add(order);
            cartService.clearCart();
        }
        else {
            System.out.println("Login to place order");
        }
    }
    public List<Order> getOrderHistory() {
        return orderHistory.get(userService.getLoggedInUser().get().getId());
    }
}
