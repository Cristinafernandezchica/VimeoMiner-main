package aiss.vimeominer.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason= "Resource not found")

public class NotFoundException extends Exception {
}
