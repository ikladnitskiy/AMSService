package ru.kladnitskiy.AMSService.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, содержащий в себе данные об ошибке.
 */
@Data
public class ApiError {

    private Date timestamp;
    private Integer status;
    private List<String> errors;

    public ApiError() {
        errors = new ArrayList<>();
    }
}
