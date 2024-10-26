package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

public interface CategoryService {
    PageResult page(CategoryPageQueryDTO queryDTO);

    void addCategory(CategoryDTO categoryDTO);

    void startOrStop(String status, Long id);

    void editCategory(CategoryDTO categoryDTO);

    void deleteById(Long id);
}
