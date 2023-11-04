package kz.projectx.almatour.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User is already exist")
@NoArgsConstructor
public class UserIsExistException extends RuntimeException{
}
