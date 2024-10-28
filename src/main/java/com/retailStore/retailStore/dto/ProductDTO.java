package com.retailStore.retailStore.dto;

public class ProductDTO {
    private Long id;
    private String productName;
    private Double price;
    private Integer stock;
    private CategoryDTO category;

    public ProductDTO(Long id, String productName, Double price, Integer stock, CategoryDTO category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
