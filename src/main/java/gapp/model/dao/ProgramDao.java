package gapp.model.dao;

import java.util.List;

import gapp.model.Department;
import gapp.model.Program;

public interface ProgramDao {

	List<Program> getPrograms(Department dept);

	List<Program> getProgram();

	Program getProgram(Integer programId);

	void deleteProgram(Program prog);

	Program saveProgram(Program program);
	
	void updateProgram(Program program);

}
