package com.retailStore.retailStore.dto;

public class CategoryDTO {
    private Long id;
    private String categoryName;
    private String description;
    private boolean disabled;

    public CategoryDTO(Long id, String categoryName, String description, boolean disabled) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.disabled = disabled;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isDisabled() { 
    	return disabled; 
    }
    
    public void setDisabled(boolean disabled) { 
    	this.disabled = disabled; 
    }
}
