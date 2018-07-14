package com.rhkiswani.backbasetask.core.repos;


import com.rhkiswani.backbasetask.core.entites.AtmType;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmTypeRepository extends AbstractRepository<AtmType, Integer> {

    AtmType findByName(String name);

}
