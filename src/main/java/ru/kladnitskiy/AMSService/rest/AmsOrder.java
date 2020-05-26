package ru.kladnitskiy.AMSService.rest;

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
