package gapp.model.dao.jpa;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.AdditionalDocs;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.User;
import gapp.model.dao.DepartmentDao;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceContext
	private EntityManager entityManager1;

	@Override
	public Department getDepartment(Integer deptId) {
		System.out.println("getDepartment");
		Department d = entityManager.find(Department.class, deptId);
		System.out.println("Department is : " + d.getDeptName());
		return d;
	}

	@Override
	public Map<Department, Integer> getDepartment() {

		List<Department> departments = entityManager.createQuery("from Department order by deptId", Department.class)
				.getResultList();

		DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

		Map<Department, Integer> department = new TreeMap<Department, Integer>();

		for (Department dept : departments) {

			String query = "from Program where dept = :dept";
			List<Program> results = entityManager1.createQuery(query, Program.class).setParameter("dept", dept)
					.getResultList();
			int count = results.size();
			department.put(dept, count);

		}

		return department;
	}

	@Override
	@Transactional
	public Department saveDepartment(Department dept) {
		return entityManager.merge(dept);
	}

	@Override
	@Transactional
	public void deleteDepartment(Department dept) {

		entityManager.remove(dept);
	}

	@Override
	public List<Department> getDepartmentList() {
		List<Department> departments = entityManager.createQuery("from Department order by deptId", Department.class)
				.getResultList();
		return departments;
	}

	@Override
	public Department getDepartment(String deptName)

	{
		String query = "from Department c WHERE c.deptName = :deptName";
		System.out.println("Get Department");
		List<Department> departments = entityManager.createQuery(query, Department.class)
				.setParameter("deptName", deptName).getResultList();
		System.out.println(departments.get(0).getDeptName());
		return departments.get(0);
	}
}
