// The InstrumentProvider class simulates fetching data from our static 'database' of 50
// instruments (10 instruments per category/sub-category).

import java.util.ArrayList;

public class InstrumentProvider {

    // Titles
    static String[] titles = {};

    // Prices
    static int[] prices = {};

    // Brands
    static String[] brands = {};

    // Colours
    static String[] colours = {};

    // Conditions
    static String[] conditions = {};

    // Locations
    static String[] locations = {"Middle Earth"};

    // Descriptions
    static String[] descriptions = {};

    // Image path of instrument images in the drawable folder
    static int[] images = {};

    // Generate data for all of the instruments
    public static ArrayList<Instrument> generateData() {

        // Generate acoustic guitars
        ArrayList<AcousticGuitar> acousticGuitars = new ArrayList<AcousticGuitar>();
        for (int i = 0; i < 10; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            for (int j = 0; j < 5; j++) {
                int[] images5 = images[j];
            }
        }

        ArrayList<ElectricGuitar> electricGuitars = new ArrayList<ElectricGuitar>();
        ArrayList<Ukuleles> ukuleles = new ArrayList<Ukuleles>();
        ArrayList<Pianos> pianos = new ArrayList<Pianos>();
        ArrayList<Drums> drums = new ArrayList<Drums>();
    }

    public static int[] appendX(int n, int array[], int x) {

    }
}
