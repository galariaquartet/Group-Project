package com.gquartet.GroupProject.controllers;

import com.google.gson.Gson;
import com.gquartet.GroupProject.models.Color;
import com.gquartet.GroupProject.models.Gender;
import com.gquartet.GroupProject.models.Material;
import com.gquartet.GroupProject.models.Product;
import com.gquartet.GroupProject.models.ProductImage;
import com.gquartet.GroupProject.models.ProductSize;
import com.gquartet.GroupProject.models.Subcategory;
import com.gquartet.GroupProject.services.ColorService;
import com.gquartet.GroupProject.services.GenderService;
import com.gquartet.GroupProject.services.MaterialService;
import com.gquartet.GroupProject.services.ProductImageService;
import com.gquartet.GroupProject.services.ProductService;
import com.gquartet.GroupProject.services.SizeService;
import com.gquartet.GroupProject.services.SubCategoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private GenderService genderService;

    //TODO VALIDATOS
    //TODO add photo to upadate form 
    @RequestMapping("/products")
    public String viewProductPage(ModelMap mm) {
        List<String> distinctProductNames = productService.getDistinctNames();
        List<List<Product>> products = new ArrayList<>();
        for (String s : distinctProductNames) {
            products.add(productService.getProductsByName(s)); //apo8hkeuei se mia lista mia allh lista me products
        }
        mm.addAttribute("allproducts", products);
        return "productview";
    }

    @ResponseBody
    @RequestMapping("/allp")
    public List<List<Product>> allprod(ModelMap mm) {
        List<String> distinctProductNames = productService.getDistinctNames();
        List<List<Product>> products = new ArrayList<>();
        for (String s : distinctProductNames) {
            products.add(productService.getProductsByName(s)); //apo8hkeuei se mia lista mia allh lista me products
        }
        return products;
        
//        String json = new Gson().toJson(products);
//        return json;
    }

    @RequestMapping("/newProduct")
    public String viewNewProductForm(ModelMap mm) {
        Product product = new Product();
        mm.addAttribute("product", product);

        List<Subcategory> subcategory = subCategoryService.listAll();
        mm.addAttribute("subcategory", subcategory);
        List<Color> colors = colorService.listAll();
        mm.addAttribute("colors", colors);
        List<ProductSize> sizes = sizeService.listAll();
        mm.addAttribute("sizes", sizes);
        List<Gender> genders = genderService.listAll();
        mm.addAttribute("genders", genders);
        List<Material> materials = materialService.listAll();
        mm.addAttribute("materials", materials);

        return "newProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(ModelMap mm, @ModelAttribute("product") Product product, @RequestParam("myphotos") String myphotos, @ModelAttribute("colorId") List<Color> colors) {
        Product pr = new Product();

        pr.setProductId(product.getProductId());
        pr.setProductName(product.getProductName());
        pr.setProductStock(product.getProductStock());
        pr.setProductPrice(product.getProductPrice());
        pr.setColorId(product.getColorId());
        pr.setGenderId(product.getGenderId());
        pr.setMaterialId(product.getMaterialId());
        pr.setSizeId(product.getSizeId());
        pr.setSubcategoryId(product.getSubcategoryId());
        productService.save(pr);

        ProductImage productImage = new ProductImage();
        productImage.setProductImageId(null);

        productImage.setProductFilepath(myphotos);
        productImage.setProductId(pr);

        productImageService.save(productImage);

        return "redirect:/products";
    }

    //gia na ftia3oume to update arxika phgainoume sthn forma 
    @RequestMapping("/editProduct/{productId}")
    public String showEditProductForm(@PathVariable("productId") int productId, ModelMap mm) {
        mm.addAttribute("product", productService.getProduct(productId));
        List<Subcategory> subcategory = subCategoryService.listAll();
        mm.addAttribute("subcategory", subcategory);
        List<Color> colors = colorService.listAll();
        mm.addAttribute("colors", colors);
        List<ProductSize> sizes = sizeService.listAll();
        mm.addAttribute("sizes", sizes);
        List<Gender> genders = genderService.listAll();
        mm.addAttribute("genders", genders);
        List<Material> materials = materialService.listAll();
        mm.addAttribute("materials", materials);

        return "updateFormProduct";
    }

    @RequestMapping("/updateProduct")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("product") Product product) {
        productService.update(product);

        return "redirect:/products";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, ModelMap mm) {
        productService.delete(productId);
        return "redirect:/products";
    }

}
