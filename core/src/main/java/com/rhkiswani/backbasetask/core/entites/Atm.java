package com.rhkiswani.backbasetask.core.entites;


import javax.persistence.*;


@Entity
@Table(name = "atms")
public class Atm extends AbstractEntity<Atm> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double distance;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "atm_type_id", referencedColumnName = "id")
    private AtmType atmType;

    public Atm() {
    }

    @Override
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AtmType getAtmType() {
        return atmType;
    }

    public void setAtmType(AtmType atmType) {
        this.atmType = atmType;
    }
}
