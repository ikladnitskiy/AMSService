package ru.kladnitskiy.AMSService.rest.utils;

import java.util.Objects;

public class TypesOfWorkInfoTest {

    public Integer id;
    public Boolean first1;
    public Boolean first1A;
    public Boolean second;
    public Boolean third;
    public Boolean fourth;
    public Boolean fifth;
    public Boolean sixth;
    public Boolean seventh;
    public Boolean eighth1;
    public Boolean eighth2;
    public Boolean eighth3;
    public Boolean eighth4;
    public Boolean eighth5;
    public Boolean eighth6;
    public Boolean eighth7;

    public TypesOfWorkInfoTest() {
    }

    public TypesOfWorkInfoTest(Integer id, boolean first1, boolean first1A, boolean second, boolean third, boolean fourth, boolean fifth,
                               boolean sixth, boolean seventh, boolean eighth1, boolean eighth2, boolean eighth3,
                               boolean eighth4, boolean eighth5, boolean eighth6, boolean eighth7) {
        this.id = id;
        this.first1 = first1;
        this.first1A = first1A;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth1 = eighth1;
        this.eighth2 = eighth2;
        this.eighth3 = eighth3;
        this.eighth4 = eighth4;
        this.eighth5 = eighth5;
        this.eighth6 = eighth6;
        this.eighth7 = eighth7;
    }

    public TypesOfWorkInfoTest(boolean first1, boolean first1A, boolean second, boolean third, boolean fourth, boolean fifth,
                               boolean sixth, boolean seventh, boolean eighth1, boolean eighth2, boolean eighth3,
                               boolean eighth4, boolean eighth5, boolean eighth6, boolean eighth7) {
        this.first1 = first1;
        this.first1A = first1A;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth1 = eighth1;
        this.eighth2 = eighth2;
        this.eighth3 = eighth3;
        this.eighth4 = eighth4;
        this.eighth5 = eighth5;
        this.eighth6 = eighth6;
        this.eighth7 = eighth7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypesOfWorkInfoTest)) return false;

        TypesOfWorkInfoTest that = (TypesOfWorkInfoTest) o;

        if (!first1.equals(that.first1)) return false;
        if (!first1A.equals(that.first1A)) return false;
        if (!second.equals(that.second)) return false;
        if (!third.equals(that.third)) return false;
        if (!fourth.equals(that.fourth)) return false;
        if (!fifth.equals(that.fifth)) return false;
        if (!sixth.equals(that.sixth)) return false;
        if (!seventh.equals(that.seventh)) return false;
        if (!eighth1.equals(that.eighth1)) return false;
        if (!eighth2.equals(that.eighth2)) return false;
        if (!eighth3.equals(that.eighth3)) return false;
        if (!eighth4.equals(that.eighth4)) return false;
        if (!eighth5.equals(that.eighth5)) return false;
        if (!eighth6.equals(that.eighth6)) return false;
        return eighth7.equals(that.eighth7);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first1, first1A, second, third, fourth, fifth, sixth, seventh,
                eighth1, eighth2, eighth3, eighth4, eighth5, eighth6, eighth7);
    }
}
