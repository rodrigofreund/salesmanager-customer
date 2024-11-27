package com.rodrigofreund.salesmanager.customer.domain.entity;

import com.rodrigofreund.salesmanager.customer.domain.Address;

public class Customer {

    private String name;
    private String socialName;
    private String finantialNumber;
    
    private Address address;

    public Customer(String name, String socialName, String finantialNumber) {
        super();
        if(null == name || name.isBlank())
            throw new IllegalArgumentException("Customer name is mandatory");
        this.name = name;

        if(null == socialName || socialName.isBlank())
            throw new IllegalArgumentException("Customer social name is mandatory");
        this.socialName = socialName;

        if (null == finantialNumber || !finantialNumber.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}"))
            throw new IllegalArgumentException("Invalid or not set finantial number");
        this.finantialNumber = finantialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSocialName() {
        return socialName;
    }

    public String getFinantialNumber() {
        return finantialNumber;
    }

    public Address getAddress() {
        return address;
    }
}
