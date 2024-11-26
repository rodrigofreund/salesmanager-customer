package com.rodrigofreund.salesmanager.customer.controller.dto;

import java.time.LocalDateTime;

public record OrderData(Integer id, LocalDateTime date, String customer) {

}
