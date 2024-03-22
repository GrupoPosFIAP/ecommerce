package br.com.fiap.pagamentos.repository.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EqualsSearchCriteria extends SearchCriteria {

    public EqualsSearchCriteria(String key, Object value) {
        super(key, ":", value);
    }

    @Override
    public Predicate build(CriteriaBuilder builder, Predicate predicate, Root<?> root) {
        return builder.and(predicate, builder.equal(root.get(this.getKey()), this.getValue()));
    }

}
