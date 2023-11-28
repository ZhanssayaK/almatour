package kz.projectx.almatour.restController;

import jakarta.validation.Valid;
import kz.projectx.almatour.dto.UserDTO;
import kz.projectx.almatour.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrantionService;

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDto) {

        Boolean success = registrantionService.registerUser(userDto);
        return new ResponseEntity<>("Successfully", HttpStatus.CREATED);
    }
}
