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
@Table(name = "educationalbackground")
public class EducationalBackground implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer educationalBackgroundId;

	String university;
	String degree;
	
	String degreeStart;
	
	String degreeEnd;
	String major;

	@ManyToOne
	User user;

	@ManyToOne
	Application applications;
	
	

	public Application getApplications() {
		return applications;
	}

	public void setApplications(Application applications) {
		this.applications = applications;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getEducationalBackgroundId() {
		return educationalBackgroundId;
	}

	public void setEducationalBackgroundId(Integer educationalBackgroundId) {
		this.educationalBackgroundId = educationalBackgroundId;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	

	public String getDegreeStart() {
		return degreeStart;
	}

	public void setDegreeStart(String degreeStart) {
		this.degreeStart = degreeStart;
	}

	public String getDegreeEnd() {
		return degreeEnd;
	}

	public void setDegreeEnd(String degreeEnd) {
		this.degreeEnd = degreeEnd;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
