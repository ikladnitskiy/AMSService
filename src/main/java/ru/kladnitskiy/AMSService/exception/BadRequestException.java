package ru.kladnitskiy.AMSService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message, String methodName) {
        super(String.format("Invalid request: %s", message));
        log.info("Exception in method {}: {}", methodName, message);
    }
}
