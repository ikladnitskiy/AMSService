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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeAms getType() {
        return type;
    }

    public void setType(TypeAms type) {
        this.type = type;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getServiceContractor() {
        return serviceContractor;
    }

    public void setServiceContractor(String serviceContractor) {
        this.serviceContractor = serviceContractor;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getReportContractor() {
        return reportContractor;
    }

    public void setReportContractor(String reportContractor) {
        this.reportContractor = reportContractor;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Boolean getAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(Boolean accessStatus) {
        this.accessStatus = accessStatus;
    }

    public TypesOfWorkInfoTest getTypesOfWork() {
        return typesOfWork;
    }

    public void setTypesOfWork(TypesOfWorkInfoTest typesOfWork) {
        this.typesOfWork = typesOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AmsInfoTest)) return false;
        AmsInfoTest that = (AmsInfoTest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(number, that.number) &&
                Objects.equals(cluster, that.cluster) &&
                Objects.equals(address, that.address) &&
                type == that.type &&
                Objects.equals(height, that.height) &&
                Objects.equals(serviceContractor, that.serviceContractor) &&
                Objects.equals(serviceDate, that.serviceDate) &&
                Objects.equals(reportContractor, that.reportContractor) &&
                Objects.equals(accessStatus, that.accessStatus) &&
                Objects.equals(typesOfWork, that.typesOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, number, cluster, address, type, height, serviceContractor, serviceDate, reportContractor, reportDate, accessStatus, typesOfWork);
    }

    @Override
    public String toString() {
        return "AmsInfoTest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", number=" + number +
                ", cluster='" + cluster + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", height=" + height +
                ", serviceContractor='" + serviceContractor + '\'' +
                ", serviceDate=" + serviceDate +
                ", reportContractor='" + reportContractor + '\'' +
                ", reportDate=" + reportDate +
                ", accessStatus=" + accessStatus +
                ", typesOfWork=" + typesOfWork +
                '}';
    }
}
