package com.workup.biddingModule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task {
    @Id
    private String taskId;
    private String taskName;
    private double price;

    public Task() {}

    public Task(String taskId, String taskName, double price) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.price = price;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
