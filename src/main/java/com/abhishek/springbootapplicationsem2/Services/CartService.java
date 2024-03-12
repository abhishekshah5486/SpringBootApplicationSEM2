package com.abhishek.springbootapplicationsem2.Services;

import com.abhishek.springbootapplicationsem2.Models.Cart;
import com.abhishek.springbootapplicationsem2.dto.FakeStoreCartDto;

import java.util.List;

public interface CartService {
    FakeStoreCartDto[] getAllCarts();
    FakeStoreCartDto getCartById(Long id);
    FakeStoreCartDto[] getCartsInDateRange(String startDate, String endDate);

    FakeStoreCartDto[] getUserCarts(Long userId);
    FakeStoreCartDto createNewCart(FakeStoreCartDto fakeStoreCartDto);

    FakeStoreCartDto updateCart(FakeStoreCartDto fakeStoreCartDto, Long id);
    FakeStoreCartDto deleteCart(Long id);

}
