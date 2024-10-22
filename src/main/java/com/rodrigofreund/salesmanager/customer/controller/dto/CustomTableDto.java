package com.rodrigofreund.salesmanager.customer.controller.dto;

import java.io.Serializable;
import java.util.Collection;

import lombok.Getter;

@Getter
public class CustomTableDto implements Serializable {

    private static final long serialVersionUID = -6656609397089413627L;

    private String name;
    private Collection<CustomField> customDataFields;
}
