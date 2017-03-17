package gapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer applicationId;

	
	Date dateSubmitted;

	@ManyToOne
	User user;

	@ManyToOne
	Department dept;

	@ManyToOne
	Program program;

	@ManyToOne
	Term term;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true)
	AcademicRecords academicRecords;

	@OneToMany(mappedBy = "applications",cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<EducationalBackground> educationalBackground;

	@OneToOne(cascade = { CascadeType.ALL }, orphanRemoval = true)
	StudentInfo studentInfo;

	@OneToMany(mappedBy = "application", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<AdditionalDocsValue> additionalDocsValue;

	@OneToMany(mappedBy = "application", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<ApplicationStatusChange> applicationStatusChange;
	
	

	public List<AdditionalDocsValue> getAdditionalDocsValue() {
		return additionalDocsValue;
	}

	public void setAdditionalDocsValue(List<AdditionalDocsValue> additionalDocsValue) {
		additionalDocsValue = additionalDocsValue;
	}

	public List<ApplicationStatusChange> getApplicationStatusChange() {
		return applicationStatusChange;
	}

	public void setApplicationStatusChange(List<ApplicationStatusChange> applicationStatusChange) {
		this.applicationStatusChange = applicationStatusChange;
	}

	public List<EducationalBackground> getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(List<EducationalBackground> educationalBackground) {
		this.educationalBackground = educationalBackground;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public AcademicRecords getAcademicRecords() {
		return academicRecords;
	}

	public void setAcademicRecords(AcademicRecords academicRecords) {
		this.academicRecords = academicRecords;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

}
