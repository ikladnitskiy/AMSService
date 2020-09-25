package ru.kladnitskiy.AMSService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Виды работ, проводимых на АМС.
 * */
@Data
@Entity
@Table(name = "type_of_work")
public class TypesOfWork {

    @Id
    @Column(name = "ams_id")
    @JsonIgnore
    private Integer id;

    @Column(name = "first_1")
    private Boolean first1;

    @Column(name = "first_1A")
    private Boolean first1A;

    @Column(name = "second")
    private Boolean second;

    @Column(name = "third")
    private Boolean third;

    @Column(name = "fourth")
    private Boolean fourth;

    @Column(name = "fifth")
    private Boolean fifth;

    @Column(name = "sixth")
    private Boolean sixth;

    @Column(name = "seventh")
    private Boolean seventh;

    @Column(name = "eighth_1")
    private Boolean eighth1;

    @Column(name = "eighth_2")
    private Boolean eighth2;

    @Column(name = "eighth_3")
    private Boolean eighth3;

    @Column(name = "eighth_4")
    private Boolean eighth4;

    @Column(name = "eighth_5")
    private Boolean eighth5;

    @Column(name = "eighth_6")
    private Boolean eighth6;

    @Column(name = "eighth_7")
    private Boolean eighth7;

    @MapsId
    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Ams ams;

    //constructors
    public TypesOfWork() {

    }

    public TypesOfWork(Integer id, boolean first1, boolean first1A, boolean second, boolean third, boolean fourth, boolean fifth,
                       boolean sixth, boolean seventh, boolean eighth1, boolean eighth2, boolean eighth3,
                       boolean eighth4, boolean eighth5, boolean eighth6, boolean eighth7) {
        this.id = id;
        this.first1 = first1;
        this.first1A = first1A;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth1 = eighth1;
        this.eighth2 = eighth2;
        this.eighth3 = eighth3;
        this.eighth4 = eighth4;
        this.eighth5 = eighth5;
        this.eighth6 = eighth6;
        this.eighth7 = eighth7;
    }

    public TypesOfWork(boolean first1, boolean first1A, boolean second, boolean third, boolean fourth, boolean fifth,
                       boolean sixth, boolean seventh, boolean eighth1, boolean eighth2, boolean eighth3,
                       boolean eighth4, boolean eighth5, boolean eighth6, boolean eighth7) {
        this.first1 = first1;
        this.first1A = first1A;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth1 = eighth1;
        this.eighth2 = eighth2;
        this.eighth3 = eighth3;
        this.eighth4 = eighth4;
        this.eighth5 = eighth5;
        this.eighth6 = eighth6;
        this.eighth7 = eighth7;
    }
}
