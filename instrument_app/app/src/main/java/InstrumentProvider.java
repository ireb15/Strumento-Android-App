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

    // Generate data for Acoustic Guitars
    public static ArrayList<AcousticGuitar> generateAcousticGuitars() {
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
            acousticGuitars.add(acousticGuitar);
        }
        return acousticGuitars;
    }

    // Generate data for Electric Guitars
    public static ArrayList<ElectricGuitar> generateElectricGuitars() {
        ArrayList<ElectricGuitar> electricGuitars = new ArrayList<ElectricGuitar>();
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
            ElectricGuitar electricGuitar = new ElectricGuitar(title, price, brand, colour,
                    condition, location, description, id, images3);
            electricGuitars.add(electricGuitar);
        }
        return electricGuitars;
    }

    // Generate data for Ukuleles
    public static ArrayList<Ukulele> generateUkuleles() {
        ArrayList<Ukulele> ukuleles = new ArrayList<Ukulele>();
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
            Ukulele ukulele = new Ukulele(title, price, brand, colour,
                    condition, location, description, id, images3);
            ukuleles.add(ukulele);
        }
        return ukuleles;
    }

    // Generate data for Pianos
    public static ArrayList<Piano> generatePianos() {
        ArrayList<Piano> pianos = new ArrayList<Piano>();
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
            Piano piano = new Piano(title, price, brand, colour,
                    condition, location, description, id, images3);
            pianos.add(piano);
        }
        return pianos;
    }

    // Generate data for Drums
    public static ArrayList<Drum> generateDrums() {
        ArrayList<Drum> drums = new ArrayList<Drum>();
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
            Drum drum = new Drum(title, price, brand, colour,
                    condition, location, description, id, images3);
            drums.add(drum);
        }
        return drums;
    }

}
