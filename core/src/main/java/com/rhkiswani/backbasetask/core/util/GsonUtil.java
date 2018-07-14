package com.rhkiswani.backbasetask.core.util;

import com.google.gson.Gson;

public final class GsonUtil {

    private GsonUtil (){

    }

    public static Gson create (){
        return new Gson();
    }
}
