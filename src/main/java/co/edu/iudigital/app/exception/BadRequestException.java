package co.edu.iudigital.app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



@ControllerAdvice
public class BadRequestException extends RestException{
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(ErrorDto errorDto) {
        super(errorDto);
    }

    public BadRequestException(String msg) {
        super(msg);
    }
}
