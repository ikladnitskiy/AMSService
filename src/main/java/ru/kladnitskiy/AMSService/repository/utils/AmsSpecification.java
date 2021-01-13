package ru.kladnitskiy.AMSService.repository.utils;

import org.springframework.data.jpa.domain.Specification;
import ru.kladnitskiy.AMSService.model.Ams;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

/**
 * Класс спецификации АМС, служащий для построения гибких запросов в БД.
 *
 * @see AmsSpecificationsBuilder
 */
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
            case GREATER_THAN_OR_EQUALS:
                return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), Double.valueOf(criteria.getValue1().toString()));
            case LESS_THAN_OR_EQUALS:
                return builder.lessThanOrEqualTo(root.get(criteria.getKey()), Double.valueOf(criteria.getValue1().toString()));
            case AFTER_OR_EQUALS:
                return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), (LocalDate) criteria.getValue1());
            case BEFORE_OR_EQUALS:
                return builder.lessThanOrEqualTo(root.get(criteria.getKey()), (LocalDate) criteria.getValue1());
            case CONTAINS:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue1() + "%");
            default:
                return null;
        }
    }
}