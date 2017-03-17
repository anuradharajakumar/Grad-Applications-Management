package gapp.model.dao;

import java.util.List;

import gapp.model.User;
import gapp.model.UserType;

public interface UserTypeDao {

	UserType getUserType(Integer id);
	List <UserType> getUserTypes();
}
