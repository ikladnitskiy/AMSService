package ru.kladnitskiy.AMSService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.kladnitskiy.AMSService.exception.BadRequestException;
import ru.kladnitskiy.AMSService.exception.ResourceNotFoundException;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.repository.AmsRepository;
import ru.kladnitskiy.AMSService.repository.utils.AmsSpecificationsBuilder;
import ru.kladnitskiy.AMSService.rest.AmsOrder;

import java.time.LocalDate;
import java.util.List;

/**
 * Реализация интерфейса сервиса АМС.
 */
@Slf4j
@Service
public class AmsServiceImpl implements AmsService {

    private AmsRepository amsRepository;

    @Autowired
    public void setAmsRepository(AmsRepository amsRepository) {
        this.amsRepository = amsRepository;
    }

    /**
     * Метод позволяет получить список АМС, соответствующих переданным параметрам (фильтр).
     *
     * @param order      - параметр сортировки списка
     * @param pageNumber - номер страницы
     * @param pageSize   - количество АМС на странице
     * @return список АМС в количестве pageSize с отступом от начала списка в количестве pageNumber * pageSize элементов.
     */
    @Override
    public List<Ams> getAll(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight,
                            Double maxHeight, String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate,
                            String reportContractor, LocalDate afterReportDate, LocalDate beforeReportDate, Boolean isAccess,
                            AmsOrder order, Integer pageNumber, Integer pageSize) {

        log.info("In AmsServiceImpl method getAll");
        AmsSpecificationsBuilder builder = new AmsSpecificationsBuilder();
        builder.fillAmsSpecificationBuilder(code, number, cluster, address, typeAms, minHeight, maxHeight,
                serviceContractor, afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate, isAccess);
        Specification<Ams> spec = builder.build();
        Page<Ams> page = this.amsRepository.findAll(spec, getPageRequest(pageNumber, pageSize, order.getFieldName()));
        return page.getContent();
    }

    /**
     * Метод возвращает количество АМС, соответствующих заданным параметрам (фильтру).
     */
    @Override
    public long count(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight,
                      Double maxHeight, String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate,
                      String reportContractor, LocalDate afterReportDate, LocalDate beforeReportDate, Boolean isAccess) {

        log.info("In AmsServiceImpl method count");
        AmsSpecificationsBuilder builder = new AmsSpecificationsBuilder();
        builder.fillAmsSpecificationBuilder(code, number, cluster, address, typeAms, minHeight, maxHeight,
                serviceContractor, afterServiceDate, beforeServiceDate, reportContractor, afterReportDate, beforeReportDate, isAccess);
        Specification<Ams> spec = builder.build();
        return this.amsRepository.count(spec);
    }

    /**
     * Метод возвращает сущность АМС по ее ID.
     */
    @Override
    public Ams getById(Integer id) {
        log.info("In AmsServiceImpl method getById, id={}", id);
        return this.amsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("АМС с ID=%s не найдена", id)));
    }

    /**
     * Метод сохраняет сущность АМС в БД.
     *
     * @return сохраненую сущность.
     */
    @Override
    public Ams save(Ams ams) {
        log.info("In AmsServiceImpl method save, {}", ams);
        if (!ams.isValid()) {
            throw new BadRequestException("Дата обслуживания не может быть позже даты отчета");
        }
        if (ams.getTypesOfWork() != null) {
            ams.getTypesOfWork().setAms(ams);
        }
        return this.amsRepository.save(ams);
    }

    /**
     * Метод обновляет сущность АМС, находящуюся в БД по ее ID.
     *
     * @return обновленную сущность.
     */
    @Override
    public Ams update(Integer id, Ams ams) {
        Ams updatedAms = this.amsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("АМС с ID=%s не найдена", id)));
        updateAms(updatedAms, ams);
        if (!updatedAms.isValid()) {
            throw new BadRequestException("Дата обслуживания не может быть позже даты отчета");
        }
        log.info("In AmsServiceImpl method update, id={}, {}", id, ams);
        return this.amsRepository.save(updatedAms);
    }

    /**
     * Метод удаляет сущность АМС в БД по ее ID.
     */
    @Override
    public void delete(Integer id) {
        this.amsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("АМС с ID=%s не найдена", id)));
        log.info("In AmsServiceImpl method delete, id={}", id);
        this.amsRepository.deleteById(id);
    }

    /**
     * Метод возвращает объект для запроса порции данных.
     *
     * @param pageNumber - номер страницы
     * @param pageSize   - количество записей на одной странице
     * @param sort       - параметр сортировки
     */
    private PageRequest getPageRequest(Integer pageNumber, Integer pageSize, String sort) {
        try {
            if (pageSize > 200) {
                throw new IllegalArgumentException("Page size must not be more than 200!");
            }
            return PageRequest.of(pageNumber, pageSize, Sort.by(sort));
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    /**
     * Метод обновляет поля сущности АМС новыми данными. Учитываются только те данные, которые не null.
     */
    private void updateAms(Ams updatedAms, Ams dataAms) {
        if (dataAms.getCode() != null) updatedAms.setCode(dataAms.getCode());
        if (dataAms.getNumber() != null) updatedAms.setNumber(dataAms.getNumber());
        if (dataAms.getCluster() != null) updatedAms.setCluster(dataAms.getCluster());
        if (dataAms.getAddress() != null) updatedAms.setAddress(dataAms.getAddress());
        if (dataAms.getType() != null) updatedAms.setType(dataAms.getType());
        if (dataAms.getHeight() != null) updatedAms.setHeight(dataAms.getHeight());
        if (dataAms.getServiceContractor() != null) updatedAms.setServiceContractor(dataAms.getServiceContractor());
        if (dataAms.getServiceDate() != null) updatedAms.setServiceDate(dataAms.getServiceDate());
        if (dataAms.getReportContractor() != null) updatedAms.setReportContractor(dataAms.getReportContractor());
        if (dataAms.getReportDate() != null) updatedAms.setReportDate(dataAms.getReportDate());
        if (dataAms.getTypesOfWork() != null) updatedAms.setTypesOfWork(dataAms.getTypesOfWork());
        if (dataAms.getIsAccess() != null) updatedAms.setIsAccess(dataAms.getIsAccess());
        updatedAms.getTypesOfWork().setAms(updatedAms);
        updatedAms.getTypesOfWork().setId(updatedAms.getId());
    }
}
