package ru.kladnitskiy.AMSService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.kladnitskiy.AMSService.exception.ResourceNotFoundException;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.repository.AmsRepository;
import ru.kladnitskiy.AMSService.repository.AmsSpecificationsBuilder;
import ru.kladnitskiy.AMSService.rest.AmsOrder;

import java.time.LocalDate;
import java.util.List;

import static ru.kladnitskiy.AMSService.service.AmsServiceUtils.*;

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
                new ResourceNotFoundException(String.format("entity with ID=%s", id), "getById"));
    }

    /**
     * Метод сохраняет сущность АМС в БД.
     *
     * @return сохраненую сущность.
     */
    @Override
    public Ams save(Ams ams) {
        log.info("In AmsServiceImpl method save, {}", ams);
        ams.getTypesOfWork().setAms(ams);
        if (isValidAms(ams)) {
            return this.amsRepository.save(ams);
        } else {
            return null;
        }
    }

    /**
     * Метод обновляет сущность АМС, находящуюся в БД по ее ID.
     *
     * @return обновленную сущность.
     */
    @Override
    public Ams update(Integer id, Ams ams) {
        Ams updatedAms = this.amsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("entity with ID=%s", id), "update"));
        updateAms(updatedAms, ams);
        log.info("In AmsServiceImpl method update, id={}, {}", id, ams);
        return this.amsRepository.save(updatedAms);
    }

    /**
     * Метод удаляет сущность АМС в БД по ее ID.
     */
    @Override
    public void delete(Integer id) {
        this.amsRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("entity with ID=%s", id), "delete"));
        log.info("In AmsServiceImpl method delete, id={}", id);
        this.amsRepository.deleteById(id);
    }
}
