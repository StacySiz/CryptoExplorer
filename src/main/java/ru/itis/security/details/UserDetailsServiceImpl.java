package ru.itis.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private  final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("THIS EMAIL IS" + email);
        User user = userRepository.findByEmail(email).orElseThrow(()
                -> new IllegalArgumentException("Users not found by email <" + email + ">"));
        return new UserDetailsImpl(user);
    }
}
