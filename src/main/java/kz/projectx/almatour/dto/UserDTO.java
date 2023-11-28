package kz.projectx.almatour.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {

    @Email
    private String userEmail;

    @NotEmpty
    private String userFullName;

    @NotEmpty
    private String userPassword;

    @NotEmpty
    private String userRePassword;
}
