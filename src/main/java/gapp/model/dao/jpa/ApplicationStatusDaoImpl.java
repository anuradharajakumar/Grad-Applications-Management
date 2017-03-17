package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.dao.ApplicationStatusDao;

@Repository
public class ApplicationStatusDaoImpl implements ApplicationStatusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ApplicationStatus getApplicationStatus(Integer id) {
		return entityManager.find(ApplicationStatus.class, id);
	}

}
