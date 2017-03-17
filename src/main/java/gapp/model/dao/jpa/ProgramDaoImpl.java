package gapp.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gapp.model.Application;
import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Program> getPrograms(Department dept) {
		String query = "from Program where dept = :dept";
		List<Program> results = entityManager.createQuery(query, Program.class).setParameter("dept", dept)
				.getResultList();
		return results;
	}

	@Override
	public List<Program> getProgram() {
		return entityManager.createQuery("from Program order by programId", Program.class).getResultList();
	}

	@Override
	public Program getProgram(Integer programId) {
		return entityManager.find(Program.class, programId);
	}

	@Override
	@Transactional
	public void deleteProgram(Program prog) {
		entityManager.remove(entityManager.find(Program.class, prog.getProgramId()));

	}

	@Override
	@Transactional
	public Program saveProgram(Program program) {
		System.out.println("Save Prgram");
		return entityManager.merge(program);
	}

	@Override
	@Transactional
	public void updateProgram(Program program) {
		Query query = entityManager.createQuery("UPDATE Program p set p = :program where programId = :programId");

		int count = query.setParameter("program", program).setParameter("programId", program.getProgramId())
				.executeUpdate();
	}

}
