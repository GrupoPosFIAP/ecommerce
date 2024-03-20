package br.com.fiap.pagamentos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.repository.criteria.SearchCriteria;
import br.com.fiap.pagamentos.repository.criteria.SearchCriteriaConsumer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PagamentoDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Pagamento> search(List<SearchCriteria> params) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Pagamento> query = builder.createQuery(Pagamento.class);
        Root<Pagamento> root = query.from(Pagamento.class);

        Predicate predicate = builder.conjunction();

        SearchCriteriaConsumer searchConsumer = new SearchCriteriaConsumer(predicate, builder, root);
        
        params.stream().forEach(searchConsumer);
        predicate = searchConsumer.getPredicate();
        query.where(predicate);

        return em.createQuery(query).getResultList();
    }
}
