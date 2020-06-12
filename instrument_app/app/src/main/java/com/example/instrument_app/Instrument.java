package com.example.instrument_app;//com.example.instrument_app.Instrument App Classes

import java.io.Serializable;

// com.example.instrument_app.Instrument Class
public abstract class Instrument implements Serializable {
    private String title;
    private int price;
    private String brand;
    private String colour;
    private String condition;
    private String location;
    private String description;
    private String seller;
    private int id;
    private int views;
    private int[] images;

    public Instrument(String title, int price, String brand, String colour, String condition,
                      String location, String description, String seller, int id, int view, int[] images) {

        this.title = title;
        this.price = price;
        this.brand = brand;
        this.colour = colour;
        this.condition = condition;
        this.location = location;
        this.description = description;
        this.seller = seller;
        this.id = id;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getColour() {
        return colour;
    }

    public String getCondition() {
        return condition;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getViews() {
        return views;
    }

    public String getSeller(){ return seller; }

    public int getId() {
        return id;
    }

    public int[] getImages() {
        return images;
    }
}

// com.example.instrument_app.Guitar Class
abstract class Guitar extends Instrument {
    public Guitar (String title, int price, String brand, String colour, String condition,
                   String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view,
                id, images) ;
    }

}

// Acoustic com.example.instrument_app.Guitar Class
class AcousticGuitar extends Guitar {
    public AcousticGuitar (String title, int price, String brand, String colour, String condition,
                           String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view, id, images) ;
    }
}

// Electric com.example.instrument_app.Guitar Class
class ElectricGuitar extends Guitar {
    public ElectricGuitar (String title, int price, String brand, String colour, String condition,
                           String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view, id, images) ;
    }
}

// com.example.instrument_app.Piano Class
class Piano extends Instrument {
    public Piano (String title, int price, String brand, String colour, String condition,
                  String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view, id, images) ;
    }
}

// com.example.instrument_app.Ukulele Class
class Ukulele extends Instrument {
    public Ukulele (String title, int price, String brand, String colour,
                  String condition, String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view, id, images) ;
    }
}

// com.example.instrument_app.Drum Class
class Drum extends Instrument {
    public Drum (String title, int price, String brand, String colour,
                  String condition, String location, String description, String seller, int view, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, view, id, images) ;
    }
}
