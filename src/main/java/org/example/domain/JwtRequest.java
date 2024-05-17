package org.example.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class JwtRequest {

    private String login;
    private String password;
}
