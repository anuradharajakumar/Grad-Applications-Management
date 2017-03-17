package gapp.model.dao.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalDocs;
import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.ApplicationStatusChange;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.Term;
import gapp.model.User;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.ApplicationStatusChangeDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.TermDao;
import gapp.model.dao.UserDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ApplicationStatusChangeDao applicationStatusChangeDao;

	@Autowired
	private TermDao termDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Application getApplication(Integer applicationId) {
		return entityManager.find(Application.class, applicationId);
	}

	@Override
	public List<Application> getApplication() {
		return entityManager.createQuery("from Application order by applicationId", Application.class).getResultList();
	}

	@Override
	public List<Application> getApplication(String deptName, String term, Integer year) {

		List<Application> applications = entityManager
				.createQuery(
						"Select a from Application a , Department d, Term t where a.dept = d and d.deptName = :deptName and t.term= :term and t.year= :year",
						Application.class)
				.setParameter("deptName", deptName).setParameter("term", term).setParameter("year", year)
				.getResultList();

		return applications;
	}

	@Override
	public List<Application> getApplication(String studentName, String emailid) {

		List<Application> applications = entityManager
				.createQuery(
						"Select a from Application a , User u where a.user = u and u.email = :email and u.firstName = :name",
						Application.class)
				.setParameter("email", emailid).setParameter("name", studentName).getResultList();

		return applications;

	}

	@Override
	public List<Application> getApplications_user(User user) {

		List<Application> applications = entityManager.createQuery("from Application where user =:u", Application.class)
				.setParameter("u", user).getResultList();

		return applications;

	}

	@Override
	public Map<Application, ApplicationStatus> getApplication_Status(User user) {

		List<Application> applications = getApplications_user(user);

		System.out.println("No of applications = " + applications.size());
		Map<Application, ApplicationStatus> application = new HashMap<Application, ApplicationStatus>();

		for (Application app : applications) {
			System.out.println("app number" + app.getApplicationId());
			ApplicationStatusChange status = applicationStatusChangeDao.getLatestApplicationStatusChange(app);
			System.out.println(status.getApplicationstatus());
			application.put(app, status.getApplicationstatus());
		}

		return application;
	}

	@Override
	public int number_applications(User user) {
		return getApplication().size();
	}

	@Override
	@Transactional
	public void deleteApplication(Application application) {

		entityManager.remove(entityManager.find(Application.class, application.getApplicationId()));

	}

	@Override
	@Transactional
	public Application saveApplication(Application application) {
		System.out.println("merging");
		return entityManager.merge(application);
	}

	@Override
	@Transactional
	public Application updateApplication(Integer id, Application application) {
		// Query query = entityManager.createQuery("UPDATE Application p set p =
		// :application where applicationId = :id");
		//
		// int count = query.setParameter("application",
		// application).setParameter("id", id).executeUpdate();

		return entityManager.merge(application);
	}

	@Override
	@Transactional
	public Application updateStudentInfo(Integer id, Application application) {
		// Query query = entityManager
		// .createQuery("UPDATE Application p set p.studentInfo = :info where
		// applicationId = :id");
		//
		// int count = query.setParameter("info",
		// application.getStudentInfo()).setParameter("id", id).executeUpdate();

		entityManager.refresh(application);
		return getApplication(id);
	}

}
