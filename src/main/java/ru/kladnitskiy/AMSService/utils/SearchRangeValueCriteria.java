package ru.kladnitskiy.AMSService.utils;

public class SearchRangeValueCriteria implements SearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value1;
    private Object value2;

    public SearchRangeValueCriteria(final String key, final SearchOperation operation, final Object value1, final Object value2) {
        this.key = key;
        this.operation = operation;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public SearchOperation getOperation() {
        return this.operation;
    }

    @Override
    public Object getValue1() {
        return this.value1;
    }

    @Override
    public Object getValue2() {
        return this.value2;
    }
}
