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
    private int[] images;

    public Instrument(String title, int price, String brand, String colour, String condition,
                      String location, String description, int id, int[] images) {

        this.title = title;
        this.price = price;
        this.brand = brand;
        this.colour = colour;
        this.condition = condition;
        this.location = location;
        this.description = description;
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

    public int getId() {
        return id;
    }

    public int[] getImages() {
        return images;
    }
}

// Guitar Class
abstract class Guitar extends Instrument {
    public Guitar (String title, int price, String brand, String colour,
                   String condition, String location, String description, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }

}

// Acoustic Guitar Class
class AcousticGuitar extends Instrument {
    public AcousticGuitar (String title, int price, String brand, String colour,
                    String condition, String location, String description, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }
}

// Electric Guitar Class
class ElectricGuitar extends Instrument {
    public ElectricGuitar (String title, int price, String brand, String colour,
                           String condition, String location, String description, int id,
                           int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }
}

// Piano Class
class Piano extends Instrument {
    public Piano (String title, int price, String brand, String colour,
                   String condition, String location, String description, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }
}

// Ukulele Class
class Ukulele extends Instrument {
    public Ukulele (String title, int price, String brand, String colour,
                  String condition, String location, String description, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }
}

// Drum Class
class Drum extends Instrument {
    public Drum (String title, int price, String brand, String colour,
                  String condition, String location, String description, int id, int[] images)
    {
        super(title,  price,  brand, colour, condition, location, description, id, images) ;
    }
}
