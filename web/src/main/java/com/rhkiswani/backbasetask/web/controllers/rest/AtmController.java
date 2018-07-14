package com.rhkiswani.backbasetask.web.controllers.rest;

import com.rhkiswani.backbasetask.core.entites.Atm;
import com.rhkiswani.backbasetask.core.repos.AtmRepository;
import com.rhkiswani.backbasetask.core.web.controllers.BaseController;
import com.rhkiswani.backbasetask.web.views.AtmView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/atm")
public class AtmController extends BaseController<AtmView> {

    @Autowired
    private AtmRepository atmRepository;

    @GetMapping
    @ApiOperation(value = "List All Atms", httpMethod = "GET")
    public ResponseEntity list(@RequestParam(name = "page", required = false) final Integer page,
                               @RequestParam(value = "size", required = false) final Integer size) {
        return list(atmRepository, page, size);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find Atm by Id", httpMethod = "GET")
    public ResponseEntity get(@PathVariable final Integer id) {
        return findOne(atmRepository, id);
    }

    @Override
    protected AtmView toView(Object o) {
        if (o instanceof Atm) {
            return new AtmView((Atm) o);
        }
        return super.toView(o);
    }
}
