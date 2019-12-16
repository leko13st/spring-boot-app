package com.example.SpringTest.domain;

import javax.persistence.*;

@Entity
public class Car_db {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_auto;

    private String auto;

    public Car_db() {
    }

    public Car_db(String auto) {
        this.auto = auto;
    }

    public Integer getId() {
        return id_auto;
    }

    public void setId(Integer id) {
        this.id_auto = id;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }
}
