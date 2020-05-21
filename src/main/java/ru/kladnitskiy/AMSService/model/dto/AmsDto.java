package ru.kladnitskiy.AMSService.model.dto;

import lombok.Data;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.model.TypesOfWork;

import java.time.LocalDate;

@Data
public class AmsDto extends AbstractAmsDto {

    private final TypesOfWork typesOfWork;

    public AmsDto(Integer id, String code, Integer number, String cluster, String address, TypeAms type, Double height,
                  String serviceContractor, LocalDate serviceDate, String reportContractor, LocalDate reportDate, TypesOfWork typesOfWork) {
        super(id, code, number, cluster, address, type, height, serviceContractor, serviceDate, reportContractor, reportDate);
        this.typesOfWork = typesOfWork;
    }

    public static AmsDto convertToAmsDto(Ams ams) {
        return new AmsDto(ams.getId(), ams.getCode(), ams.getNumber(), ams.getCluster(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.getServiceContractor(), ams.getServiceDate(), ams.getReportContractor(), ams.getReportDate(), ams.getTypesOfWork());
    }
}
