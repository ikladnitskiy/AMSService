package ru.kladnitskiy.AMSService.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import ru.kladnitskiy.AMSService.model.dto.AmsDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Column(name = "serviced")
    private boolean serviced;

    @OneToOne(mappedBy = "ams", cascade = CascadeType.ALL)
    private TypesOfWork typesOfWork;

    //constructors
    public Ams(){

    }

    public Ams(Integer id, String code, Integer number, String address, TypeAms type, Double height, boolean serviced, TypesOfWork typesOfWork) {
        this.id = id;
        this.code = code;
        this.number = number;
        this.address = address;
        this.type = type;
        this.height = height;
        this.serviced = serviced;
        this.typesOfWork = typesOfWork;
    }

    //methods
    public static Ams convertToAms(AmsDto ams){
        return new Ams(ams.getId(), ams.getCode(), ams.getNumber(), ams.getAddress(), ams.getType(),
                ams.getHeight(), ams.isServiced(), ams.getTypesOfWork());
    }
}
