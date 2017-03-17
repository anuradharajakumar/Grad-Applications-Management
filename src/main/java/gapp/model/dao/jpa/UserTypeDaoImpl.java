package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.UserType;
import gapp.model.dao.UserTypeDao;

@Repository
public class UserTypeDaoImpl implements UserTypeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserType getUserType(Integer userTypeId) {
		return entityManager.find(UserType.class, userTypeId);
	}

	@Override
	public List<UserType> getUserTypes() {
		return entityManager.createQuery("from UserType order by userTypeId", UserType.class).getResultList();
	}
	
	


}
