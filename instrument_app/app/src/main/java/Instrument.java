//Instrument App Classes

// Instrument Class
public abstract class Instrument {
    private String title;
    private int price;
    private String brand;
    private String colour;
    private String condition;
    private String location;
    private String description;
    private int id;
    private int views;

    public Instrument(String title, int price, String brand, String colour,
                      String condition, String location, String description, int id) {

        this.title = title;
        this.price = price;
        this.brand = brand;
        this.colour = colour;
        this.condition = condition;
        this.location = location;
        this.description = description;
        this.id = id;
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

    public int getId() {
        return id;
    }
}

// Guitar Class
abstract class Guitar extends Instrument {
    public Guitar (String title, int price, String brand, String colour,
                   String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }

}

// Acoustic Guitar Class
class AcousticGuitar extends Instrument {
    public AcousticGuitar (String title, int price, String brand, String colour,
                    String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }
}

// Electric Guitar Class
class ElectricGuitar extends Instrument {
    public ElectricGuitar (String title, int price, String brand, String colour,
                           String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }
}

// Piano Class
class Piano extends Instrument {
    public Piano (String title, int price, String brand, String colour,
                   String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }
}

// Ukulele Class
class Ukulele extends Instrument {
    public Ukulele (String title, int price, String brand, String colour,
                  String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }
}

// Drum Class
class Drum extends Instrument {
    public Drum (String title, int price, String brand, String colour,
                  String condition, String location, String description, int id)
    {
        super(title,  price,  brand, colour, condition, location, description, id) ;
    }
}
