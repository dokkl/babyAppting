package com.hoon.appting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by hoon on 2015-07-21.
 */
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Sosi sosi;

    @Column
    private String program;

    public Schedule() {
    }

    public Schedule(Sosi sosi, String program) {
        this.sosi = sosi;
        this.program = program;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sosi getSosi() {
        return sosi;
    }

    public void setSosi(Sosi sosi) {
        this.sosi = sosi;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

}
