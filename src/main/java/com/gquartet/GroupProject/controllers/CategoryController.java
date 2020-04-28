package com.gquartet.GroupProject.controllers;

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

    @RequestMapping("/category")
    public String viewHomePage(ModelMap mm) {
        List<Category> list = categoryService.listAll();
        mm.addAttribute("listcategory", list);
        return "categoryView";
    }

    @RequestMapping("/newCategory")
    public String viewNewCategoryForm(ModelMap mm) {
        Category category = new Category();
        mm.addAttribute("category", category);
        return "newCategory";
    }

    @RequestMapping("/saveCategory")
    public String saveCategory(ModelMap mm, @ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    //gia na ftia3oume to update arxika phgainoume sthn forma 
    @RequestMapping("/edit/{categoryId}")
    public String showEditCategoryForm(@PathVariable("categoryId") int categoryId, ModelMap mm) {
        mm.addAttribute("category", categoryService.getCategory(categoryId));
        return "updateFormCategory";
    }

    @RequestMapping("/updateCategory")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/category";
    }

    @RequestMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId, ModelMap mm) {
        categoryService.delete(categoryId);
        return "redirect:/category";
    }
}
