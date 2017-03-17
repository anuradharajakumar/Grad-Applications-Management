package gapp.model.dao;

import java.util.List;

import gapp.model.Term;

public interface TermDao {

	Term getTerm(String term, Integer year);

	List<Term> getTerms();
	
	Term getTerm(Integer termId);

}
