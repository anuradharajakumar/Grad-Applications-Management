package gapp.model.dao;

import gapp.model.StudentInfo;
import gapp.model.User;

public interface StudentInfoDao {

	StudentInfo getStudentInfo(User user);

	StudentInfo updateStudentInfo(Integer id, StudentInfo studentInfo);

	StudentInfo getStudentInfo(Integer studentInfoId);

	StudentInfo saveStudentInfo(StudentInfo info);
}
