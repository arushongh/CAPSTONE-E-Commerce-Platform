package com.ecommerce.product;

import com.ecommerce.user.Role;
import com.ecommerce.user.User;
import com.ecommerce.user.UserService;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products= new ArrayList<>();
    private UserService userService;

    public ProductService(UserService userService) {
        this.userService=userService;
    }
    public void addProduct(Product p) {
        Optional<User> user = userService.getLoggedInUser();
        if(user.isPresent()) {
            if(user.get().getRole()== Role.ADMIN) {
                System.out.println(p.getName()+" added successfully");
                products.add(p);
            } else {
                System.out.println("Only Admins can add products");
            }
        }
        else {
            System.out.println("You are not logged in");
        }
    }
    public void updateProduct(Product old,Product latest) {
        if(products.contains(old)) {
            products.set(products.indexOf(old),latest);
            System.out.println(latest.getName()+" updated successfully");
        }
        else {
            System.out.println(old.getName()+" do not exist");
        }
    }
    public void deleteProduct(Product p) {
        if(products.contains(p)) {
            products.remove(p);
            System.out.println(p.getName()+" deleted successfully");
        }
        else {
            System.out.println(p.getName()+" is not present");
        }
    }
    public void getAllProducts() {
        for(int i=0;i<products.size();i++) {
            System.out.println(products.get(i));
        }
    }
    public void search(String type,String name) {
        List<Product>result;
        if(type.equals("category")) {
            result = products.stream().filter(x -> x.getCategory().equals(name)).collect(Collectors.toCollection(ArrayList::new));
        }
        else {
            result =products.stream().filter(x-> x.getName().equals(name)).collect(Collectors.toCollection(ArrayList::new));
        }
        if(result.isEmpty()) {
            System.out.println("No Products to show");
        } else {
            for(Product x:result) {
                System.out.println(x.getName());
            }
        }
    }
    public void search(String type,double startPrice,double endPrice) {
        List<Product> result =products.stream().filter(x-> x.getPrice()>=startPrice && x.getPrice()<=endPrice).collect(Collectors.toCollection(ArrayList::new));
    }
}
