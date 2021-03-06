package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.CategoryDto;
import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/adminCategory")
    public String adminCategory(ModelMap mm) {
        List<Category> list = categoryService.listAll();
        mm.addAttribute("listcategory", list);

        CategoryDto categoryDto = new CategoryDto();
        mm.addAttribute("category", categoryDto);
        return "adminCategory";
    }

    @RequestMapping("/saveCategory")
    public String saveCategory(ModelMap mm, @ModelAttribute("category") CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryImageFilepath(categoryDto.getCategoryFilepath());
        categoryService.save(category);
        return "redirect:/adminCategory";
    }

    @RequestMapping("/editCategory/{categoryId}")
    public String showEditCategoryForm(@PathVariable("categoryId") int categoryId, ModelMap mm) {
        mm.addAttribute("category", categoryService.getCategory(categoryId));
        return "updateFormCategory";
    }


    @RequestMapping("/updateCategory")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/adminCategory";
    }

    @RequestMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId, ModelMap mm) {
        categoryService.delete(categoryId);
        return "redirect:/adminCategory";
    }
}
