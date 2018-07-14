package com.rhkiswani.backbasetask.core.entites;

import javax.persistence.*;

@Entity
@Table(name = "ATM_TYPES")
public class AtmType extends AbstractEntity<AtmType> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    public AtmType() {
    }

    public AtmType(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}