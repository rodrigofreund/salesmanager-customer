package com.rodrigofreund.salesmanager.customer.entity.model;

import com.rodrigofreund.salesmanager.domain.Customer;

public final class CustomerImpl implements Customer {

    public static Customer of(
            Integer id,
            String name,
            String socialName,
            String finantialNumber,
            String socialNumber
            ) {
        return new CustomerImpl(id, name, socialName, finantialNumber, socialNumber);
    }

    public static Customer of(
            String name,
            String socialName,
            String finantialNumber,
            String socialNumber
            ) {
        return new CustomerImpl(null, name, socialName, finantialNumber, socialNumber);
    }

    private Integer id;
    private String name;
    private String socialName;
    private String finantialNumber;
    private String socialNumber;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String socialName() {
        return socialName;
    }

    @Override
    public String finantialNumber() {
        return finantialNumber;
    }

    @Override
    public String socialNumber() {
        return socialNumber;
    }

    public CustomerImpl copy() {
        return new CustomerImpl(this);
    }

    private CustomerImpl(
            Integer id,
            String name,
            String socialName,
            String finantialNumber,
            String socialNumber) {
        super();
        this.id = id;
        this.name = name;
        this.socialName = socialName;
        this.setFinantialNumber(finantialNumber);
        this.socialNumber = socialNumber;
    }

    private CustomerImpl(CustomerImpl other) {
        new CustomerImpl(other.id, other.name, other.socialName, other.finantialNumber, other.socialNumber);
    }

    private void setFinantialNumber(String finantialNumber) {
        if(finantialNumber == null || finantialNumber.isBlank() || finantialNumber.length() < 12)
            throw new IllegalArgumentException();
        this.finantialNumber = finantialNumber;
    }
}
