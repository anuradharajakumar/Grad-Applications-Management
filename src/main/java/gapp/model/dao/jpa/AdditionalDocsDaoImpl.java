package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalDocs;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.AdditionalDocsDao;

@Repository
public class AdditionalDocsDaoImpl implements AdditionalDocsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<AdditionalDocs> getAdditionalDocs() {
		return entityManager.createQuery("from AdditionalDocs order by docId", AdditionalDocs.class).getResultList();
	}

	@Override
	public AdditionalDocs getAdditionalDocs(Integer docId) {
		return entityManager.find(AdditionalDocs.class, docId);
	}

	@Override
	public List<AdditionalDocs> getAdditionalDocs(Department dept) {
		String query = "from AdditionalDocs where dept = :dept";
		List<AdditionalDocs> results = entityManager.createQuery(query, AdditionalDocs.class).setParameter("dept", dept)
				.getResultList();
		return results;
	}

	@Override
	@Transactional
	public void deleteDocument(AdditionalDocs doc) {
		System.out.println("Document id : " + doc.getDocId());
		entityManager.remove(entityManager.find(AdditionalDocs.class, doc.getDocId()));

	}

	@Override
	@Transactional
	public AdditionalDocs saveDocument(AdditionalDocs doc) {
		System.out.println("Save Document");
		return entityManager.merge(doc);
	}
}
