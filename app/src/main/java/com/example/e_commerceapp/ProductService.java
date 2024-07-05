package com.example.e_commerceapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductService {

    private ApiService apiService;

    public ProductService(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getProducts(int limit, String sort, int offset, Callback<List<Product>> callback) {
        Call<List<Product>> call = apiService.getProducts(limit, sort, offset);
        call.enqueue(callback);
    }
}


