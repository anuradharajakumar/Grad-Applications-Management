package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applicationstatus")

public class ApplicationStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer applicationStatusId;

	String status;

	@OneToMany(mappedBy = "applicationstatus", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<ApplicationStatusChange> ApplicationStatusChange;

	public Integer getApplicationStatusId() {
		return applicationStatusId;
	}

	public void setApplicationStatusId(Integer applicationStatusId) {
		this.applicationStatusId = applicationStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
