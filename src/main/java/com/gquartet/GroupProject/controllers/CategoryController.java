package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.services.CategoryService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CategoryController {
        //TODO validators 
    //TODO update form --> na thn ftia3w ws pros to update k na doume ti allo exoume na kanoume
        
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
    public String saveCategory(@RequestParam(value = "mycategoryImage") MultipartFile multipart, ModelMap mm, @ModelAttribute("category") Category category) {  
        //edw pros8etoume to arxeio sto category k meta kaloume to service
        try {
            category.setCategoryImage(multipart.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        categoryService.save(category);
        return "redirect:/category";
    }

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
