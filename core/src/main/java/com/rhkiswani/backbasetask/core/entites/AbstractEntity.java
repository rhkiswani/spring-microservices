package com.rhkiswani.backbasetask.core.entites;

import io.github.rhkiswani.javaff.beans.ValuesHolder;

public abstract class AbstractEntity<T> extends ValuesHolder<T> {

    public abstract Integer getId();

}
