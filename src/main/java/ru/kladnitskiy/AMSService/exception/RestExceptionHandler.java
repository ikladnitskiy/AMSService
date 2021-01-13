package ru.kladnitskiy.AMSService.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(new Date());
        apiError.setStatus(status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        apiError.setErrors(errors);
        return new ResponseEntity<>(apiError, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(new Date());
        apiError.setStatus(status.value());
        String error = String.format("Значение '%s' не является корректным значением типа '%s'",
                ex.getValue(), Objects.requireNonNull(ex.getRequiredType()).getSimpleName());
        apiError.getErrors().add(error);
        return new ResponseEntity<>(apiError, headers, status);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleBadRequestEx(BadRequestException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(new Date());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        String error = ex.getMessage();
        apiError.getErrors().add(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundEx(ResourceNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(new Date());
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        String error = ex.getMessage();
        apiError.getErrors().add(error);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleAllEx(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setTimestamp(new Date());
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        String error = ex.getMessage();
        apiError.getErrors().add(error);
        System.out.println(ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
