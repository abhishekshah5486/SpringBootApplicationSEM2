package com.abhishek.springbootapplicationsem2.Models;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Cart {
    private Long id;
    private Long userId;
    private String date;
    private List<Object> products;

    public Cart(){
        this.id = null;
        this.userId = null;
        this.date = null;
        this.products = null;
    }
    public Cart(Long id, Long userId, String date, List<Object> products){
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }
}
