package gapp.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usertypes")
public class UserType implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer userTypeId;	
	String userTypeName;	

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void getUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}


	
}
