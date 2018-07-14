package com.rhkiswani.backbasetask.core.rest;

import com.google.gson.Gson;
import com.rhkiswani.backbasetask.core.util.GsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public abstract class AbstractRestTemplate<T> {

    public static final String CORRUPTED_TEXT = ")]}',";
    @Value("${ing.webservices.host}")
    private String host;
    @Value("${ing.webservices.port}")
    private Integer port;
    @Value("${ing.webservices.username}")
    private String username;
    @Value("${ing.webservices.password}")
    private String password;

    @Autowired
    protected Gson gson;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    protected abstract String baseUrl();

    protected abstract T toObject(Map res);

    public List<T> list() {
        List objs = list(baseUrl());
        Collections.sort(objs, Comparator.comparing(Object::toString));
        return objs;
    }

    private List<T> list(String url, Object... uriVariables) {
        List<T> listToReturn = new ArrayList<>();
        ResponseEntity<String> responseEntity = restTemplate().exchange(fullUrl(url), HttpMethod.GET, null, String.class, uriVariables);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String body = responseEntity.getBody();
            String fixedResponse = fix(body);
            if (StringUtils.isEmpty(fixedResponse)){
                return listToReturn;
            }
            Map[] map = GsonUtil.create().fromJson(fixedResponse, Map[].class);
            for (Map objAsMap : map) {
                listToReturn.add(toObject(objAsMap));
            }
        }
        return listToReturn;
    }

    private String fix(String body) {
        if (StringUtils.isEmpty(body)){
            return body;
        }
        return body.startsWith(CORRUPTED_TEXT) ? body.substring(CORRUPTED_TEXT.length()) : body;
    }

    private RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }

    private String fullUrl(String contextUrl) {
        StringBuilder builder = new StringBuilder();
        builder.append(port == 443 ? "https" : "http");
        builder.append("://").append(host);
        if (port != null) {
            builder.append(":").append(port);
        }
        builder.append(contextUrl);
        return builder.toString();
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public Integer port() {
        return port;
    }

}
