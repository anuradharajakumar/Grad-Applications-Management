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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "additionaldocs")
public class AdditionalDocs implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer docId;

	String docName;

	String docType;

	boolean required;

	@ManyToOne
	@JsonBackReference
	Department dept;

	@OneToMany(mappedBy = "additionalDoc", cascade = { CascadeType.ALL }, orphanRemoval = true)
	List<AdditionalDocsValue> additionalDocsValue;
	
	
	
	

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<AdditionalDocsValue> getAdditionalDocsValue() {
		return additionalDocsValue;
	}

	public void setAdditionalDocsValue(List<AdditionalDocsValue> additionalDocsValue) {
		this.additionalDocsValue = additionalDocsValue;
	}

}
