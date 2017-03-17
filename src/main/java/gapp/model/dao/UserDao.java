package gapp.model.dao;

import java.util.List;

import gapp.model.AcademicRecords;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.StudentInfo;
import gapp.model.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getUsers();

	User saveUser(User user);

	User getUser(String name, String email);

	void deleteUser(User user);

	StudentInfo getStudentInfo(User user);

	AcademicRecords getAcademicRecords(User user);

	List<EducationalBackground> getEducationalBackground(User user);

}