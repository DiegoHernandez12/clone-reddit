package com.clone.service.categories.repositories;

import com.clone.service.categories.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
