package ru.kladnitskiy.AMSService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kladnitskiy.AMSService.rest.dto.AmsDto;

import javax.persistence.*;
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
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "number", nullable = false)
    private Integer number;
    @Column(name = "cluster")
    private String cluster;
    @Column(name = "address", nullable = false, unique = true)
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeAms type;
    @Column(name = "height", nullable = false)
    private Double height;
    @Column(name = "service_contractor")
    private String serviceContractor;
    @Column(name = "service_date")
    private LocalDate serviceDate;
    @Column(name = "report_contractor")
    private String reportContractor;
    @Column(name = "report_date")
    private LocalDate reportDate;
    @Column(name = "access_status")
    private Boolean isAccess;
    @OneToOne(mappedBy = "ams", cascade = CascadeType.ALL)
    private TypesOfWork typesOfWork;

    //methods
    public static Ams convertToAms(AmsDto ams) {
        return new Ams(ams.getId(), ams.getCode(), ams.getNumber(), ams.getCluster(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.getServiceContractor(), ams.getServiceDate(), ams.getReportContractor(),
                ams.getReportDate(), ams.getIsAccess(), ams.getTypesOfWork());
    }

    public boolean isValid() {
        if (this.getServiceDate() != null && this.getReportDate() != null) {
            return (this.getServiceDate().isBefore(this.getReportDate()));
        }
        return false;
    }
}
