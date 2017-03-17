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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<Application> applications;

	@OneToMany
	List<StudentInfo> studentInfo;

	@OneToMany
	List<AcademicRecords> academicRecords;

	@OneToMany
	List<EducationalBackground> educationbackgrounds;

	@ManyToOne
	UserType userType;

	// @ManyToOne
	// Department staffDept;

	public Integer getUserId() {
		return userId;
	}

	public List<EducationalBackground> getEducationbackgrounds() {
		return educationbackgrounds;
	}

	public void setEducationbackgrounds(List<EducationalBackground> educationbackgrounds) {
		this.educationbackgrounds = educationbackgrounds;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}

	public List<AcademicRecords> getAcademicRecords() {
		return academicRecords;
	}

	public void setAcademicRecords(List<AcademicRecords> academicRecords) {
		this.academicRecords = academicRecords;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
