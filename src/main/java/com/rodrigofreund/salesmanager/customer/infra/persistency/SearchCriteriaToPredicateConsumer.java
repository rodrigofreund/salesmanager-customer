package com.rodrigofreund.salesmanager.customer.infra.persistency;

import java.util.function.Consumer;

import com.rodrigofreund.salesmanager.customer.application.dto.SearchCriteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * It generates Predicate from SearchCriteria instance
 * 
 */
public class SearchCriteriaToPredicateConsumer<T> implements Consumer<SearchCriteria> {

    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root<T> from;

    public SearchCriteriaToPredicateConsumer(CriteriaBuilder builder, Predicate predicate, Root<T> from) {
        super();
        this.builder = builder;
        this.from = from;
        this.predicate = predicate;
    }

    @Override
    public void accept(SearchCriteria searchCriteria) {

        var key = searchCriteria.key();
        var value = searchCriteria.value();
        var operation = searchCriteria.operation();

        switch(operation) {
            case ">":
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(from.get(key), value.toString()));
                break;
            case "<":
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(from.get(key), value.toString()));
                break;
            case ":": {
                    if (isStringField(key)) {
                        predicate = builder.and(predicate, builder.like(
                          from.get(key), "%" + value + "%"));
                    } else {
                        predicate = builder.and(predicate, builder.equal(
                          from.get(key), value));
                    }
                    break;
                }
            default:
                throw new IllegalArgumentException(
                        String.format("%s is not a valid search criteria operator.", operation));
        }
    }

    public Predicate predicate () {
        return this.predicate;
    }

    private boolean isStringField(String key) {
        return from.get(key).getJavaType() == String.class;
    }
}
