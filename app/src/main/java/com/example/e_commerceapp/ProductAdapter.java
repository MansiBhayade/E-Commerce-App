package com.example.e_commerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    private Set<Integer> cartItems = new HashSet<>();


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.title.setText(product.getTitle());
        holder.price.setText("$" + product.getPrice());
        Glide.with(context)
                .load(product.getImage())
                .centerInside() // Ensures the image fits inside ImageView bounds
                .into(holder.image);
        if (product.getRating() != null) {
            holder.ratingBar.setRating((float) product.getRating().getRate());
        }

        // To keep track on products that have been added to cart
        updateCartButton(holder.cartButtonIcon, product.getId());

        holder.cartButtonIcon.setOnClickListener(v -> {
            if (cartItems.contains(product.getId())) {
                cartItems.remove(product.getId());
                Toast.makeText(context, "Product Removed from Cart", Toast.LENGTH_SHORT).show();
            } else {
                cartItems.add(product.getId());
                Toast.makeText(context, "Product Added to Cart", Toast.LENGTH_SHORT).show();
            }
            updateCartButton(holder.cartButtonIcon, product.getId());
        });
    }



    private void updateCartButton(ImageView cartButtonIcon, int productId) {
        if (cartItems.contains(productId)) {
            cartButtonIcon.setImageResource(R.drawable.ic_removecart);
        } else {
            cartButtonIcon.setImageResource(R.drawable.ic_addcart);
        }
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void addProducts(List<Product> products) {
        int initialSize = productList.size();
        productList.addAll(products);
        notifyItemRangeInserted(initialSize, products.size());
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView image;
        RatingBar ratingBar;

        ImageView cartButtonIcon;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.productTitle);
            price = itemView.findViewById(R.id.productPrice);
            image = itemView.findViewById(R.id.productImage);
            ratingBar = itemView.findViewById(R.id.productRating);
            cartButtonIcon = itemView.findViewById(R.id.cartButtonIcon);
        }
    }
}
