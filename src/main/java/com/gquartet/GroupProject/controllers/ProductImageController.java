package com.gquartet.GroupProject.controllers;

import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.services.ProductImageService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @RequestMapping("/saveProductImage")
    public String saveProductImage(@RequestParam(value = "myfile") MultipartFile multipart) {
        ProductImage productImage = new ProductImage();

        try {
            //save to db
            //ousiastika tou leme na parei ta byte tou arxeiou
            productImage.setProductImage(multipart.getBytes());
            productImage.setProductFilename(multipart.getOriginalFilename());
        } catch (IOException ex) {
            Logger.getLogger(ProductImageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        productImageService.storeFileToDB(productImage); //save product image

        return "redirect:/products";
    }

}
