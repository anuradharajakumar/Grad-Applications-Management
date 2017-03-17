package gapp.web.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.User;
import gapp.model.dao.UserDao;

@Component
public class newUserValidator implements Validator {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		List<User> users = userDao.getUsers();

		
		if (!StringUtils.hasText(user.getEmail()))
			errors.rejectValue("email", "error.field.empty");
		if (!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.field.empty");
		if (!StringUtils.hasText(user.getFirstName()))
			errors.rejectValue("firstName", "error.field.empty");
		if (!StringUtils.hasText(user.getLastName()))
			errors.rejectValue("lastName", "error.field.empty");

		for (User u : users)
			if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
				errors.rejectValue("email", "error.email.validate");
				break;
			}
		
	}

}
