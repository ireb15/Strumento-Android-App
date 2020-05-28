// The InstrumentProvider class simulates fetching data from our static 'database' of 50
// instruments (10 instruments per category/sub-category).

import java.util.ArrayList;
import java.util.Arrays;

public class InstrumentProvider {

    // Titles
    static String[] titles = {
            "Fender Acoustic Guitar","Gibson Acoustic Guitar","Takamine Acoustic Guitar",
            "Taylor Acoustic Guitar","Martin Acoustic Guitar","Guild Acoustic Guitar",
            "Seagull Acoustic Guitar","Yamaha Acoustic Guitar","Ovation Acoustic Guitar",
            "Washburn Acoustic Guitar",
            "Fender Electric Guitar","Gibson Electric Guitar","Takamine Electric Guitar",
            "Taylor Electric Guitar","Martin Electric Guitar","Guild Electric Guitar",
            "Seagull Electric Guitar","Yamaha Electric Guitar","Epiphone Electric Guitar",
            "Washburn Electric Guitar",
            "C.Bechstein Piano","Bluthner Piano","Bosendorfer Piano","FAZIOLI Piano",
            "Grotrian-Steinweg Piano","Sauter Piano","Shigeru Kawai Piano","Steinway & Sons Piano",
            "Steingraeber & Sohne Piano","Yamaha Piano",
            "Makala Ukulele","Kala Ukulele","Donner Ukulele","Lohanu Ukulele",
            "Hricane Ukulele","Pomaikai Ukulele","Fender Ukulele","Lanikai Ukulele",
            "Mahalo Ukulele","Kapono Ukulele",
            "Tama Drums","DW Drums","Yamaha Drums","Sonor Drums", "Pearl Drums",
            "Ludwig Drums","Gretsch Drums","Canopus Drums","Noble & Cooley Drums",
            "British Drum Company Drums"
    };

    // Prices
    static int[] prices = {
            500, 8799, 423, 9569, 6575, 1731, 2135, 1680, 3838, 7091,
            1463, 8243, 9959, 4433, 3284, 4274, 2065, 9054, 9247, 9002,
            71450, 9825, 38497, 28303, 88574, 20540, 64024, 31258, 53790, 31359,
            41, 31, 95, 111, 98, 99, 37, 28, 52, 92,
            683, 3614, 3704, 4975, 4033, 2397, 2657, 3655, 1917, 700,
    };

    // Brands
    static String[] brands = {
            "Fender","Gibson","Takamine","Taylor","Martin","Guild","Seagull","Yamaha","Ovation",
            "Washburn", "Fender","Gibson","Takamine","Taylor","Martin","Guild","Seagull",
            "Yamaha","Epiphone","Washburn","C.Bechstein","Bluthner","Bosendorfer","FAZIOLI",
            "Grotrian-Steinweg","Sauter","Shigeru Kawai","Steinway & Sons","Steingraeber & Sohne","Yamaha",
            "Makala","Kala","Donner","Lohanu","Hricane","Pomaikai","Fender","Lanikai", "Mahalo",
            "Hola!","Tama","DW","Yamaha","Sonor", "Pearl","Ludwig","Gretsch","Canopus","Noble & Cooley",
            "British Drum Company"
    };

    // Colours
    static String[] colours = {
            "Ice Blue","Chroma Black Cherry","Black","Spruce","Spruce","Antique Burst","Mahogany",
            "Sunset Blue","Red Tear Drop","Green",
            "Transparent Black","Seafoam Green","Purple Natural Burst","Crab Blue","Crest White",
            "Blonde","Pavo Purple","Red Raspberry","Cherry Sunburst","Black",
            "","","","","","","","","","",
            "Blue","Mahogany","Mahogany","Sapele/Mahogany","Spruce","Pink","Surf Green","Purple",
            "Yellow","Natural",
            "","","","","","","","","",""
    };

    // Conditions
    static String[] conditions = {
            "Good","Excellent","Good","Excellent","Excellent",
            "Very Good","Very Good","Very Good","Excellent","Excellent",
            "Very Good","Excellent","Excellent","Very Good","Very Good","Excellent","Very Good",
            "Excellent","Excellent","Excellent",
            "Excellent","Good","Very Good","Very Good","Excellent","Very Good","Excellent",
            "Very Good","Excellent","Very Good",
            "Good","Good","Very Good","Excellent","Very Good","Very Good","Good","Good","Very Good",
            "Very Good",
            "Good","Very Good","Very Good","Excellent","Excellent","Very Good","Very Good",
            "Very Good","Good","Good"
    };

    // Locations
    static String[] locations = {"Middle Earth", "Gotham City","Metropolis","Bikini Bottom",
            "Engineering Building","OGGB 260.115", "Spooksville","Antarctica","Mount Olympus","Hollywood",
            "Disney World","Elmo's World","Hogwarts","Willy Wonka's Choco Factory","Emerald City",
            "The Galaxy","Xavier's Academy","Asgard","Neverland","Atlantis","The Shire",
            "Narnia","Hogsmead","MI6","Engineering Building","Riverdale","Diagon Alley","Bethlehem",
            "The Gatsby Mansion","The Titanic","Swallow Falls","Danville,The Tristate Area",
            "Starling City","Central City","Pandora","Lilliput","Cooper Station","Pemberly",
            "Godric's Hollow","Jurassic Park","Townsville","Central Perk","Engineering Building",
            "Agrabah","The Flinstone's House","Silent Hill","Pizza Planet","Arendelle","Heaven",
            "Whoville"
    };

    // Descriptions
    static String[] descriptions = {
            "Currently putting a ring on it, no time for a guitar",//Acoustic Guitar
            "I'm batman(deep voice)",
            "Too strong, keep breaking the strings",
            "Will trade for the Krabby Patty Formula",
            "Too Sad to play",
            "Got into unicycling, no time for guitar",
            "Jinkies, lost my glasses and can't find my guitar",
            "Got frostbite, lost a couple fingers",
            "I can just make myself a guitar",
            "Tried to make it a big, didn't work out",
            "Who need's a guitar when Coco's here",//Electric guitar
            "Elmo can sing, he doesn't need a guitar",
            "I'm a wizard, only got time for spells",
            "Made out of chocolate, promise",
            "Click ur heels and it's yours, otherwise pay up",
            "Time works differently up here, got less time to play",
            "We train mutants not guitarists",
            "Got a little scratch from a hammer but otherwise all good",
            "The children just wont grow up and learn to play",
            "Doesn't play too well underwater, last guy got electrocuted",
            "I'm going on an adventure and can't bring the piano with me",//Piano
            "Went through mum's closet and found this behind the coats",
            "Won this in a Butterbeer competition",
            "This piano will self destruct in 5...4...",
            "Still too sad to play",
            "Ronnie said its either her or the piano, so long ol friend",
            "Went in empty handed, came out with this piano",
            "Followed a star and didn't get where I needed to but found this nice piano in an inn",
            "Already got too many pianos",
            "Got a bit soaked but had it refurbished",
            "It just fell from the sky",//Ukulele
            "I have a Ukulele-inator",
            "Too many arrows flying around, worried it's just gonna get damaged",
            "Learnt the ukulele too quickly, onto the next instrument",
            "Playing Ukulele is alien to me",
            "Ukulele is too big for our home",
            "Not enough space ;) ",
            "A real man knows how to play the ukulele",
            "Moving house, too many crazies waving wands around here",
            "Just a few claw marks on the back",
            "Dropped some chemical X on it",//Drums
            "My roommate already makes enough noise on the guitar, she doesn't need drums too",
            "If you're happy and know it play your drums. That's right, I'm not playing... ",
            "My friend's a genie, I'll just wish for it later",
            "Dino keeps chewing on the sticks",
            "Too noisy for the hill",
            "You've got a friend in me, have my drums",
            "Let it go, let it goooooo...yup, I'm letting it go",
            "We play harps here",
            "Who's drums are these, who knows?"
    };

    // Image path of instrument images in the drawable folder
    static int[] images = {};

    // Generate data for Acoustic Guitars
    public static ArrayList<AcousticGuitar> generateAcousticGuitars() {
        ArrayList<AcousticGuitar> acousticGuitars = new ArrayList<AcousticGuitar>();

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
            int j=i;
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
        int[] images3 = new int[3];
        for (int i = 9; i < 18; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            int j=i;
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
        int[] images3 = new int[3];
        for (int i = 18; i < 27; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            int j=i;
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
        int[] images3 = new int[3];
        for (int i = 27; i < 36; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            int j=i;
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
        int[] images3 = new int[3];
        for (int i = 36; i < 45; i++) {
            int id = i + 1;
            String title = titles[i];
            int price = prices[i];
            String brand = brands[i];
            String colour = colours[i];
            String condition = conditions[i];
            String location = locations[i];
            String description = descriptions[i];
            int j=i;
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
