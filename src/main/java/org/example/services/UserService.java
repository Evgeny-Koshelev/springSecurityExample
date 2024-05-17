package org.example.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entities.User;
import org.example.enums.Role;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = List.of(
                new User("Alex", "1234", "Alexsey Alexseev", Collections.singleton(Role.MODERATOR),
                        0, false),
                new User("ivan", "12345", "Ivan Ivanov", Collections.singleton(Role.SUPER_ADMIN),
                        0, false)
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

}
