package com.restfulapi.spring_rest.Order;

public class OrderProduct {
    private String productName;
    private String customerName;
    private int quantity;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


     @Override
    public String toString(){
         return "Order Details : ProductName : "+getProductName()+" CustomerName : "+getCustomerName()+" Quantity : "+getQuantity();
     }

}
