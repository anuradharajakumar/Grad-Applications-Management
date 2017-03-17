package gapp.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AcademicRecords;
import gapp.model.StudentInfo;
import gapp.model.User;
import gapp.model.dao.AcademicRecordsDao;

@Repository
public class AcademicRecordsDaoImpl implements AcademicRecordsDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AcademicRecords getAcademicRecords(Integer academicRecordsId) {
		return entityManager.find(AcademicRecords.class, academicRecordsId);
	}

	@Override
	@Transactional
	public AcademicRecords saveAcademicRecords(AcademicRecords academicRecords) {

		return entityManager.merge(academicRecords);
	}

	
}
