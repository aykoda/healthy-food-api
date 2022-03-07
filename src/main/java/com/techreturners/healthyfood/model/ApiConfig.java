package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@Builder
public class ApiConfig {


    private String apiKey;

    private String urlMealPlanner;
    private String urlMealRecipe;
    private String url;

    private ResponseEntity<Object> jsonResponse;
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    private HttpMethod http = HttpMethod.GET;

    public ApiConfig() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlMealPlanner(String urlMealPlanner) {
        this.urlMealPlanner = urlMealPlanner;
    }

    public HttpMethod getHttp() {
        return http;
    }

    public HttpEntity<String> getEntity() {
        return entity;
    }


}
