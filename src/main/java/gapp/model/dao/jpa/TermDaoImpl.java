package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.AdditionalDocs;
import gapp.model.Department;
import gapp.model.Term;
import gapp.model.dao.TermDao;


@Repository
public class TermDaoImpl implements TermDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Term getTerm(String term, Integer year) {
		System.out.println("get term");
		String query = "from Term t WHERE t.term = :term and t.year = :year";
		Term Terms = entityManager.createQuery(query, Term.class).setParameter("term", term).setParameter("year", year).getResultList().get(0);

		System.out.println(Terms.getTermId());
		return Terms;

	}

	@Override
	public List<Term> getTerms() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Term order by termId", Term.class).getResultList();
	}

	@Override
	public Term getTerm(Integer termId) {
		// TODO Auto-generated method stub
		return entityManager.find(Term.class, termId);
	}

	
}
