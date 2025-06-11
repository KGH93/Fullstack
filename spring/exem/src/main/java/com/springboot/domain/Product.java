package com.springboot.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class Product {

    @NotEmpty
    @Size(min = 4, max = 10, message = "품명은 4~10자 이내로 입력하세요")
    private String name;

    @Min(value = 0, message = "가격은 0 이상이어야 합니다")
    private Integer price;
}
