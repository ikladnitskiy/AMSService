package ru.kladnitskiy.AMSService.repository.utils;

import org.springframework.data.jpa.domain.Specification;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс, служащий для построения гибких запросов в БД на основе параметров фильтра.
 * При построении запроса учитываются только те параметры, значение которых не равно null.
 */
public class AmsSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public AmsSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public void fillAmsSpecificationBuilder(String code, Integer number, String cluster, String address, TypeAms typeAms, Double minHeight,
                                            Double maxHeight, String serviceContractor, LocalDate afterServiceDate, LocalDate beforeServiceDate,
                                            String reportContractor, LocalDate afterReportDate, LocalDate beforeReportDate, Boolean isAccess) {

        if (code != null && !code.isEmpty()) this.with("code", SearchOperation.EQUALITY, code);
        if (number != null) this.with("number", SearchOperation.EQUALITY, number);
        if (cluster != null) this.with("cluster", SearchOperation.EQUALITY, cluster);
        if (address != null && !address.isEmpty()) this.with("address", SearchOperation.CONTAINS, address);
        if (typeAms != null) this.with("type", SearchOperation.EQUALITY, typeAms);
        if (minHeight != null) this.with("height", SearchOperation.GREATER_THAN_OR_EQUALS, minHeight);
        if (maxHeight != null) this.with("height", SearchOperation.LESS_THAN_OR_EQUALS, maxHeight);
        if (serviceContractor != null && !serviceContractor.isEmpty())
            this.with("serviceContractor", SearchOperation.EQUALITY, serviceContractor);
        if (afterServiceDate != null) this.with("serviceDate", SearchOperation.AFTER_OR_EQUALS, afterServiceDate);
        if (beforeServiceDate != null) this.with("serviceDate", SearchOperation.BEFORE_OR_EQUALS, beforeServiceDate);
        if (reportContractor != null && !reportContractor.isEmpty())
            this.with("reportContractor", SearchOperation.EQUALITY, reportContractor);
        if (afterReportDate != null)
            this.with("reportDate", SearchOperation.AFTER_OR_EQUALS, afterReportDate);
        if (beforeReportDate != null) this.with("reportDate", SearchOperation.BEFORE_OR_EQUALS, beforeReportDate);
        if (isAccess != null) this.with("isAccess", SearchOperation.EQUALITY, isAccess);
    }

    private AmsSpecificationsBuilder with(String key, SearchOperation operation, Object value) {
        params.add(new SearchValueCriteria(key, operation, value));
        return this;
    }

    private AmsSpecificationsBuilder with(String key, SearchOperation operation, Object value1, Object value2) {
        params.add(new SearchRangeValueCriteria(key, operation, value1, value2));
        return this;
    }

    public Specification<Ams> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification<Ams> result = new AmsSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = Objects.requireNonNull(Specification.where(result)).and(new AmsSpecification(params.get(i)));
        }
        return result;
    }
}
