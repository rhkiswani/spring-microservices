package com.rhkiswani.backbasetask.loader.rest;

import com.rhkiswani.backbasetask.core.entites.Atm;
import com.rhkiswani.backbasetask.core.entites.Location;
import com.rhkiswani.backbasetask.core.rest.AbstractRestTemplate;
import com.rhkiswani.backbasetask.core.services.AtmService;
import com.rhkiswani.backbasetask.core.util.MapsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AtmsRestConsumer extends AbstractRestTemplate<Atm> {

    private static final String URL = "/api/locator/atms/";

    @Autowired
    private AtmService atmService;

    @Override
    protected String baseUrl() {
        return URL;
    }


    @Override
    protected Atm toObject(Map res) {
        Atm atm = new Atm();
        atm.setAtmType(atmService.getAtmTypeOrInsert(String.valueOf(res.get("type"))));
        atm.setDistance(MapsUtil.getAsDoubleOrDefault(res, "distance", 0d));
        atm.setLocation(atmService.getLocationOrInsert(toAddress((Map) res.get("address"))));
        atm.setName(atm.getAtmType().getName() + "-ATM@" + atm.getLocation().toString());
        return atm;
    }

    private Location toAddress(Map address) {
        Location location = new Location();
        location.setCity(atmService.getCityOrInsert(String.valueOf(address.get("city"))));
        location.setHousenumber(MapsUtil.getAsIntegerOrDefault(address,"housenumber", 0));
        location.setStreet(String.valueOf(address.get("street")));
        location.setPostalcode(String.valueOf(address.get("postalcode")));
        if (address.get("geoLocation") != null && address.get("geoLocation") instanceof Map) {
            Map map = (Map) address.get("geoLocation");
            location.setLatitude(MapsUtil.getAsDoubleOrDefault(map, "lat", 0d));
            location.setLongitude(MapsUtil.getAsDoubleOrDefault(map, "lng", 0d));
        }
        return location;
    }

}
