package com.ecommerce.user;

import com.ecommerce.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Role role;

    public User(int id,String name,String email,String password,Role role) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.role=role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) return false;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}
