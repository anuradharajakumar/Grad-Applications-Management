package gapp.model.dao;

import gapp.model.AcademicRecords;
import gapp.model.User;

public interface AcademicRecordsDao {

	
	AcademicRecords getAcademicRecords(Integer academicRecordsId);

	AcademicRecords saveAcademicRecords(AcademicRecords academicRecords);
}
