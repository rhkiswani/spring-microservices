package com.rhkiswani.backbasetask.loader.services;

import com.rhkiswani.backbasetask.core.entites.*;
import com.rhkiswani.backbasetask.core.services.AtmService;
import com.rhkiswani.backbasetask.loader.rest.AtmsRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoaderService {

    @Autowired
    private AtmsRestConsumer atmsRestConsumer;

    @Autowired
    private AtmService atmService;

    @Scheduled(cron = "${atm.sync.interval}")
    public void sync() {
        List<Atm> list = atmsRestConsumer.list();
        Set<AtmType> types = list.stream().map(atm -> atm.getAtmType()).collect(Collectors.toSet());
        atmService.deleteByAtmTypeIn(types);
        atmService.saveAll(list);
    }
}
