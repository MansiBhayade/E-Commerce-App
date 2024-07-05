package com.example.e_commerceapp;

import android.media.Rating;

public class Product {

        private int id;
        private String title;
        private double price;
        private String description;
        private String category;
        private String image;

        private Rating rating;

    public static class Rating {
        private double rate;


        // Getters and Setters

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }
    }

        // Getter and Setter for id
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // Getter and Setter for title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getter and Setter for price
        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        // Getter and Setter for description
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        // Getter and Setter for category
        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        // Getter and Setter for image
        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    // Getters and Setters for rating
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


}
