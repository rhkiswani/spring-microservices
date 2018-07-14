package com.rhkiswani.backbasetask.core.repos;


import com.rhkiswani.backbasetask.core.entites.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends AbstractRepository<Location, Integer> {

    Location findByStreetAndPostalcode(String street, String postalCode);

}
