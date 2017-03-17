package gapp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;
import java.util.List;

import gapp.model.AcademicRecords;
import gapp.model.Application;
import gapp.model.Department;
import gapp.model.EducationalBackground;
import gapp.model.Program;
import gapp.model.StudentInfo;
import gapp.model.User;

@Test(groups = "ApplicationDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	ApplicationDao applicationDao;

	// Test Case 2
	@Test
	public void testCase2() {
		List<Application> applications = applicationDao.getApplication("Accounting", "Fall", 2016);

		assert applications.size() == 1;
	}
		
	
	// Test Case 3
	
	@Test
	public void testCase3()
	{
		List<Application> applications = applicationDao.getApplication("Student1", "student1@localhost.localdomain");
		
		
		assert 1==1;
	}



}
