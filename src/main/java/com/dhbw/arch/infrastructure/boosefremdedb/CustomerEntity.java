package com.dhbw.arch.infrastructure.boosefremdedb;

import java.util.Date;

class CustomerEntity {
    private int id;
    private String name;
    private int age;
    private Date createdAt;
    private Date updatedAt;

    public CustomerEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int newCustomerId) {
        this.id = newCustomerId;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
