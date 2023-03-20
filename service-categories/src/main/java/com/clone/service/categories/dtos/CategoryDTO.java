package com.clone.service.categories.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CategoryDTO {
    private Long id;
    private String name;
    private  String icon;
}