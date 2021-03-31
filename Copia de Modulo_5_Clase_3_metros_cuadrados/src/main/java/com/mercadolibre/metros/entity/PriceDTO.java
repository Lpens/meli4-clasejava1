package com.mercadolibre.metros.entity;

public class PriceDTO {
    private  String location;
    private Integer price;

    public PriceDTO() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
