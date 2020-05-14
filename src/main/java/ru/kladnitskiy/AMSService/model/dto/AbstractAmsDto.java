package ru.kladnitskiy.AMSService.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import ru.kladnitskiy.AMSService.model.TypeAms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public abstract class AbstractAmsDto {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 4)
    private String code;

    @NotNull
    @Range(min = 1, max = 5000)
    private Integer number;

    @NotBlank
    @Size(max = 200)
    private String address;

    @NotNull
    private TypeAms type;

    @Range(min = 2, max = 200)
    private Double height;

    private boolean serviced;

    public AbstractAmsDto() {

    }

    public AbstractAmsDto(Integer id, String code, Integer number, String address, TypeAms type, Double height, boolean serviced) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.address = address;
        this.type = type;
        this.height = height;
        this.serviced = serviced;
    }
}

