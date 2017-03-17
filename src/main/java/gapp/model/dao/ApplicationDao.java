package gapp.model.dao;

import java.util.List;
import java.util.Map;

import gapp.model.Application;
import gapp.model.ApplicationStatus;
import gapp.model.Program;
import gapp.model.User;

public interface ApplicationDao {

	Application getApplication(Integer applicationId);

	List<Application> getApplication();

	List<Application> getApplication(String deptName, String term, Integer year);

	List<Application> getApplication(String studentName, String emailid);
	
	

	Map<Application, ApplicationStatus> getApplication_Status(User user);

	List<Application> getApplications_user(User user);

	int number_applications(User user);

	void deleteApplication(Application application);

	Application saveApplication(Application application);

	Application updateApplication(Integer id, Application application);

	Application updateStudentInfo(Integer id, Application application);
}
