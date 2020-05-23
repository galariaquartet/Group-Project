package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.CategoryDto;
import com.gquartet.GroupProject.dtos.SubcategoryDto;
import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.Subcategory;
import com.gquartet.GroupProject.services.CategoryService;
import com.gquartet.GroupProject.services.SubCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/subCategory/{categoryId}")
    public String viewFilteredSubcategory(@PathVariable("categoryId") int categoryId, ModelMap mm) {
        List<Subcategory> list = subCategoryService.findSubcategories(categoryId);
        mm.addAttribute("listsubCategory", list);
        return "subcategoryView";
    }

    //******************************ADMIN SUBCATEGORY***************************************   

    @RequestMapping("/adminSubategory")
    public String viewAdminAllSubcategories(ModelMap mm) {
        List<Subcategory> list = subCategoryService.listAll();
        mm.addAttribute("listsubCategory", list);
        
        SubcategoryDto subcategoryDto = new SubcategoryDto();
        mm.addAttribute("subcategory", subcategoryDto);
        mm.addAttribute("categoryList", categoryService.listAll());
        
        return "adminSubcategory";
    }

//    @RequestMapping("/newSubcategory")
//    public String viewNewSubcategoryForm(ModelMap mm) {
//        SubcategoryDto subcategoryDto = new SubcategoryDto();
//        mm.addAttribute("subcategory", subcategoryDto);
//        mm.addAttribute("categoryList", categoryService.listAll());
//        return "newSubcategory";
//    }

    @RequestMapping("/saveSubcategory")
    public String saveCategory(ModelMap mm, @ModelAttribute("subcategory") SubcategoryDto subcategoryDto) {
        Subcategory subcategory = new Subcategory();
        subcategory.setSubcategoryId(subcategoryDto.getSubcategoryId());
        subcategory.setSubcategoryName(subcategoryDto.getSubcategoryName());
        subcategory.setSubcategoryImageFilepath(subcategoryDto.getSubcategoryImageFilepath());
        subcategory.setCategoryId(subcategoryDto.getCategoryId());
        subCategoryService.save(subcategory);
        return "redirect:/adminSubategory";
    }

    @RequestMapping("/editSubcategory/{subcategoryId}")
    public String showEditSubcategoryForm(@PathVariable("subcategoryId") int subcategoryId, ModelMap mm) {
        mm.addAttribute("subcategory", subCategoryService.getSubcategory(subcategoryId));
        mm.addAttribute("categoryList", categoryService.listAll());
        return "updateFormSubcategory";
    }

    @RequestMapping("/updateSubcategory")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("subcategory") Subcategory subcategory) {
        Subcategory sub = new Subcategory();
        sub.setSubcategoryId(subcategory.getSubcategoryId());
        sub.setSubcategoryName(subcategory.getSubcategoryName());
        sub.setSubcategoryImageFilepath(subcategory.getSubcategoryImageFilepath());
        sub.setCategoryId(subcategory.getCategoryId());
        subCategoryService.update(sub);
        return "redirect:/adminSubategory";
    }

    @RequestMapping("/deleteSubcategory/{subcategoryId}")
    public String deleteSubcategory(@PathVariable int subcategoryId, ModelMap mm) {
        subCategoryService.delete(subcategoryId);
        return "redirect:/adminSubategory";
    }

}
