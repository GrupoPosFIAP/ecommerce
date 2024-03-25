package br.com.fiap.produtos.repository.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public abstract class SearchCriteria {
    String key;
    String operation;
    Object value;

    abstract Predicate build(CriteriaBuilder builder, Predicate predicate, Root<?> root);

    public static List<SearchCriteria> builder(String search) {
        List<SearchCriteria> params = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?)");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            var key = matcher.group(0);
            var operation = matcher.group(1);
            var value = matcher.group(2);

            if (":".equals(operation)) {
                params.add(new EqualsSearchCriteria(key, value));
            }

            if (">".equals(operation)) {
                params.add(new GreaterThanOrEqualsSearchCriteria(key, value));
            }

            if ("<".equals(operation)) {
                params.add(new LessThanOrEqualsSearchCriteria(key, value));
            }
        }

        return params;
    }
}
