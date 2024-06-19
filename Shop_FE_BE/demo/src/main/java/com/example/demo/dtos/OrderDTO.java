package com.example.demo.dtos;

import com.example.demo.model.Product;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {



    private String email;

    private Long productId;

    private float price;


}
