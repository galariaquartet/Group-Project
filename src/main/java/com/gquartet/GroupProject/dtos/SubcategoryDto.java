package com.gquartet.GroupProject.dtos;

import com.gquartet.GroupProject.models.Category;

public class SubcategoryDto {

    private int subcategoryId;
    private String subcategoryName;
    private String subcategoryImageFilepath;
    private Category categoryId;

    public SubcategoryDto() {

    }

    public SubcategoryDto(int subcategoryId, String subcategoryName, String subcategoryImageFilepath, Category categoryId) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
        this.subcategoryImageFilepath = subcategoryImageFilepath;
        this.categoryId = categoryId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcategoryImageFilepath() {
        return subcategoryImageFilepath;
    }

    public void setSubcategoryImageFilepath(String subcategoryImageFilepath) {
        this.subcategoryImageFilepath = subcategoryImageFilepath;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

}
