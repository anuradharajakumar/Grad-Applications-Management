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
@Table(name = "additionaldocsvalues")
public class AdditionalDocsValue implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer additionalDocsValuesId;

	@ManyToOne
	AdditionalDocs additionalDoc;

	String additionalDocValue;

	@ManyToOne
	Application application;

	
	public Integer getAdditionalDocsValuesId() {
		return additionalDocsValuesId;
	}

	public void setAdditionalDocsValuesId(Integer additionalDocsValuesId) {
		this.additionalDocsValuesId = additionalDocsValuesId;
	}

	public AdditionalDocs getAdditionalDoc() {
		return additionalDoc;
	}

	public void setAdditionalDoc(AdditionalDocs additionalDoc) {
		this.additionalDoc = additionalDoc;
	}

	public String getAdditionalDocValue() {
		return additionalDocValue;
	}

	public void setAdditionalDocValue(String additionalDocValue) {
		this.additionalDocValue = additionalDocValue;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}
