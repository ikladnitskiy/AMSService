package ru.kladnitskiy.AMSService.rest.utils;

import java.util.Objects;

public class TypesOfWorkInfoTest {

    public Integer id;
    public Boolean first;
    public Boolean second;
    public Boolean third;
    public Boolean fourth;
    public Boolean fifth;

    public TypesOfWorkInfoTest() {
    }

    public TypesOfWorkInfoTest(boolean first, boolean second, boolean third, boolean fourth, boolean fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public TypesOfWorkInfoTest(int id, boolean first, boolean second, boolean third, boolean fourth, boolean fifth) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypesOfWorkInfoTest)) return false;

        TypesOfWorkInfoTest that = (TypesOfWorkInfoTest) o;

        if (!first.equals(that.first)) return false;
        if (!second.equals(that.second)) return false;
        if (!third.equals(that.third)) return false;
        if (!fourth.equals(that.fourth)) return false;
        return fifth.equals(that.fifth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth, fifth);
    }
}
