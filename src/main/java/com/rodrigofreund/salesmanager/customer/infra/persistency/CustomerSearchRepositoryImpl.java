package com.rodrigofreund.salesmanager.customer.infra.persistency;

import java.util.List;

import com.rodrigofreund.salesmanager.customer.application.dto.SearchCriteria;
import com.rodrigofreund.salesmanager.customer.infra.persistency.entity.CustomerEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomerSearchRepositoryImpl implements CustomerSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> findByCriteria(List<SearchCriteria> params) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<CustomerEntity> criteriaQuery = builder.createQuery(CustomerEntity.class);

        Root<CustomerEntity> from = criteriaQuery.from(CustomerEntity.class);

        Predicate predicate = builder.conjunction();

        SearchCriteriaToPredicateConsumer<CustomerEntity> searchConsumer = 
                new SearchCriteriaToPredicateConsumer<>(builder, predicate, from);
        params.stream().forEach(searchConsumer);

        criteriaQuery.where(searchConsumer.predicate());

        var query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
