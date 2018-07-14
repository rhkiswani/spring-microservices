package com.rhkiswani.backbasetask.core.repos;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<T, I extends Serializable> extends PagingAndSortingRepository<T, I> {

}
