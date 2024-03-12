package com.abhishek.springbootapplicationsem2.Controller;
import com.abhishek.springbootapplicationsem2.Models.Cart;

import com.abhishek.springbootapplicationsem2.Services.FakeStoreCartService;
import com.abhishek.springbootapplicationsem2.dto.FakeStoreCartDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    FakeStoreCartService fakeStoreCartService = new FakeStoreCartService();

    @GetMapping("/carts")
    public FakeStoreCartDto[] getAllCarts(){
        return fakeStoreCartService.getAllCarts();
    }
//
    @GetMapping("/carts/{id}")
    public FakeStoreCartDto getCartById(@PathVariable("id") Long id){
        return fakeStoreCartService.getCartById(id);
    }

    @GetMapping("/carts?startdate={startDate}&enddate={endDate}")
    public FakeStoreCartDto[] getCartsInDateRange(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return fakeStoreCartService.getCartsInDateRange(startDate, endDate);
    }

    @GetMapping("/carts/user/{userId}")
    public FakeStoreCartDto[] getUserCarts(@PathVariable("userId") Long userId){
        return fakeStoreCartService.getUserCarts(userId);
    }

    @PostMapping("/carts")
    public FakeStoreCartDto createNewCart(@RequestBody FakeStoreCartDto fakeStoreCartDto){
        return fakeStoreCartService.createNewCart(fakeStoreCartDto);
    }

    @PutMapping("/carts/{id}")
    public FakeStoreCartDto updateCart(@RequestBody FakeStoreCartDto fakeStoreCartDto, @PathVariable("id") Long id){
        return fakeStoreCartService.updateCart(fakeStoreCartDto, id);
    }

    @DeleteMapping("/carts/{id}")
    public FakeStoreCartDto deleteCart(@PathVariable("id") Long id){
        return fakeStoreCartService.deleteCart(id);
    }
}
