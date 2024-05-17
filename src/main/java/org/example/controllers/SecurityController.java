package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.domain.JwtAuthentication;
import org.example.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SecurityController {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('MODERATOR')")
    @GetMapping("hello/moderator")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello MODERATOR " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello SUPER_ADMIN " + authInfo.getPrincipal() + "!");
    }
}
