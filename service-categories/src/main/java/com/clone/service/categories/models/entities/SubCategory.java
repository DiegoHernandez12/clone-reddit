package com.clone.service.categories.models.entities;

import com.clone.service.categories.models.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subcategories")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name is required")
    private String name;
    private Boolean enable;

    @Transient
    private List<Post> post;
}
