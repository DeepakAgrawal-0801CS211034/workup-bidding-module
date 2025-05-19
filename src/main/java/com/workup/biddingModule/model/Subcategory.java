package com.workup.biddingModule.model;

import java.util.List;

public class Subcategory {
    private String subcategoryId;
    private String subcategoryName;
    private List<Task> tasks;

    public Subcategory() {}

    public Subcategory(String subcategoryId, String subcategoryName, List<Task> tasks) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
        this.tasks = tasks;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
