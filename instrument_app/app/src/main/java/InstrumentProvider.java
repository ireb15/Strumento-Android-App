// The InstrumentProvider class simulates fetching data from our static 'database' of 50
// instruments (10 instruments per category/sub-category).

import java.util.ArrayList;
import java.util.Arrays;

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
        int j = 0;
        int[] images3 = new int[3];
        for (int i = 0; i < 10; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            while (j < j + 3) {
                images3 = Arrays.copyOf(images, 3);
                images3[j] = images[j];
                j++;
            }
            AcousticGuitar acousticGuitar = new AcousticGuitar(title, price, brand, colour,
                    condition, location, description, id, images3);
        }

        ArrayList<ElectricGuitar> electricGuitars = new ArrayList<ElectricGuitar>();
        ArrayList<Ukuleles> ukuleles = new ArrayList<Ukuleles>();
        ArrayList<Pianos> pianos = new ArrayList<Pianos>();
        ArrayList<Drums> drums = new ArrayList<Drums>();
    }

    public static int[] appendX(int n, int array[], int x) {

    }
}
