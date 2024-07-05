package com.example.e_commerceapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Checkout extends AppCompatActivity {


    private ImageView productImage;
    private TextView productTitle, productPrice, productDescription;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            setContentView(R.layout.checkout);


            // Set up the toolbar
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            // Enable the back button
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

            productImage = findViewById(R.id.product_image);
            productTitle = findViewById(R.id.product_title);
            productPrice = findViewById(R.id.product_price);
            productDescription = findViewById(R.id.product_description);
            checkoutButton = findViewById(R.id.checkout_button);

            fetchProductDetails();



        }
    }

    private void fetchProductDetails() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<Product> call = apiService.getProductDetails(1); // Fetch product with ID 1

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Product product = response.body();
                    displayProductDetails(product);
                } else {
                    Toast.makeText(Checkout.this, "Failed to load product details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(Checkout.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayProductDetails(Product product) {
        productTitle.setText(product.getTitle());
        productPrice.setText("$" + product.getPrice());
        productDescription.setText(product.getDescription());

        Glide.with(this)
                .load(product.getImage())
                .into(productImage);
    }


}
