package com.gquartet.GroupProject.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/products")
    public String products() {
        return "products";
    }

    @RequestMapping("/productdetails/{index}")
    public String productDetails(@PathVariable("index") int index, ModelMap mm) {
        mm.addAttribute("index", index);
        return "productdetails";
    }

    @ResponseBody
    @RequestMapping("/JsonProducts")
    public List<List<Product>> allProducts(ModelMap mm) {
        List<String> distinctProductNames = productService.getDistinctNames();
        List<List<Product>> products = new ArrayList<>();
        for (String s : distinctProductNames) {
            products.add(productService.getProductsByName(s));
        }
        return products;
    }

    //******************************ADMIN******************************************
    @RequestMapping("/adminProductList")
    public String adminProductList(ModelMap mm) {
        List<Product> list = productService.listAll();
        mm.addAttribute("productList", list);

        List<ProductImage> imagelist = productImageService.getAllImages();
        mm.addAttribute("imagelist", imagelist);

        return "adminProduct";
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
        mm.addAttribute("formpath", "saveProduct");
        return "newProduct";
    }

    @RequestMapping("/saveProduct")
    public String saveProduct(ModelMap mm, @ModelAttribute("product") Product product, @RequestParam("myphotos") String myphotos) {

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

        //ousiasthka xwrizoume ta 2 url me komma meta // url1, url2, url3
        String[] allPhotoFilepaths = myphotos.split(",");
        for (int i = 0; i < allPhotoFilepaths.length; i++) {
            ProductImage productImage = new ProductImage();
            productImage.setProductImageId(null);
            productImage.setProductId(pr);
            productImage.setProductFilepath(allPhotoFilepaths[i].trim());
            productImageService.save(productImage);

        }

        return "redirect:/adminProductList";
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
        mm.addAttribute("imageFilePath", productImageService.findProductImageByProductId(productId));
        // mm.addAttribute("formpath", "editProduct");
        return "updateFormProduct";
    }

    @RequestMapping("/updateProduct")
    public String saveUpdatedCategory(ModelMap mm, @ModelAttribute("product") Product product) {
        productService.update(product);

        return "redirect:/adminProductList";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, ModelMap mm) {
        productService.delete(productId);
        return "redirect:/adminProductList";
    }

}
