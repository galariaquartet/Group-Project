package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.dtos.ProductCategoryImageDto;
import com.gquartet.GroupProject.models.Category;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.services.CategoryService;
import com.gquartet.GroupProject.services.ProductImageService;
import com.gquartet.GroupProject.services.ProductService;
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
    private CategoryService categoryService;

    @Autowired
    ProductImageService productImageService;

//TODO VALIDATOS
    //TODO add photo to upadate form 
    
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
        List<Category> categoryNames = categoryService.listAll();
        mm.addAttribute("categoryList", categoryNames);
        return "newProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveCategory(@RequestParam(value = "myfile") MultipartFile multipart, ModelMap mm, @ModelAttribute("product") ProductCategoryImageDto productCategoryImageDto ) {
        Product product = new Product();

        product.setProductId(productCategoryImageDto.getProductId());

        int key = productCategoryImageDto.getCategoryId();
        product.setCategoryId(categoryService.getCategory(key));

        product.setProductDescription(productCategoryImageDto.getProductDescription());
        product.setProductName(productCategoryImageDto.getProductName());
        product.setProductPrice(productCategoryImageDto.getProductPrice());
        product.setProductStock(productCategoryImageDto.getProductStock());

        productService.save(product);
        //apo edw k katw afora tis fwtografies
        ProductImage productImage = new ProductImage();
       productImage.setProductFilename(productCategoryImageDto.getFilename());//pairnei thn onomasia k thn katalh3h apo authn pou tou exei dwsei o xrhsth
        try {      
            //save to db
            //ousiastika tou leme na parei ta byte tou arxeiou 
            productImage.setProductImage(multipart.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        productImage.setProductId(product);//bazoume to foreign key sth product image
        productImageService.storeFileToDB(productImage); //save product image
        
        return "redirect:/products";
    }

    //gia na ftia3oume to update arxika phgainoume sthn forma 
    @RequestMapping("/editProduct/{productId}")
    public String showEditProductForm(@PathVariable("productId") int productId, ModelMap mm) {         
        mm.addAttribute("product", productService.getProduct(productId));
                List<Category> categoryNames = categoryService.listAll();
        mm.addAttribute("categoryList", categoryNames);

     //  List<ProductImage> pis = productImageService.findProductImageByProductId(productId);
       
        //System.out.println("************"+pis);
      //  mm.addAttribute("filename", pis);
        return "updateFormProduct";
    }

    @RequestMapping("/updateProduct")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("product") Product product) {              
        productService.update(product);
     
        return "redirect:/products";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteCategory(@PathVariable int productId, ModelMap mm) {
        productService.delete(productId);
        return "redirect:/products";
    }
}
