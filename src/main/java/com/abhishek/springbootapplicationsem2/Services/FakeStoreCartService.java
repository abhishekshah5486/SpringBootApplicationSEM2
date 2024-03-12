package com.abhishek.springbootapplicationsem2.Services;

import com.abhishek.springbootapplicationsem2.Models.Cart;
import com.abhishek.springbootapplicationsem2.dto.FakeStoreCartDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@Service
public class FakeStoreCartService implements CartService{

    RestTemplate restTemplate  = new RestTemplate();
    String url = "https://fakestoreapi.com";
    @Override
    public FakeStoreCartDto[] getAllCarts() {
        FakeStoreCartDto[] fakeStoreCartDto = restTemplate.getForObject(
                url + "/carts",
                FakeStoreCartDto[].class
        );
        assert fakeStoreCartDto != null;
        return fakeStoreCartDto;
    }

    @Override
    public FakeStoreCartDto getCartById(Long id) {
        FakeStoreCartDto fakeStoreCartDto = restTemplate.getForObject(
                url + "/carts/" + id,
                FakeStoreCartDto.class
        );
        return fakeStoreCartDto;
    }

    @Override
    public FakeStoreCartDto[] getCartsInDateRange(String startDate, String endDate) {
       FakeStoreCartDto[] fakeStoreCartDto = restTemplate.getForObject(
               url + "/carts?startdate="+startDate + "&enddate=" + endDate,
               FakeStoreCartDto[].class
       );
       return fakeStoreCartDto;
    }

    @Override
    public FakeStoreCartDto[] getUserCarts(Long userId) {
        FakeStoreCartDto[] fakeStoreCartDto = restTemplate.getForObject(
                url + "/carts/user/" + userId,
                FakeStoreCartDto[].class
        );
        return fakeStoreCartDto;
    }
    @Override
    public FakeStoreCartDto createNewCart(FakeStoreCartDto fakeStoreCartDto) {
        FakeStoreCartDto updatedCart = new FakeStoreCartDto();
        updatedCart.setDate(fakeStoreCartDto.getDate());
        updatedCart.setId(fakeStoreCartDto.getId());
        updatedCart.setProducts(fakeStoreCartDto.getProducts());
        updatedCart.setUserId(fakeStoreCartDto.getUserId());

        HttpEntity<FakeStoreCartDto> requestEntity = new HttpEntity<>(updatedCart);
        ResponseEntity<FakeStoreCartDto> response = restTemplate.exchange(
                url + "/carts",
                HttpMethod.POST,
                requestEntity,
                FakeStoreCartDto.class
        );
        assert response.getBody() != null;
        return response.getBody();

    }
    @Override
    public FakeStoreCartDto updateCart(FakeStoreCartDto fakeStoreCartDto, Long id) {
        FakeStoreCartDto updatedCart = new FakeStoreCartDto();
        updatedCart.setDate(fakeStoreCartDto.getDate());
        updatedCart.setId(fakeStoreCartDto.getId());
        updatedCart.setProducts(fakeStoreCartDto.getProducts());
        updatedCart.setUserId(fakeStoreCartDto.getUserId());

        HttpEntity<FakeStoreCartDto> requestEntity = new HttpEntity<>(updatedCart);
        ResponseEntity<FakeStoreCartDto> response = restTemplate.exchange(
                url + "/carts/" + id,
                HttpMethod.PUT,
                requestEntity,
                FakeStoreCartDto.class
        );
        assert response.getBody() != null;
        return response.getBody();
    }

    @Override
    public FakeStoreCartDto deleteCart(Long id) {
        ResponseEntity<FakeStoreCartDto> response = restTemplate.exchange(
                url + "/carts/" + id,
                HttpMethod.DELETE,
                null,
                FakeStoreCartDto.class
        );
        assert response.getBody() != null;
        return response.getBody();
    }


}
