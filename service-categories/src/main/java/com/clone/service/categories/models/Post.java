package com.clone.service.categories.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
    private Long id;
    private String title;
    private String description;
}
