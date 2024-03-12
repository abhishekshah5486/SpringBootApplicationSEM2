package com.abhishek.springbootapplicationsem2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartDto {
    private Long id;
    private Long userId;
    private String date;
    private List<Object> products;
}
