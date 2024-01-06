package com.javaweb.jetty.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="cardValidator")
public class CardValidator implements Validator {
    public void validate(FacesContext context,
                         UIComponent component,
                         Object value){
        boolean isInvalid =false;
        if(value instanceof String){
            String str = (String) value;
            if(str.length()!=16){
                isInvalid=true;
            }
        }else{
            isInvalid=true;
        }

        if(isInvalid){
            FacesMessage msg =
                new FacesMessage("Card validation failed.",
                        "Invalid Card format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}

