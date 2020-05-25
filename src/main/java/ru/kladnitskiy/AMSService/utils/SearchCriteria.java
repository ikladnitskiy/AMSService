package ru.kladnitskiy.AMSService.utils;

public interface SearchCriteria {
    String getKey();

    SearchOperation getOperation();

    Object getValue1();

    Object getValue2();
}
