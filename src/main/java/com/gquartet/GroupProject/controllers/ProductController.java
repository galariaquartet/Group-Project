package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.models.Subcategory;
import com.gquartet.GroupProject.services.CategoryService;
import com.gquartet.GroupProject.services.ProductImageService;
import com.gquartet.GroupProject.services.ProductService;
import com.gquartet.GroupProject.services.ShoppingCartService;
import com.gquartet.GroupProject.services.SubCategoryService;
import java.io.File;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ProductImageService productImageService;

//TODO VALIDATOS
    //TODO add photo to upadate form 
    @RequestMapping("/products")
    public String viewProductPage(ModelMap mm) {
        List<Product> list = productService.listAll();
        mm.addAttribute("listproducts", list);
        return "productview";
    }


    @RequestMapping("/newProduct")
    public String viewNewProductForm(ModelMap mm) {
        Product product = new Product();
        mm.addAttribute("product", product);
        List<Subcategory> subcategory = subCategoryService.listAll();
        mm.addAttribute("subcategory", subcategory);
        return "newProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(ModelMap mm, @ModelAttribute("product") Product product, @RequestParam("myphotos") String myphotos) {
        Product pr = new Product();

        pr.setProductId(product.getProductId());
        pr.setProductName(product.getProductName());
        pr.setProductSize(product.getProductSize());
        pr.setProductColor(product.getProductColor());
        pr.setProductMaterial(product.getProductMaterial());        
        pr.setProductGender(product.getProductGender());
        pr.setProductStock(product.getProductStock());
        pr.setProductPrice(product.getProductPrice());

        pr.setSubcategoryId(product.getSubcategoryId());
                productService.save(pr);
       
            
             ProductImage productImage = new ProductImage();             
             productImage.setProductImageId(null);            
                      
             productImage.setProductFilepath(myphotos);
              productImage.setProductId(pr);  
              
             productImageService.save(productImage);


        return "redirect:/products";
    }

//    //gia na ftia3oume to update arxika phgainoume sthn forma 
//    @RequestMapping("/editProduct/{productId}")
//    public String showEditProductForm(@PathVariable("productId") int productId, ModelMap mm) {
//        mm.addAttribute("product", productService.getProduct(productId));
//        List<Category> categoryNames = categoryService.listAll();
//        mm.addAttribute("categoryList", categoryNames);
//        return "updateFormProduct";
//    }
//
//    @RequestMapping("/updateProduct")
//    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("product") Product product) {
//        productService.update(product);
//
//        return "redirect:/products";
//    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, ModelMap mm) {
        productService.delete(productId);
        return "redirect:/products";
    }
}
