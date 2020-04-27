package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/demo1")
@Controller
public class ProductController {
    
            
    @Autowired
    private ProductService productService;


//      @ResponseBody
//    @RequestMapping("/products1")
//    public  List<ProductCategoryImageDto> viewProductPage() {
//        List<ProductCategoryImageDto> list = productService.listProductCategoryImage();
//          
//        return list;
//    }
     
        @RequestMapping("/products")
    public String viewProductPage(ModelMap mm) {
            List<ProductCategoryImageDto> list = productService.listProductCategoryImage();
            mm.addAttribute("listproducts", list);
            System.out.println(list.get(0).getProductName());
        return "productview";
    }

    
}
