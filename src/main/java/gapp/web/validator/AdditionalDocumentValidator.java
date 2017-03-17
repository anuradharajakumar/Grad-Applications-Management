package gapp.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import gapp.model.AdditionalDocs;
import gapp.model.Program;

@Component
public class AdditionalDocumentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		AdditionalDocs doc = (AdditionalDocs) target;

		if (!StringUtils.hasText(doc.getDocName()))
			errors.rejectValue("docName", "error.field.empty");

	}

}
