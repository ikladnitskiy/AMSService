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

    @Column(name = "code", nullable = false)
    @NotBlank
    @Size(min = 2, max = 4)
    private String code;

    @Column(name = "number", nullable = false, unique = true)
    @NotNull
    @Range(min = 1, max = 5000)
    private int number;

    @Column(name = "address", nullable = false)
    @Size(max = 200)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeAms type;

    @Column(name = "height", nullable = false)
    @Range(min = 2)
    private double height;

    @Column(name = "serviced")
    private boolean serviced;

    @OneToOne(mappedBy = "ams", cascade = CascadeType.ALL)
    private TypesOfWork typesOfWork;

    //constructors
    public Ams(){

    }

    public Ams(Integer id, String code, int number, String address, TypeAms type, double height, boolean serviced, TypesOfWork typesOfWork) {
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

    public boolean isNew(){
        return id == null;
    }


}