package com.rodrigofreund.salesmanager.customer.application.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record SearchCriteria(
        String key, //Field name
        String operation,//Operation
        Object value) {//Search value

    /**
     * query pattern
     * equals = fieldName:value
     * lessThenOrEquals = fieldName<value
     * gratherThenOrEquals = fieldName>value
     * field separator = ,
     * 
     * Example: name:Rodrigo%,surname:%Moraes
     */
    private static final String CRITERIA_PATTERN = "(\\w+?)(:|<|>)([%]*\\w+?[%]*),";

    /** It converts from criteria string language to list of SearchCriteria objects
     * the language is composed by <fieldName><operation><fieldValue>
     * operations
     * : - equal
     * < - less then or equals
     * > - greater then or equals
     * 
     * @param criteria
     * @return SerchCriteria list
     */
    public static List<SearchCriteria> from(String criteria) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (criteria != null) {
            Pattern pattern = Pattern.compile(CRITERIA_PATTERN);
            Matcher matcher = pattern.matcher(criteria + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), 
                  matcher.group(2), matcher.group(3)));
            }
        }
        return params;
    }
}
