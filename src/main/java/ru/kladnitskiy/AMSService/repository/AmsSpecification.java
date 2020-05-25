package ru.kladnitskiy.AMSService.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.utils.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class AmsSpecification implements Specification<Ams> {

    private SearchCriteria criteria;

    public AmsSpecification(final SearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Ams> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        switch (criteria.getOperation()) {
            case EQUALITY:
                return builder.equal(root.get(criteria.getKey()), criteria.getValue1());
            case GREATER_THAN:
                return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), Double.valueOf(criteria.getValue1().toString()));
            case LESS_THAN:
                return builder.lessThanOrEqualTo(root.get(criteria.getKey()), Double.valueOf(criteria.getValue1().toString()));
            case BETWEEN:
                return builder.between(root.get(criteria.getKey()), Double.valueOf(criteria.getValue1().toString()), Double.valueOf(criteria.getValue2().toString()));
            case AFTER:
                return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), (LocalDate) criteria.getValue1());
            case BEFORE:
                return builder.lessThanOrEqualTo(root.get(criteria.getKey()), (LocalDate) criteria.getValue1());
            case DATE_BETWEEN:
                return builder.between(root.get(criteria.getKey()), (LocalDate) criteria.getValue1(), (LocalDate) criteria.getValue2());
            case CONTAINS:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue1() + "%");
            default:
                return null;
        }
    }
}