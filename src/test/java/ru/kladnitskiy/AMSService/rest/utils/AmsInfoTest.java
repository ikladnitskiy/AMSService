package ru.kladnitskiy.AMSService.rest.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import ru.kladnitskiy.AMSService.model.TypeAms;

import java.time.LocalDate;
import java.util.Objects;

public class AmsInfoTest {

    public Integer id;
    public String code;
    public Integer number;
    public String cluster;
    public String address;
    public TypeAms type;
    public Double height;
    public String serviceContractor;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate serviceDate;
    public String reportContractor;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate reportDate;
    public Boolean accessStatus;
    public TypesOfWorkInfoTest typesOfWork;

    public AmsInfoTest() {

    }

    public AmsInfoTest(Integer id, String code, Integer number, String cluster, String address, TypeAms type, Double height,
                       String serviceContractor, LocalDate serviceDate, String reportContractor, LocalDate reportDate, Boolean accessStatus, TypesOfWorkInfoTest typesOfWork) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.cluster = cluster;
        this.address = address;
        this.type = type;
        this.height = height;
        this.serviceContractor = serviceContractor;
        this.serviceDate = serviceDate;
        this.reportContractor = reportContractor;
        this.reportDate = reportDate;
        this.accessStatus = accessStatus;
        this.typesOfWork = typesOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmsInfoTest)) return false;

        AmsInfoTest that = (AmsInfoTest) o;

        if (!id.equals(that.id)) return false;
        if (!code.equals(that.code)) return false;
        if (!number.equals(that.number)) return false;
        if (!cluster.equals(that.cluster)) return false;
        if (!address.equals(that.address)) return false;
        if (type != that.type) return false;
        if (!height.equals(that.height)) return false;
        if (!serviceContractor.equals(that.serviceContractor)) return false;
        if (!serviceDate.equals(that.serviceDate)) return false;
        if (!reportContractor.equals(that.reportContractor)) return false;
        if (!reportDate.equals(that.reportDate)) return false;
        if (!accessStatus.equals(that.accessStatus)) return false;
        return typesOfWork.equals(that.typesOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, number, cluster, address, type, height, serviceContractor, serviceDate, reportContractor, reportDate, accessStatus, typesOfWork);
    }
}
