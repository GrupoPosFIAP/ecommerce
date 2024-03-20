package br.com.fiap.pagamentos.repository.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class LessThanOrEqualsSearchCriteria extends SearchCriteria {

    public LessThanOrEqualsSearchCriteria(String key, Object value) {
        super(key, ">", value);
    }

    @Override
    Predicate build(CriteriaBuilder builder, Predicate predicate, Root<?> root) {
        return builder.and(predicate, builder.lessThanOrEqualTo(root.get(this.getKey()), this.getValue().toString()));
    }

}
