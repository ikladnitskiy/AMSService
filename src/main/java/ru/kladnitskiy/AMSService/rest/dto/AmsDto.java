package ru.kladnitskiy.AMSService.rest.dto;

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
    @NotBlank(message = "{ex.ams.emptyCode}")
    @Size(min = 2, max = 4, message = "{ex.ams.wrongCode}")
    private String code;
    @NotNull(message = "{ex.ams.emptyNumber}")
    @Range(min = 1, max = 5000, message = "{ex.ams.wrongNumber}")
    private Integer number;
    @Size(max = 128, message = "{ex.ams.clusterToLong}")
    private String cluster;
    @NotBlank(message = "{ex.ams.emptyAddress}")
    @Size(max = 200, message = "{ex.ams.addressToLong}")
    private String address;
    @NotNull(message = "{ex.ams.emptyType}")
    private TypeAms type;
    @Range(min = 2, max = 200, message = "{ex.ams.wrongHeight}")
    private Double height;
    @Size(max = 32, message = "{ex.ams.nameToLong}")
    private String serviceContractor;
    @PastOrPresent(message = "{ex.ams.wrongServiceDate}")
    private LocalDate serviceDate;
    @Size(max = 32, message = "{ex.ams.nameToLong}")
    private String reportContractor;
    @PastOrPresent(message = "{ex.ams.wrongReportDate}")
    private LocalDate reportDate;
    private Boolean isAccess;
    private TypesOfWork typesOfWork;

    public static AmsDto convertToAmsDto(Ams ams) {
        return new AmsDto(ams.getId(), ams.getCode(), ams.getNumber(), ams.getCluster(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.getServiceContractor(), ams.getServiceDate(), ams.getReportContractor(),
                ams.getReportDate(), ams.getIsAccess(), ams.getTypesOfWork());
    }
}
