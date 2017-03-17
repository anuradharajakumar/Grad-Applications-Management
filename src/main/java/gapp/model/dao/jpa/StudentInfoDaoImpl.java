package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Program;
import gapp.model.StudentInfo;
import gapp.model.User;
import gapp.model.dao.StudentInfoDao;

@Repository
public class StudentInfoDaoImpl implements StudentInfoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public StudentInfo getStudentInfo(User user) {
		List<StudentInfo> info = entityManager.createQuery("from StudentInfo where user =:u", StudentInfo.class)
				.setParameter("u", user).getResultList();
		if (info.size() == 0)
			return null;

		return info.get(0);
	}

	@Override
	public StudentInfo getStudentInfo(Integer studentInfoId) {
		return entityManager.find(StudentInfo.class, studentInfoId);
	}

	@Override
	@Transactional
	public StudentInfo updateStudentInfo(Integer studentInfoId, StudentInfo studentInfo) {
		System.out.println("Inside function :" + studentInfo.getDob());

		System.out.println("Old studentinfo clas " + getStudentInfo(studentInfoId).getDob());

		entityManager.merge(studentInfo);

		System.out.println("getting ID " + studentInfoId);
		StudentInfo in = getStudentInfo(studentInfoId);
		System.out.println("inside funstion : " + in.getDob());
		return in;
	}

	@Override
	@Transactional
	public StudentInfo saveStudentInfo(StudentInfo info) {
		System.out.println("Save StudentInfo");
		return entityManager.merge(info);
	}

}
