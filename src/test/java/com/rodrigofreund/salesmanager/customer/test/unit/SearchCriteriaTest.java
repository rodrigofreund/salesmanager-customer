package com.rodrigofreund.salesmanager.customer.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rodrigofreund.salesmanager.customer.application.dto.SearchCriteria;

public class SearchCriteriaTest {

    @Test
    void creatingWithNullCriteria() {
        var criteriaList = SearchCriteria.from(null);
        assertEquals(0, criteriaList.size());
    }

    @Test
    void creatingWithEmptyCriteria() {
        var criteriaList = SearchCriteria.from("");
        assertEquals(0, criteriaList.size());
    }

    @Test
    void creatingWithOneParameterWithoutWildcard() {
        var criteriaList = SearchCriteria.from("name:Rodrigo");
        assertEquals(1, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("Rodrigo", criteriaList.get(0).value());
    }

    @Test
    void creatingWithOneParameterWithStartWildcard() {
        var criteriaList = SearchCriteria.from("name:%Rodrigo");
        assertEquals(1, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("%Rodrigo", criteriaList.get(0).value());
    }

    @Test
    void creatingWithOneParameterWithEndWildcard() {
        var criteriaList = SearchCriteria.from("name:Rodrigo%");
        assertEquals(1, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("Rodrigo%", criteriaList.get(0).value());
    }

    @Test
    void creatingWithOneParameterWithStartWildcar() {
        var criteriaList = SearchCriteria.from("name:%Rodrigo");
        assertEquals(1, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("%Rodrigo", criteriaList.get(0).value());
    }

    @Test
    void creatingWithTwoParameterWithoutWildcard() {
        var criteriaList = SearchCriteria.from("name:Rodrigo,surname:Moraes");
        assertEquals(2, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("Rodrigo", criteriaList.get(0).value());
        assertEquals("surname", criteriaList.get(1).key());
        assertEquals(":", criteriaList.get(1).operation());
        assertEquals("Moraes", criteriaList.get(1).value());
    }

    @Test
    void creatingWithThreeParameterWithWildcardGtOperation() {
        var criteriaList = SearchCriteria.from("name:%Rodrigo%,surname:Moraes%,age>12");
        assertEquals(3, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("%Rodrigo%", criteriaList.get(0).value());
        assertEquals("surname", criteriaList.get(1).key());
        assertEquals(":", criteriaList.get(1).operation());
        assertEquals("Moraes%", criteriaList.get(1).value());
        assertEquals("age", criteriaList.get(2).key());
        assertEquals(">", criteriaList.get(2).operation());
        assertEquals("12", criteriaList.get(2).value());
    }

    @Test
    void creatingWithThreeParameterWithWildcardLtOperation() {
        var criteriaList = SearchCriteria.from("name:%Rodrigo%,surname:Moraes%,age<12");
        assertEquals(3, criteriaList.size());
        assertEquals("name", criteriaList.get(0).key());
        assertEquals(":", criteriaList.get(0).operation());
        assertEquals("%Rodrigo%", criteriaList.get(0).value());
        assertEquals("surname", criteriaList.get(1).key());
        assertEquals(":", criteriaList.get(1).operation());
        assertEquals("Moraes%", criteriaList.get(1).value());
        assertEquals("age", criteriaList.get(2).key());
        assertEquals("<", criteriaList.get(2).operation());
        assertEquals("12", criteriaList.get(2).value());
    }
}
