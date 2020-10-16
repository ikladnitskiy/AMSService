package ru.kladnitskiy.AMSService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;
import ru.kladnitskiy.AMSService.model.Ams;
import ru.kladnitskiy.AMSService.model.TypeAms;
import ru.kladnitskiy.AMSService.model.TypesOfWork;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Транспортный объект для передачи общей информации об антенно-мачтовом сооружении.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class AmsDto {

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
    private Boolean isAccess;
    private final TypesOfWork typesOfWork;

    public static AmsDto convertToAmsDto(Ams ams) {
        return new AmsDto(ams.getId(), ams.getCode(), ams.getNumber(), ams.getCluster(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.getServiceContractor(), ams.getServiceDate(), ams.getReportContractor(),
                ams.getReportDate(), ams.getIsAccess(), ams.getTypesOfWork());
    }
}
