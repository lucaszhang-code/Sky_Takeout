package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @GetMapping("page")
    @ApiOperation("分类页面分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO queryDTO) {
        log.info("分类查询{}", queryDTO);
        PageResult pageResult = categoryService.page(queryDTO);
        return Result.success(pageResult);
    }

    /**
     * 添加分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<Object> addCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("新增菜品{}", categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 修改分类状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("修改分类状态")
    public Result<Object> startOrStop(@PathVariable String status, Long id) {
        log.info("status:{}", status);
        categoryService.startOrStop(status, id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("编辑分类")
    public Result<Object> editCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.editCategory(categoryDTO);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除分类")
    public Result<Object> deleteCategory(Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    @GetMapping("list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> getCategoryByType(Integer type) {
        List<Category> result = categoryService.getCategoryByType(type);
        return Result.success(result);
    }
}
