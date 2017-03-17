package gapp.model.dao;

import java.util.List;
import java.util.Map;

import gapp.model.AdditionalDocs;
import gapp.model.AdditionalDocsValue;
import gapp.model.Application;

public interface AdditionalDocsValueDao {

	Map<AdditionalDocs, AdditionalDocsValue> additionalDoc_Values(List<AdditionalDocs> docs, Application application);

}
