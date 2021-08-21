package com.example.makeup.Model;

public class ProductColor {

    private String hexValue;
    private String colourName;

    public ProductColor(String hexValue, String colourName) {
        this.hexValue = hexValue;
        this.colourName = colourName;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }
}
