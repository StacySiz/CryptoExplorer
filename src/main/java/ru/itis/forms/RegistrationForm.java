package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationForm {
    String firstName;
    String lastName;
    String email;
    String password;
}
