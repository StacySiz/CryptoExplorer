package ru.itis.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.RegistrationForm;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;
import ru.itis.security.enums.Role;
import ru.itis.services.UserRegistrationService;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void registration(RegistrationForm registrationForm) {
        User newUser = User.builder()
                .firstName(registrationForm.getFirstName())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .lastName(registrationForm.getLastName())
                .email(registrationForm.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(newUser);
    }
}
