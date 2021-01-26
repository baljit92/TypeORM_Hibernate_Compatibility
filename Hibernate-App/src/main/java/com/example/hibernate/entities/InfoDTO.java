package com.example.hibernate.entities;

/**
 * InfoDTO (Data Transfer Object)
 */
public class InfoDTO {

    private String description;

    public InfoDTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}