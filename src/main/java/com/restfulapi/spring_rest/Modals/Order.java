package com.restfulapi.spring_rest.Modals;

public class Order {
    private String productName;
    private String productCompany;
    private int quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order Details : => Product Name : "+getProductName()+", "+"Product Company : "+getProductCompany()+","+" Product Quantity : "+ getQuantity();
    }
}
