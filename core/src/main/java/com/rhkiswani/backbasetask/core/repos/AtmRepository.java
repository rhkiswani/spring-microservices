package com.rhkiswani.backbasetask.core.repos;


import com.rhkiswani.backbasetask.core.entites.Atm;
import com.rhkiswani.backbasetask.core.entites.AtmType;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AtmRepository extends AbstractRepository<Atm, Integer> {

    void deleteByAtmTypeIn(Set<AtmType> types);

}
