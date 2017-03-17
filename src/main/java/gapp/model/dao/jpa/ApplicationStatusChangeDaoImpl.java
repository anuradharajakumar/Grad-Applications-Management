package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.ApplicationStatusChange;
import gapp.model.EducationalBackground;
import gapp.model.User;
import gapp.model.dao.ApplicationStatusChangeDao;

@Repository
public class ApplicationStatusChangeDaoImpl implements ApplicationStatusChangeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ApplicationStatusChange> getApplicationStatusChange() {
		List<ApplicationStatusChange> applicationStatusChanges = entityManager
				.createQuery("from ApplicationStatusChange order by applicationStatusChangeId",
						ApplicationStatusChange.class)
				.getResultList();
		return applicationStatusChanges;
	}

	@Override
	public List<ApplicationStatusChange> getApplicationStatusChanges(Application application) {
		List<ApplicationStatusChange> applicationStatusChanges = entityManager.createQuery(
				"from ApplicationStatusChange where application=:application order by applicationStatusChangeId",
				ApplicationStatusChange.class).setParameter("application", application).getResultList();
		return applicationStatusChanges;
	}

	@Override
	@Transactional
	public ApplicationStatusChange saveApplicationStatusChange(ApplicationStatusChange applicationStatusChange) {
		return entityManager.merge(applicationStatusChange);
	}

	@Override
	public ApplicationStatusChange getLatestApplicationStatusChange(Application application) {
		List<ApplicationStatusChange> applicationStatusChanges = entityManager
				.createQuery("from ApplicationStatusChange where application=:application order by changedTime desc",
						ApplicationStatusChange.class)
				.setParameter("application", application).getResultList();
		return applicationStatusChanges.get(0);
	}

	@Override
	public ApplicationStatusChange getLatestApplicationStatus(Integer Id) {
		return entityManager.find(ApplicationStatusChange.class, Id);
	}

}
