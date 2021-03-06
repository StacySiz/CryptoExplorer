package ru.itis.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.itis.forms.RegistrationForm;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;

import java.util.Optional;

@Component
public class RegistrationValidator implements Validator {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(RegistrationForm.class.getName());
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationForm registrationForm = (RegistrationForm) o;
        Optional<User> ourUsers = userRepository.findByEmail(registrationForm.getEmail());
        if(ourUsers!=null){
            errors.reject("email is in db already","Вашему почтовому ящику уже соответсвует аккаунт");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Введите электронную почту");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Введите пароль");

    }
}
