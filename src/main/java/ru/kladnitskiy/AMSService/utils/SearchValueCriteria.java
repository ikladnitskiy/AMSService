package ru.kladnitskiy.AMSService.utils;

public class SearchValueCriteria implements SearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value;

    public SearchValueCriteria(final String key, final SearchOperation operation, final Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
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
        return this.value;
    }

    @Override
    public Object getValue2() {
        throw new UnsupportedOperationException("Method \"getValue2\" SearchValueCriteria.class does not support range search. See SearchRangeValueCriteria.class");
    }
}
