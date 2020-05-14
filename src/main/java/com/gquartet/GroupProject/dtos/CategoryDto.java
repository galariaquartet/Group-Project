
package com.gquartet.GroupProject.dtos;

public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private String categoryFilepath;

    public CategoryDto() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryFilepath() {
        return categoryFilepath;
    }

    public void setCategoryFilepath(String categoryFilepath) {
        this.categoryFilepath = categoryFilepath;
    }
    
    
    
}
