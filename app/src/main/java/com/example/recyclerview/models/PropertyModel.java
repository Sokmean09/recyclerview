package com.example.recyclerview.models;

import com.example.recyclerview.R;

import java.util.Arrays;
import java.util.List;

public class PropertyModel {
    private int img;
    private String name;
    private double price;
    private String location;
    private double size;

    public PropertyModel(int img, String name, double price, String location, double size) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.location = location;
        this.size = size;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return String.valueOf(size);
    }

    public void setSize(double size) {
        this.size = size;
    }

    public static List<PropertyModel> generateItem() {
        return Arrays.asList(
                new PropertyModel(R.drawable.ic_launcher_background, "Oceanview Apartment", 450000.0, "Miami", 1200.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Downtown Loft", 320000.0, "New York", 950.5),
                new PropertyModel(R.drawable.ic_launcher_background, "Suburban House", 280000.0, "Austin", 2100.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Luxury Penthouse", 1200000.0, "Chicago", 3500.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Cozy Cottage", 150000.0, "Seattle", 800.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Modern Townhouse", 420000.0, "Denver", 1850.5),
                new PropertyModel(R.drawable.ic_launcher_background, "Riverside Condo", 310000.0, "Portland", 1100.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Historic Villa", 850000.0, "Charleston", 3200.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Studio Apartment", 180000.0, "San Francisco", 500.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Garden Estate", 950000.0, "Atlanta", 4500.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Highrise Flat", 540000.0, "Boston", 1350.5),
                new PropertyModel(R.drawable.ic_launcher_background, "Mountain Cabin", 210000.0, "Asheville", 1250.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Beachfront House", 1500000.0, "Malibu", 2800.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Eco-friendly Home", 380000.0, "Austin", 1600.0),
                new PropertyModel(R.drawable.ic_launcher_background, "City Center Duplex", 460000.0, "Philadelphia", 1750.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Rustic Farmhouse", 320000.0, "Nashville", 2400.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Lakeside Retreat", 580000.0, "Lake Tahoe", 2100.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Minimalist Studio", 220000.0, "Seattle", 650.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Grand Mansion", 2500000.0, "Dallas", 8500.0),
                new PropertyModel(R.drawable.ic_launcher_background, "Compact Condo", 195000.0, "Houston", 750.0)
        );
    }
}
