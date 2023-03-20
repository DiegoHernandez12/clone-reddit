package com.clone.service.categories.services;

import com.clone.service.categories.dtos.SubCategoryDTO;
import com.clone.service.categories.models.entities.SubCategory;
import com.clone.service.categories.repositories.SubCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImp implements SubCategoryService{
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategoryDTO> findAll() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream()
                //.map(subCategory -> modelMapper.map(subCategory, SubCategoryDTO.class))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubCategoryDTO findById(Long id) {
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subcategorie not found with by id" + id));
        return convertToDTO(subCategory);
    }

    @Override
    public SubCategoryDTO create(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = convertToEntity(subCategoryDTO);
        SubCategory saveSubCategory = subCategoryRepository.save(subCategory);
        return convertToDTO(saveSubCategory);
    }

   @Override
   public SubCategoryDTO update(Long id, SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryRepository.getReferenceById(id);
        subCategory.setName(subCategoryDTO.getName());
        SubCategory updateSubCategory = subCategoryRepository.save(subCategory);
        return convertToDTO(updateSubCategory);
   }

    @Override
    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public SubCategoryDTO convertToDTO(SubCategory subCategory){
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        subCategoryDTO.setId(subCategory.getId());
        subCategoryDTO.setName(subCategory.getName());
        return subCategoryDTO;
    }

    public SubCategory convertToEntity(SubCategoryDTO subCategoryDTO){
        SubCategory subCategory = new SubCategory();
        subCategory.setId(subCategoryDTO.getId());
        subCategory.setName(subCategoryDTO.getName());
        return  subCategory;
    }
}
