package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.EducationalBackground;
import gapp.model.dao.EducationalBackgroundDao;

@Repository
public class EducationalBackgroundDaoImpl implements EducationalBackgroundDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EducationalBackground getEducationalBackground(Integer id) {
		return entityManager.find(EducationalBackground.class, id);
	}

	@Override
	@Transactional
	public void deleteEducationalBackgroundDao(EducationalBackground educationalBackground) {
		entityManager.remove(educationalBackground);
	}

	@Override
	@Transactional
	public EducationalBackground saveEducationalBackground(EducationalBackground educationalBackground) {
		return entityManager.merge(educationalBackground);
	}

	@Override
	@Transactional
	public void deleteEducationalBackgroundDao(Integer id) {
		entityManager.remove(entityManager.find(EducationalBackground.class, id));
	}
	
	

}
