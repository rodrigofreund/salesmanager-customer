package com.rodrigofreund.salesmanager.customer.domain;

public class Address {

    private String street;
    private Integer number;
    private String city;
    private String district;

    public Address(String street, Integer number, String city, String district) {
        super();
        this.street = street;
        this.number = number;
        this.city = city;
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

}
