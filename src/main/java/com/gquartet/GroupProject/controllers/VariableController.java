package com.gquartet.GroupProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.gquartet.GroupProject.services.ColorService;
import com.gquartet.GroupProject.models.Color;
import com.gquartet.GroupProject.models.Gender;
import com.gquartet.GroupProject.models.Material;
import com.gquartet.GroupProject.models.ProductSize;
import com.gquartet.GroupProject.services.GenderService;
import com.gquartet.GroupProject.services.MaterialService;
import com.gquartet.GroupProject.services.SizeService;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VariableController {

    @Autowired
    private ColorService colorService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private MaterialService materialService;

    @RequestMapping("/variables")
    public String viewVariables(ModelMap mm) {
        List<Color> colors = colorService.listAll();
        mm.addAttribute("colors", colors);
        Color newcolor = new Color();
        mm.addAttribute("newcolor", newcolor);
        return "variableView";
    }

    @RequestMapping("/saveColor")
    public String newColor(@ModelAttribute("newcolor") Color color) {
        colorService.save(color);
        return "redirect:/variables";
    }
    
    @RequestMapping("/deleteColor/{colorId}")
    public String deleteSize(@PathVariable int colorId) {
        colorService.delete(colorId);
        return "redirect:/variables";
    }

    @ModelAttribute("sizes")
    public List<ProductSize> getSizes(ModelMap mm) {
        return sizeService.listAll();
    }

    @ModelAttribute("ProductSize")
    public ProductSize newSize(ModelMap mm) {
        ProductSize s = new ProductSize();
        return s;
    }

    @RequestMapping("/saveProductSize")
    public String saveSize(@ModelAttribute("newsize") ProductSize productSize) {
        sizeService.save(productSize);
        return "redirect:/variables";
    }

    @RequestMapping("/deleteSize/{sizeId}")
    public String deleteSize(@PathVariable int sizeId, ModelMap mm) {
        sizeService.delete(sizeId);
        return "redirect:/variables";
    }

    @ModelAttribute("genders")
    public List<Gender> getGenders(ModelMap mm) {
        return genderService.listAll();
    }

    @ModelAttribute("newgender")
    public Gender newGender(ModelMap mm) {
        Gender g = new Gender();
        return g;
    }

    @RequestMapping("/saveGender")
    public String saveGender(@ModelAttribute("newgender") Gender gender) {
        genderService.save(gender);
        return "redirect:/variables";
    }

    @RequestMapping("/deleteGender/{genderId}")
    public String deleteGender(@PathVariable int genderId) {
        genderService.delete(genderId);
        return "redirect:/variables";
    }

    @ModelAttribute("materials")
    public List<Material> getMaterials(ModelMap mm) {
        return materialService.listAll();
    }

    @ModelAttribute("newMaterial")
    public Material newMaterial(ModelMap mm) {
        Material m = new Material();
        return m;
    }

    @RequestMapping("/saveMaterial")
    public String saveMaterial(@ModelAttribute("newMaterial") Material material) {
        materialService.save(material);
        return "redirect:/variables";
    }

    @RequestMapping("/deleteMaterial/{materialId}")
    public String deleteMaterial(@PathVariable int materialId) {
        materialService.delete(materialId);
        return "redirect:/variables";
    }
}
