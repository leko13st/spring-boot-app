package com.example.SpringTest.domain;

import javax.persistence.*;

@Entity
@Table(name = "bucket")
public class Bucket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_auto")
    public Integer id_auto;

    @Column(name = "auto")
    public String auto;

    public Bucket() {
    }

    public Bucket(String auto) {
        this.auto = auto;
    }

    public Integer getId_auto() {
        return id_auto;
    }

    public void setId_auto(Integer id_auto) {
        this.id_auto = id_auto;
    }

    public String getName_auto() {
        return auto;
    }

    public void setName_auto(String auto) {
        this.auto = auto;
    }
}
