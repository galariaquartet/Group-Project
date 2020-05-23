/*
 * Created on 23/05/2020 at 14:07:40 GMT+2
 */
package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.services.CategoryService;
import com.gquartet.GroupProject.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;

    @RequestMapping("/adminMain")
    public String adminMain(ModelMap mm) {
        return "adminMain";
    }

    

}
