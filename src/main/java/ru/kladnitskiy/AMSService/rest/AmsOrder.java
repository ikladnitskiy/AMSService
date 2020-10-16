package ru.kladnitskiy.AMSService.rest;

/**
 * Типы используемых сортировок списков АМС.
 */
public enum AmsOrder {
    NUMBER("number"), // default
    HEIGHT("height"),
    SERVICE_DATE("serviceDate"),
    REPORT_DATE("reportDate");

    private String fieldName;

    AmsOrder(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
