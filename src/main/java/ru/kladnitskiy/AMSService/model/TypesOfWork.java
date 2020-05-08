package ru.kladnitskiy.AMSService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "type_of_work")
public class TypesOfWork {

    @Id
    @Column(name = "ams_id")
    @JsonIgnore
    private Integer id;

    @Column(name = "first")
    private Boolean first;

    @Column(name = "second")
    private Boolean second;

    @Column(name = "third")
    private Boolean third;

    @Column(name = "fourth")
    private Boolean fourth;

    @Column(name = "fifth")
    private Boolean fifth;

    @MapsId
    @OneToOne
    @JsonIgnore
    @ToString.Exclude
    private Ams ams;

    //constructors
    public TypesOfWork() {
    }

    public TypesOfWork(boolean first, boolean second, boolean third, boolean fourth, boolean fifth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public TypesOfWork(int id, boolean first, boolean second, boolean third, boolean fourth, boolean fifth){
        this.id = id;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }
}
