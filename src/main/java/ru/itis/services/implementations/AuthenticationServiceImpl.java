package ru.itis.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;
import ru.itis.security.details.UserDetailsImpl;
import ru.itis.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl)authentication.getPrincipal();
        User currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        return userRepository.findOne(currentUserId);
    }


}
