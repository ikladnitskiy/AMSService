package ru.kladnitskiy.AMSService.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import ru.kladnitskiy.AMSService.model.TypeAms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public abstract class AbstractAmsDto {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 4)
    private String code;

    @NotNull
    @Range(min = 1, max = 5000)
    private Integer number;

    @Size(max = 128)
    private String cluster;

    @NotBlank
    @Size(max = 200)
    private String address;

    @NotNull
    private TypeAms type;

    @Range(min = 2, max = 200)
    private Double height;

    @Size(max = 32)
    private String serviceContractor;

    @PastOrPresent
    private LocalDate serviceDate;

    @Size(max = 32)
    private String reportContractor;

    @PastOrPresent
    private LocalDate reportDate;

    public AbstractAmsDto() {

    }

    public AbstractAmsDto(Integer id, String code, Integer number, String cluster, String address, TypeAms type, Double height,
                          String serviceContractor, LocalDate serviceDate, String reportContractor, LocalDate reportDate) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.cluster = cluster;
        this.address = address;
        this.type = type;
        this.height = height;
        this.serviceContractor = serviceContractor;
        this.serviceDate = serviceDate;
        this.reportContractor = reportContractor;
        this.reportDate = reportDate;
    }
}

