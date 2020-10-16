package ru.kladnitskiy.AMSService.repository.utils;

public interface SearchCriteria {
    String getKey();

    SearchOperation getOperation();

    Object getValue1();

    Object getValue2();
}
