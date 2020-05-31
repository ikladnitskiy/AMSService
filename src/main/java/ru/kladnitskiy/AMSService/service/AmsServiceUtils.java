package ru.kladnitskiy.AMSService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.kladnitskiy.AMSService.exception.BadRequestException;
import ru.kladnitskiy.AMSService.model.Ams;

@Slf4j
public class AmsServiceUtils {

    public static PageRequest getPageRequest(Integer pageNumber, Integer pageSize, String sort) {
        try {
            return PageRequest.of(pageNumber, pageSize, Sort.by(sort));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException(ex.getMessage(), "getPageRequest");
        }
    }

    public static boolean validateAms(Ams ams) {
        if (ams.getServiceDate() != null && ams.getReportDate() != null) {
            if (ams.getServiceDate().isAfter(ams.getReportDate()))
                throw new BadRequestException("service date must not be later than the report date", "validateAms");
        }
        return ams.getReportDate() == null;
    }

    public static void updateAms(Ams updatedAms, Ams newAms) {
        if (validateAms(newAms)) {
            updatedAms.setCode(newAms.getCode());
            updatedAms.setNumber(newAms.getNumber());
            updatedAms.setCluster(newAms.getCluster());
            updatedAms.setAddress(newAms.getAddress());
            updatedAms.setType(newAms.getType());
            updatedAms.setHeight(newAms.getHeight());
            updatedAms.setServiceContractor(newAms.getServiceContractor());
            updatedAms.setServiceDate(newAms.getServiceDate());
            updatedAms.setReportContractor(newAms.getReportContractor());
            updatedAms.setReportDate(newAms.getReportDate());
            updatedAms.setTypesOfWork(newAms.getTypesOfWork());
            updatedAms.getTypesOfWork().setAms(updatedAms);
            updatedAms.getTypesOfWork().setId(updatedAms.getId());
        }
    }
}
