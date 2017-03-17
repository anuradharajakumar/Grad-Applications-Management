package gapp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		if (!StringUtils.hasText(user.getEmail()))
			errors.rejectValue("email", "error.field.empty");
		if (!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.field.empty");

	}

}
