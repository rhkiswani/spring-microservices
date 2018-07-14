package com.rhkiswani.backbasetask.web.views;

import com.rhkiswani.backbasetask.core.entites.Atm;

public class AtmView {

    private final Atm atm;

    public AtmView (Atm atm) {
        this.atm = atm;
    }

    public Atm getAtm (){
        return atm;
    }
}
