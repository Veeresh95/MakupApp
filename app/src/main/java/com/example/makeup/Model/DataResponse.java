package com.example.makeup.Model;

import java.util.ArrayList;
import java.util.List;

public class DataResponse {


    private Integer id;
    private String brand;
    private String name;
    private String price;
    private String priceSign;
    private String currency;
    private String imageLink;
    private String productLink;
    private String websiteLink;
    private String description;
    private String rating;
    private String category;
    private String productType;
    private List<String> tagList = new ArrayList<String>();
    private String createdAt;
    private String updatedAt;
    private String productApiUrl;
    private String apiFeaturedImage;
    private ArrayList<ProductColor> productColors = new ArrayList<ProductColor>();

    public DataResponse(Integer id, String brand, String name, String price, String priceSign, String currency, String imageLink, String productLink, String websiteLink, String description, String rating, String category, String productType, List<String> tagList, String createdAt, String updatedAt, String productApiUrl, String apiFeaturedImage, ArrayList<ProductColor> productColors) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.priceSign = priceSign;
        this.currency = currency;
        this.imageLink = imageLink;
        this.productLink = productLink;
        this.websiteLink = websiteLink;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.productType = productType;
        this.tagList = tagList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productApiUrl = productApiUrl;
        this.apiFeaturedImage = apiFeaturedImage;
        this.productColors = productColors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSign() {
        return priceSign;
    }

    public void setPriceSign(String priceSign) {
        this.priceSign = priceSign;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProductApiUrl() {
        return productApiUrl;
    }

    public void setProductApiUrl(String productApiUrl) {
        this.productApiUrl = productApiUrl;
    }

    public String getApiFeaturedImage() {
        return apiFeaturedImage;
    }

    public void setApiFeaturedImage(String apiFeaturedImage) {
        this.apiFeaturedImage = apiFeaturedImage;
    }

    public ArrayList<ProductColor> getProductColors() {
        return productColors;
    }

    public void setProductColors(ArrayList<ProductColor> productColors) {
        this.productColors = productColors;
    }

}
