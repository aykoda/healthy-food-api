package com.techreturners.healthyfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@Builder
public class ApiConfig {

    @Value("${api_key}")
    private String apiKey;

    private String urlMealplanner ="https://api.spoonacular.com/mealplanner/generate?timeFrame=day";
    private String urlMealRecipe ="https://api.spoonacular.com";
    private String url;

    private ResponseEntity<Object> jsonResponse;
    private HttpHeaders headers = new HttpHeaders();
    private HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
    private HttpMethod http = HttpMethod.GET;

    public ApiConfig(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlMealplanner() {
        return urlMealplanner;
    }

    public String getUrlMealRecipe() {
        return urlMealRecipe;
    }

    public void setUrlMealplanner(String urlMealplanner) {
        this.urlMealplanner = urlMealplanner;
    }

    public void setUrlMealRecipe(String urlMealRecipe) {
        this.urlMealRecipe = urlMealRecipe;
    }

    public HttpMethod getHttp() {
        return http;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public HttpEntity<String> getEntity() {
        return entity;
    }

    public String getApiKey() {
        return apiKey;
    }

    public ResponseEntity<Object> getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonRequest(ResponseEntity<Object> jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
