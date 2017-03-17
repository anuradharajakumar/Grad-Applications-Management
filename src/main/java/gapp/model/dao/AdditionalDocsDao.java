package gapp.model.dao;

import java.util.List;

import gapp.model.AdditionalDocs;
import gapp.model.Department;
import gapp.model.Program;

public interface AdditionalDocsDao {

	public List<AdditionalDocs> getAdditionalDocs();
	public AdditionalDocs getAdditionalDocs(Integer docId);
	List<AdditionalDocs> getAdditionalDocs(Department dept);
	void deleteDocument(AdditionalDocs doc);
	AdditionalDocs saveDocument( AdditionalDocs doc );
}
