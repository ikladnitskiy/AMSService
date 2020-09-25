package ru.kladnitskiy.AMSService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import ru.kladnitskiy.AMSService.model.dto.AmsDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Сущность антенно-мачтового сооружения.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ams")
public class Ams {

    public static final int START_SEQ = 10000;

    //fields
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 4)
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Range(min = 1, max = 5000)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Size(max = 128)
    @Column(name = "cluster")
    private String cluster;

    @NotBlank
    @Size(max = 200)
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeAms type;

    @NotNull
    @Range(min = 2, max = 200)
    @Column(name = "height", nullable = false)
    private Double height;

    @Size(max = 32)
    @Column(name = "service_contractor")
    private String serviceContractor;

    @Column(name = "service_date")
    private LocalDate serviceDate;

    @Size(max = 32)
    @Column(name = "report_contractor")
    private String reportContractor;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "access_status")
    private Boolean accessStatus;

    @OneToOne(mappedBy = "ams", cascade = CascadeType.ALL)
    private TypesOfWork typesOfWork;

    //methods
    public static Ams convertToAms(AmsDto ams) {
        return new Ams(ams.getId(), ams.getCode(), ams.getNumber(), ams.getCluster(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.getServiceContractor(), ams.getServiceDate(), ams.getReportContractor(),
                ams.getReportDate(), ams.getAccessStatus(), ams.getTypesOfWork());
    }
}
