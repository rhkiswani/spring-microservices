package com.rhkiswani.backbasetask.core.services;

import com.rhkiswani.backbasetask.core.entites.*;
import com.rhkiswani.backbasetask.core.repos.AtmRepository;
import com.rhkiswani.backbasetask.core.repos.AtmTypeRepository;
import com.rhkiswani.backbasetask.core.repos.CityRepository;
import com.rhkiswani.backbasetask.core.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AtmService {

    @Autowired
    private AtmTypeRepository atmTypeRepository;

    @Autowired
    private AtmRepository atmRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CityRepository cityRepository;

    public AtmType getAtmTypeOrInsert(String atmType) {
        AtmType type = atmTypeRepository.findByName(atmType);
        if (type == null) {
            type = new AtmType();
            type.setName(atmType);
            return atmTypeRepository.save(type);
        }
        return type;
    }


    public Location getLocationOrInsert(Location address) {
        Location location = locationRepository.findByStreetAndPostalcode(address.getStreet(), address.getPostalcode());
        if (location == null) {
            return locationRepository.save(address);
        }
        return location;
    }

    public City getCityOrInsert(String cityName) {
        City city = cityRepository.findByName(cityName);
        if (city == null) {
            city = new City();
            city.setCountry(new Country(1));// assuming it's only netherlands
            city.setName(cityName);
            return cityRepository.save(city);
        }
        return city;
    }

    @Transactional
    public void deleteByAtmTypeIn(Set<AtmType> types) {
        atmRepository.deleteByAtmTypeIn(types);
    }

    @Transactional
    public void saveAll(List<Atm> list) {
        atmRepository.saveAll(list);
    }
}
