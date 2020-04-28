package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.services.CategoryService;
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
    @Autowired
    private CategoryService categoryService;


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
        return "productview";
    }
    
    
        @RequestMapping("/newProduct")
    public String viewNewProductForm(ModelMap mm) {
        ProductCategoryImageDto productCategoryImageDto = new ProductCategoryImageDto();
        mm.addAttribute("product", productCategoryImageDto);
        Category category = new Category();
        List<Category> categoryNames = categoryService.listAll();
        mm.addAttribute("categoryList", categoryNames);
        return "newProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveCategory(ModelMap mm, @ModelAttribute("product") ProductCategoryImageDto productCategoryImageDto) {
        Product product = new Product();
        
        product.setProductId(productCategoryImageDto.getProductId());
        product.setProductName(productCategoryImageDto.getProductName());
        product.setProductDescription(productCategoryImageDto.getProductDescription());
        product.setProductStock(productCategoryImageDto.getProductStock());
        product.setProductPrice(productCategoryImageDto.getProductPrice());
        int key = productCategoryImageDto.getCategoryId();
      //  Category categoryId = categoryService.cate(key);
        System.out.println("######################## "+categoryService.getCategory(key));
      //  product.setCategoryId(categoryService.getCategoryId(key));
        System.out.println("******************getCategoryName "+productCategoryImageDto.getCategoryId() +" getCategoryId"+ productCategoryImageDto.getCategoryId()+"***************");
      //  product.setCategoryId(categoryId);
        
        productService.save(product);
        return "redirect:/productview";
    }
//
//    //gia na ftia3oume to update arxika phgainoume sthn forma 
//    @RequestMapping("/edit/{categoryId}")
//    public String showEditCategoryForm(@PathVariable("categoryId") int categoryId, ModelMap mm) {
//        mm.addAttribute("category", categoryService.getCategory(categoryId));
//        return "updateFormCategory";
//    }
//
//    @RequestMapping("/updateCategory")
//    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("category") Category category) {
//        categoryService.update(category);
//        return "redirect:/category";
//    }
//
//    @RequestMapping("/delete/{categoryId}")
//    public String deleteCategory(@PathVariable int categoryId, ModelMap mm) {
//        categoryService.delete(categoryId);
//        return "redirect:/category";
//    }

    
}
