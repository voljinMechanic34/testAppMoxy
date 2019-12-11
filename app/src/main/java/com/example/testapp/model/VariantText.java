package com.example.testapp.model;

public class VariantText {
    int selectedId;
    String name = "selector";
    int id;
    String text;

    public VariantText(int selectedId, int id, String text) {
        this.selectedId = selectedId;
        this.id = id;
        this.text = text;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
