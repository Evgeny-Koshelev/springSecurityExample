package org.example.entities;

import lombok.*;
import org.example.enums.Role;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String login;
    private String password;
    private String name;
    private Set<Role> roles;
    private int failedAttempts;
    private boolean isBlocked;

}
