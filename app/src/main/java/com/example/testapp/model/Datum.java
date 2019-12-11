package com.example.testapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    public Datum(VariantText variantText, String name) {
        this.variantText = variantText;
        this.name = name;
    }

    VariantText variantText;

    public VariantText getVariantText() {
        return variantText;
    }

    public void setVariantText(VariantText variantText) {
        this.variantText = variantText;
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
