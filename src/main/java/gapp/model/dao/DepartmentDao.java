package gapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import gapp.model.Department;
import gapp.model.User;

public interface DepartmentDao {

	Department getDepartment(Integer deptId);

	Map<Department, Integer> getDepartment();

	Department saveDepartment( Department dept );

	void deleteDepartment(Department dept);
	
	List<Department> getDepartmentList();
	
	public Department getDepartment(String deptName);
}
