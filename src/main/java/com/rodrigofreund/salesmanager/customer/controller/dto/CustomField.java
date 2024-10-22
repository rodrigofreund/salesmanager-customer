package com.rodrigofreund.salesmanager.customer.controller.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class CustomField implements Serializable, ICustomField {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private String defaultValue;
    private String required;
}
