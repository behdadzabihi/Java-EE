package com.javaweb.jetty.product.domain;

public class Product {

    Long id;
    String name;
    String model;
    String factory;

    public Product(Long id, String name, String model, String factory) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.factory = factory;
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(String name, String model, String factory) {
        this.name = name;
        this.model = model;
        this.factory = factory;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
