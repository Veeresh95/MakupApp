package com.example.makeup.Model;

import com.google.gson.annotations.SerializedName;

public class ProductColor {
    @SerializedName("colour_name")
    private String colourName;

    @SerializedName("hex_value")
    private String hexValue;

    public ProductColor(String colourName, String hexValue) {
        this.colourName = colourName;
        this.hexValue = hexValue;
    }

    public void setColourName(String colourName){
        this.colourName = colourName;
    }

    public String getColourName(){
        return colourName;
    }

    public void setHexValue(String hexValue){
        this.hexValue = hexValue;
    }

    public String getHexValue(){
        return hexValue;
    }
}
