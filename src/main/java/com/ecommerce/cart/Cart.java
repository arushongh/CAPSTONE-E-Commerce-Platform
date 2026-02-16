package com.ecommerce.cart;

import com.ecommerce.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> items=new HashMap<>();

    public void addProduct(Product p,int qty) {
        items.merge(p,qty,Integer::sum);
    }
    public void removeProduct(Product p) {
        if(items.containsKey(p)) {
            items.put(p,items.get(p)-1);
            System.out.println("Item removed successfully \nCurrent Qty: "+items.get(p));

            if(items.get(p)==0){
                items.remove(p);
            }
        }
        else {
            System.out.println("Item is not present");
        }
    }
    public void viewCart() {
        if(items.isEmpty()) {
            System.out.println("Cart is empty ");
        }
        else {
            for(Map.Entry<Product,Integer>entry : items.entrySet()) {
                System.out.println(entry.getKey().getName()+" Qty: "+entry.getValue());
            }
        }
    }
    public double calculateTotal() {
        double total = items.entrySet().stream().mapToDouble(entry->entry.getKey().getPrice()*entry.getValue()).sum();
        return total;
    }
    public boolean isCartEmpty() {
        return items.isEmpty();
    }
    public Map<Product, Integer> getCartItems() {
        return items;
    }
    public void clear() {
        items.clear();
        System.out.println("Cart is empty");
    }


}
