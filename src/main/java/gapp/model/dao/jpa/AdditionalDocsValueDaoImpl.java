package gapp.model.dao.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.AdditionalDocs;
import gapp.model.AdditionalDocsValue;
import gapp.model.Application;
import gapp.model.dao.AdditionalDocsValueDao;

@Repository
public class AdditionalDocsValueDaoImpl implements AdditionalDocsValueDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Map<AdditionalDocs, AdditionalDocsValue> additionalDoc_Values(List<AdditionalDocs> docs,
			Application application) {

		Map<AdditionalDocs, AdditionalDocsValue> documents = new HashMap<AdditionalDocs, AdditionalDocsValue>();
		for (AdditionalDocs doc : docs) {

			List<AdditionalDocsValue> value = entityManager
					.createQuery("from AdditionalDocsValue where additionalDoc=:doc and application=:application",
							AdditionalDocsValue.class)
					.setParameter("doc", doc).setParameter("application", application).getResultList();
			documents.put(doc, value.get(0));

		}

		return documents;
	}

}
