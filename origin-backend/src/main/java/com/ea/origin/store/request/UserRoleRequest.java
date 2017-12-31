package com.ea.origin.store.request;

public class UserRoleRequest {
    private String role;
    private String description;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}