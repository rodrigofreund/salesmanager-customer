package com.rodrigofreund.salesmanager.customer.controller.dto;

import lombok.Getter;

@Getter
public class CustomFieldValue extends CustomFieldDecorator {

    public CustomFieldValue(CustomFieldValue field) {
        super(field);
    }
    private String value;
}
