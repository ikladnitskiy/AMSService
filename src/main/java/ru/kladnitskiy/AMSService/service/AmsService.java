package ru.kladnitskiy.AMSService.service;

import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.rest.AmsOrder;

import java.time.LocalDate;
import java.util.List;

public interface AmsService {

    List<Ams> getAll(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight, Double maxHeight,
                     String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate, String reportContractor,
                     LocalDate afterReportDate, LocalDate beforeReportDate, AmsOrder order, Integer pageNumber, Integer pageSize);

    long count(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight, Double maxHeight,
               String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate, String reportContractor,
               LocalDate afterReportDate, LocalDate beforeReportDate);

    Ams getById(Integer id);

    Ams save(Ams ams);

    Ams update(Integer id, Ams ams);

    void delete(Integer id);
}
