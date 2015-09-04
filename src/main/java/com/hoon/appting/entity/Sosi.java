package com.hoon.appting.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by hoon on 2015-07-21.
 */
@Entity
@Table(name = "sosi")
public class Sosi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name="sosi_id", referencedColumnName="id")
    private List<Schedule> scheduleList;

    public Sosi() {
    }

    public Sosi(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
