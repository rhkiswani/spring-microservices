package com.rhkiswani.backbasetask.core.repos;


import com.rhkiswani.backbasetask.core.entites.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends AbstractRepository<City, Integer> {

    City findByName(String name);

}
