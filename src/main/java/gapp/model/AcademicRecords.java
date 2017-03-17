package gapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "academicrecords")
public class AcademicRecords implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer academicRecordId;

	int toeflScore;
	int greScore;
	float gpa;
	String transcript; //file
	
	@ManyToOne
	User user;
	
	@OneToOne
	Application applications;
	
	public User getUser() {
		return user;
	}

	public Application getApplications() {
		return applications;
	}

	public void setApplications(Application applications) {
		this.applications = applications;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAcademicRecordId() {
		return academicRecordId;
	}

	public void setAcademicRecordId(Integer academicRecordId) {
		this.academicRecordId = academicRecordId;
	}

	public int getToeflScore() {
		return toeflScore;
	}

	public void setToeflScore(int toeflScore) {
		this.toeflScore = toeflScore;
	}

	public int getGreScore() {
		return greScore;
	}

	public void setGreScore(int greScore) {
		this.greScore = greScore;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	
}
