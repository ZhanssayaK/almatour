package kz.projectx.almatour.service;

import kz.projectx.almatour.dto.UserDTO;
import kz.projectx.almatour.exception.RePasswordException;
import kz.projectx.almatour.exception.UserIsExistException;
import kz.projectx.almatour.mapper.UserMapper;
import kz.projectx.almatour.model.Role;
import kz.projectx.almatour.model.User;
import kz.projectx.almatour.repository.RoleRepository;
import kz.projectx.almatour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrantionService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;


    public Boolean registerUser(UserDTO userDto) {

        User user = userRepository.findByEmail(userDto.getUserEmail());

        if (user != null) {
            throw new UserIsExistException();
        }

        if (!userDto.getUserPassword().equals(userDto.getUserRePassword())) {
            throw new RePasswordException();
        }

        Role role = roleRepository.findByRoleName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        User newUser = userMapper.toEntity(userDto);
        newUser.setPassword(passwordEncoder.encode(userDto.getUserPassword()));
        newUser.setRoles(roles);

        userRepository.save(newUser);
        return true;
    }
}
