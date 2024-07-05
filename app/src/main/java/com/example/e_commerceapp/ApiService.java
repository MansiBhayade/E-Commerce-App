package com.example.e_commerceapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

    public interface ApiService {
        @GET("products")
        Call<List<Product>> getProducts(@Query("limit") int limit, @Query("sort") String sort, @Query("offset") Integer offset);
    }

