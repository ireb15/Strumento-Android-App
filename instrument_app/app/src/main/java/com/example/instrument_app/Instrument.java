package com.example.instrument_app;//com.example.instrument_app.Instrument App Classes

import java.io.Serializable;
import java.util.ArrayList;

// com.example.instrument_app.Instrument Class
public class Instrument implements Serializable {
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
    private String category;
    private static ArrayList<Instrument> instrumentsList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> acousticGuitarList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> electricGuitarList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> pianoList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> ukuleleList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> drumsList = new ArrayList<Instrument>();
    private static ArrayList<Instrument> topPicks = new ArrayList<Instrument>();

    public Instrument(String title, int price, String brand, String colour, String condition,
                      String location, String description, String seller, int id,
                      int[] images, String category) {

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
        this.category = category;
        this.views = 0;
        instrumentsList.add(this);
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

    public int[] getImages() { return images; }

    public String getCategory() { return category; }

    public static ArrayList<Instrument> getInstrumentsList() {
        return instrumentsList;
    }

    public static ArrayList<Instrument> getAcousticGuitarList() {
        return acousticGuitarList;
    }

    public static ArrayList<Instrument> getElectricGuitarList() {
        return electricGuitarList;
    }

    public static ArrayList<Instrument> getPianoList() {
        return pianoList;
    }

    public static ArrayList<Instrument> getUkuleleList() {
        return ukuleleList;
    }

    public static ArrayList<Instrument> getDrumsList() {
        return drumsList;
    }

    public static void addTopPicks(Instrument instrument) {
        topPicks.add(instrument);
    }

    public void setViews() {
        this.views++;
    }

    public static ArrayList<Instrument> getTopPicks() { return topPicks; }

    public static ArrayList<Instrument> getCategoryList(String category) {
        if (category.equals("Acoustic guitars")) {
            return acousticGuitarList;
        } else if (category.equals("Electric Guitars")) {
            return electricGuitarList;
        } else if (category.equals("Pianos")) {
            return pianoList;
        } else if (category.equals("Ukuleles")) {
            return ukuleleList;
        } else {
            return drumsList;
        }
    }

    public void updateTopPicks(Instrument instrument) {
        if (instrument.category.equals("Acoustic Guitars")) {
            topPicks.set(0, instrument);
        } else if (instrument.category.equals("Electric Guitars")) {
            topPicks.set(1, instrument);
        } else if (instrument.category.equals("Pianos")) {
            topPicks.set(2, instrument);
        } else if (instrument.category.equals("Ukuleles")) {
            topPicks.set(3, instrument);
        } else {
            topPicks.set(4, instrument);
        }
    }
}

// Acoustic com.example.instrument_app.Guitar Class
class AcousticGuitar extends Instrument {
    public AcousticGuitar (String title, int price, String brand, String colour, String condition,
                           String location, String description, String seller, int id, int[] images, String category)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, id, images, category) ;
        getAcousticGuitarList().add(this);
    }
}

// Electric com.example.instrument_app.Guitar Class
class ElectricGuitar extends Instrument {
    public ElectricGuitar (String title, int price, String brand, String colour, String condition,
                           String location, String description, String seller, int id, int[] images, String category)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, id, images, category) ;
        getElectricGuitarList().add(this);
    }
}

// com.example.instrument_app.Piano Class
class Piano extends Instrument {
    public Piano (String title, int price, String brand, String colour, String condition,
                  String location, String description, String seller, int id, int[] images, String category)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, id, images, category) ;
        getPianoList().add(this);
    }
}

// com.example.instrument_app.Ukulele Class
class Ukulele extends Instrument {
    public Ukulele (String title, int price, String brand, String colour,
                  String condition, String location, String description, String seller, int id, int[] images, String category)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, id, images, category) ;
        getUkuleleList().add(this);
    }
}

// com.example.instrument_app.Drum Class
class Drum extends Instrument {
    public Drum (String title, int price, String brand, String colour,
                  String condition, String location, String description, String seller, int id, int[] images, String category)
    {
        super(title,  price,  brand, colour, condition, location, description, seller, id, images, category) ;
        getDrumsList().add(this);
    }
}
