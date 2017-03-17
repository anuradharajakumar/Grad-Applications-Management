package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AcademicRecords;
import gapp.model.EducationalBackground;
import gapp.model.StudentInfo;
import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUser(Integer userId) {

		return entityManager.find(User.class, userId);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = entityManager.createQuery("from User order by userId", User.class).getResultList();
		return users;
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public User getUser(String name, String email) {
		User users = entityManager
				.createQuery("from User u WHERE u.firstName = :firstName and u.email = :email", User.class)
				.setParameter("firstName", name).setParameter("email", email).getResultList().get(0);

		return users;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		entityManager.remove(entityManager.find(User.class, user.getUserId()));

	}

	@Override
	public StudentInfo getStudentInfo(User user) {

		return null;
	}

	@Override
	public AcademicRecords getAcademicRecords(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EducationalBackground> getEducationalBackground(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}