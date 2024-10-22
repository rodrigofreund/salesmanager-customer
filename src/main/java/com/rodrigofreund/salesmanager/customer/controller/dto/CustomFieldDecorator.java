package com.rodrigofreund.salesmanager.customer.controller.dto;

import lombok.Getter;

@Getter
public class CustomFieldDecorator implements ICustomField {

    private ICustomField field;

    public CustomFieldDecorator(ICustomField field) {
        this.field = field;
    }
}
