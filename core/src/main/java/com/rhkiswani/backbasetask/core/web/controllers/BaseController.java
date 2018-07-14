package com.rhkiswani.backbasetask.core.web.controllers;

import com.google.common.base.Throwables;
import com.rhkiswani.backbasetask.core.repos.AbstractRepository;
import io.github.rhkiswani.javaff.log.Log;
import io.github.rhkiswani.javaff.log.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController<T> {

    private static final Log LOG = LogFactory.getLogger(BaseController.class);

    @Value("${controllers.default-page-size:10}")
    private int defaultSize;

    public PageRequest buildPageRequest(Integer page, Integer size) {
        if (size == null || size == 0) {
            size = defaultSize;
        }
        if (page == null) {
            page = 0;
        }
        return new PageRequest(page, size);
    }

    protected ResponseEntity list(final AbstractRepository repository, final Integer page, final Integer size) {
        return doCall(() -> repository.findAll(buildPageRequest(page, size)).map(o -> toView(o)));
    }

    protected T toView(Object o) {
        return (T) o;
    }

    protected ResponseEntity<T> findOne(final AbstractRepository repository, final Integer id) {
        return doCall(() -> {
            Object one = repository.findById(id);
            if (one == null) {
                throw new IllegalArgumentException("Failed to find with Id " + id);
            }
            return toView(one);
        });
    }

    protected ResponseEntity doCall(ApiCall apiCall) {
        try {
            Object result = apiCall.call();
            if (result instanceof List) {
                List resultAsList = (List) result;
                int size = resultAsList.size();
                result = new PageImpl<>(resultAsList, new PageRequest(0, size != 0 ? size : defaultSize), resultAsList.size());
            }
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    protected ResponseEntity errorResponse(Exception e) {
        LOG.error(e.getMessage());
        Map<String, String> exceptionAsMap = new HashMap<>();
        exceptionAsMap.put("error", e.getMessage());
        exceptionAsMap.put("stacktrace", Throwables.getStackTraceAsString(e));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionAsMap);
    }

}
