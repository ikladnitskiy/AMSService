package ru.kladnitskiy.AMSService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, String methodName) {
        super(String.format("Not found: %s", message));
        log.info("Exception in method {}: {}", methodName, message);
    }
}
