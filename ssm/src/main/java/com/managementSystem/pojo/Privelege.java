package com.managementSystem.pojo;

public class Privelege {
    private String priId;

    private String name;

    private String description;

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId == null ? null : priId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}