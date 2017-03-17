package gapp.model;

import java.io.Serializable;
import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "applicationstatuschange")

public class ApplicationStatusChange implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer applicationStatusChangeId;

	@ManyToOne
	ApplicationStatus applicationstatus;

	@ManyToOne
	Application application;

	

	String comment;
	
	Date changedTime;

	public Integer getApplicationStatusChangeId() {
		return applicationStatusChangeId;
	}

	public void setApplicationStatusChangeId(Integer applicationStatusChangeId) {
		this.applicationStatusChangeId = applicationStatusChangeId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ApplicationStatus getApplicationstatus() {
		return applicationstatus;
	}

	public void setApplicationstatus(ApplicationStatus applicationstatus) {
		this.applicationstatus = applicationstatus;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Date getChangedTime() {
		return changedTime;
	}

	public void setChangedTime(Date changedTime) {
		this.changedTime = changedTime;
	}

}
