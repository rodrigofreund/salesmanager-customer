package com.rodrigofreund.salesmanager.customer.test.unit;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rodrigofreund.salesmanager.customer.entity.model.CustomerImpl;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerMapper;
import com.rodrigofreund.salesmanager.customer.infra.gateway.CustomerRepositoryImpl;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerJpaRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.CustomerSearchRepository;
import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryTest {

    @Mock
    private CustomerJpaRepository jpaRepository;
    @Mock
    private CustomerSearchRepository searchRepository;
    @Mock
    private CustomerMapper mapper;

    @InjectMocks
    private CustomerRepositoryImpl repository;

    @Test
    void updateTest() {

        var newCustomerData = CustomerImpl.of(1, "John", "John dos Santos", "4342212356470", null);

        var currentEntity = CustomerEntity.builder()
                .id(1)
                .name("Ana")
                .socialName("John dos Santos")
                .finantialNumber("4342212356470")
                .socialNumber("23423")
                .build();

        when(jpaRepository.findById(1)).thenReturn(Optional.of(currentEntity));

        repository.update(newCustomerData);
        
        var expectedCustomer = CustomerEntity.builder()
                .id(1)
                .name("John")
                .socialName("John dos Santos")
                .finantialNumber("4342212356470")
                .socialNumber("23423")
                .build();

        verify(jpaRepository, atLeastOnce()).save(expectedCustomer);
    }

}
