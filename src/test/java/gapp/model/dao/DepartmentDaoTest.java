package gapp.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import gapp.model.Department;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")


public class DepartmentDaoTest extends AbstractTransactionalTestNGSpringContextTests {
	
	
	@Autowired
	DepartmentDao departmentDao;

	
	// Test Case 1 
	@Test
	public void getDepartment() {
		
		assert departmentDao.getDepartment().size() == 2;
	}

}
