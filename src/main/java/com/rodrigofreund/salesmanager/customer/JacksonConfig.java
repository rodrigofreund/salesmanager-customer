package com.rodrigofreund.salesmanager.customer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode =
    EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class JacksonConfig {
}
