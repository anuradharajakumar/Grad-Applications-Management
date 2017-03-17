package gapp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.AcademicRecords;
import gapp.model.Department;

@Component
public class AcademicRecordsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AcademicRecords acad = (AcademicRecords) target;

		if (acad.getGpa() == 0)
			errors.rejectValue("gpa", "error.number.emptygpa");

		if (acad.getGreScore() == 0)
			errors.rejectValue("greScore", "error.number.emptygre");

		if (acad.getToeflScore() == 0)
			errors.rejectValue("toeflScore", "error.number.emptytoefl");

	}

}
