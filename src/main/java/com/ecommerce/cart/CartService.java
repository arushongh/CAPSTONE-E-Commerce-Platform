package com.ecommerce.cart;

import com.ecommerce.product.Product;
import com.ecommerce.user.Role;
import com.ecommerce.user.User;
import com.ecommerce.user.UserService;

import java.util.Map;
import java.util.Optional;

public class CartService {
    private Cart cart = new Cart();
    private UserService userService;

    public CartService(UserService userService) {
        this.userService=userService;
    }

    public void addToCart(Product p, int qty) {
        Optional<User>user = userService.getLoggedInUser();
        if(user.isPresent()) {
            if(user.get().getRole()== Role.CUSTOMER) {
                cart.addProduct(p,qty);
            }
            else {
                System.out.println("Not a customer");
            }
        }else {
            System.out.println("Login in First");
        }
    }
    public Map<Product,Integer>getCartItems() {
        return cart.getCartItems();
    }
    public double calculateTotal() {
        return cart.calculateTotal();
    }
    public void clearCart() {
        cart.clear();
    }
    public boolean isEmpty() {
        return cart.isCartEmpty();
    }
}
