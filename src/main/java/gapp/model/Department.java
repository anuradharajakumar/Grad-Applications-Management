package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "departments")
public class Department implements Serializable, Comparable<Department> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer deptId;

	String deptName;

	@JsonIgnore
	@OneToMany(mappedBy = "dept",cascade = { CascadeType.ALL }, orphanRemoval=true)
	List<Application> applications;

	@OneToMany(mappedBy = "dept",cascade = { CascadeType.ALL }, orphanRemoval=true)
	 @JsonManagedReference
	List<Program> programs;

	@OneToMany(mappedBy = "dept",cascade = { CascadeType.ALL }, orphanRemoval=true)
	@JsonManagedReference
	List<AdditionalDocs> additionalDocs;
	

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public List<AdditionalDocs> getAdditionalDocs() {
		return additionalDocs;
	}

	public void setAdditionalDocs(List<AdditionalDocs> additionalDocs) {
		this.additionalDocs = additionalDocs;
	}

	@Override
	public int compareTo(Department o) {
		// TODO Auto-generated method stub
		return this.deptId.compareTo(o.deptId);
	}

}
