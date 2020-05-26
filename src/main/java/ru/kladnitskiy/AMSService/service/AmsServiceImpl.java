package ru.kladnitskiy.AMSService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.repository.AmsRepository;
import ru.kladnitskiy.AMSService.repository.AmsSpecificationsBuilder;
import ru.kladnitskiy.AMSService.rest.AmsOrder;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class AmsServiceImpl implements AmsService {

    private AmsRepository amsRepository;

    @Autowired
    public void setAmsRepository(AmsRepository amsRepository) {
        this.amsRepository = amsRepository;
    }

    @Override
    public List<Ams> getAll(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight,
                            Double maxHeight, String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate,
                            String reportContractor, LocalDate afterReportDate, LocalDate beforeReportDate,
                            AmsOrder order, Integer pageNumber, Integer pageSize) {

        log.info("In AmsServiceImpl method getAll");
        AmsSpecificationsBuilder builder = new AmsSpecificationsBuilder();
        builder.fillAmsSpecificationBuilder(code, number, cluster, address, typeAms, minHeight, maxHeight,
                serviceContractor, afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate);
        Specification<Ams> spec = builder.build();
        Page<Ams> page = this.amsRepository.findAll(spec, PageRequest.of(pageNumber, pageSize, Sort.by(order.getFieldName())));
        return page.getContent();
    }

    @Override
    public long count(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight,
                      Double maxHeight, String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate,
                      String reportContractor, LocalDate afterReportDate, LocalDate beforeReportDate) {

        log.info("In AmsServiceImpl method count");
        AmsSpecificationsBuilder builder = new AmsSpecificationsBuilder();
        builder.fillAmsSpecificationBuilder(code, number, cluster, address, typeAms, minHeight, maxHeight,
                serviceContractor, afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate);
        Specification<Ams> spec = builder.build();
        return this.amsRepository.count(spec);
    }

    @Override
    public Ams getById(Integer id) {
        log.info("In AmsServiceImpl method getById, id={}", id);
        return this.amsRepository.findById(id).orElse(null);
    }

    @Override
    public Ams save(Ams ams) {
        log.info("In AmsServiceImpl method save, {}", ams);
        return this.amsRepository.save(ams);
    }

    @Override
    public Ams update(Integer id, Ams ams) {
        log.info("In AmsServiceImpl method update, id={}, {}", id, ams);
        Ams updatedAms = this.amsRepository.findById(id).orElse(null);
        updatedAms.setCode(ams.getCode());
        updatedAms.setNumber(ams.getNumber());
        updatedAms.setCluster(ams.getCluster());
        updatedAms.setAddress(ams.getAddress());
        updatedAms.setType(ams.getType());
        updatedAms.setHeight(ams.getHeight());
        updatedAms.setServiceContractor(ams.getServiceContractor());
        updatedAms.setServiceDate(ams.getServiceDate());
        updatedAms.setReportContractor(ams.getReportContractor());
        updatedAms.setReportDate(ams.getReportDate());
        updatedAms.setTypesOfWork(ams.getTypesOfWork());
        updatedAms.getTypesOfWork().setAms(updatedAms);
        updatedAms.getTypesOfWork().setId(id);
        return this.amsRepository.save(updatedAms);
    }

    @Override
    public void delete(Integer id) {
        log.info("In AmsServiceImpl method delete, id={}", id);
        this.amsRepository.deleteById(id);
    }
}
