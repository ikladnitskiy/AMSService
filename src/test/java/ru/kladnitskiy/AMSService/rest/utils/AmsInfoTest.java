package ru.kladnitskiy.AMSService.rest.utils;

import ru.kladnitskiy.AMSService.model.TypeAms;

import java.util.Objects;

public class AmsInfoTest {

    public Integer id;
    public String code;
    public Integer number;
    public String address;
    public TypeAms type;
    public Double height;
    public boolean serviced;
    public TypesOfWorkInfoTest typesOfWork;

    public AmsInfoTest() {

    }

    public AmsInfoTest(Integer id, String code, Integer number, String address, TypeAms type,
                       Double height, boolean serviced, TypesOfWorkInfoTest typesOfWork) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.address = address;
        this.type = type;
        this.height = height;
        this.serviced = serviced;
        this.typesOfWork = typesOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmsInfoTest)) return false;

        AmsInfoTest that = (AmsInfoTest) o;

        if (serviced != that.serviced) return false;
        if (!id.equals(that.id)) return false;
        if (!code.equals(that.code)) return false;
        if (!number.equals(that.number)) return false;
        if (!address.equals(that.address)) return false;
        if (type != that.type) return false;
        if (!height.equals(that.height)) return false;
        return typesOfWork.equals(that.typesOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, number, address, type, height, serviced, typesOfWork);
    }
}
