package com.rhkiswani.backbasetask.core.entites;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES")
public class Country extends AbstractEntity<Country> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<City> cities;

    public Country() {
    }

    public Country(int id) {
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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}