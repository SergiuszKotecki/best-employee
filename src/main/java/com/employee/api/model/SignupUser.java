package com.employee.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class SignupUser {

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    private String username;

    @Email(message = "Incorrect email format")
    private String email;

    @Size(min = 4, max = 1000, message = "Password must be at least 4 characters long")
    private String password;

    @Size(min = 4, max = 1000, message = "Password must be at least 4 characters long")
    private String matchingPassword;

    public Candidate getAsUser() {
        final Candidate user = new Candidate();
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        user.setEmail(this.getEmail());
        return user;
    }

}

