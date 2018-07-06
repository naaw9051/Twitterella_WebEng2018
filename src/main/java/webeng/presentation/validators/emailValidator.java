package webeng.presentation.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import webeng.tranferobjects.User;

@FacesValidator("emailValidator")
public class emailValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String inputEmail = (String) value;
		if(!inputEmail.contains("@")) {
			System.out.println("Email ungültig");
			throw new ValidatorException(new FacesMessage("Email ungültig",
					"Email ungültig"));
		}
	}

}
