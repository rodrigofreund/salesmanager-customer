package com.rodrigofreund.salesmanager.customer.infra.persistency;

import java.util.List;

import com.rodrigofreund.salesmanager.customer.application.dto.SearchCriteria;
import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;

public interface CustomerSearchRepository {

    public List<CustomerEntity> findByCriteria(final List<SearchCriteria> params);

}
