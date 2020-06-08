package com.example.instrument_app;
// The com.example.instrument_app.InstrumentProvider class simulates fetching data from our static 'database' of 50
// instruments (10 instruments per category/sub-category).

import com.example.instrument_app.R;

import java.util.ArrayList;
import java.util.Arrays;

public class InstrumentProvider {
    //What is com.example?
    // Titles
    static String[] titles = {
            "Fender Acoustic com.example.instrument_app.Guitar","Gibson Acoustic com.example.instrument_app.Guitar","Takamine Acoustic com.example.instrument_app.Guitar",
            "Taylor Acoustic com.example.instrument_app.Guitar","Martin Acoustic com.example.instrument_app.Guitar","Guild Acoustic com.example.instrument_app.Guitar",
            "Seagull Acoustic com.example.instrument_app.Guitar","Yamaha Acoustic com.example.instrument_app.Guitar","Ovation Acoustic com.example.instrument_app.Guitar",
            "Washburn Acoustic com.example.instrument_app.Guitar",
            "Fender Electric com.example.instrument_app.Guitar","Gibson Electric com.example.instrument_app.Guitar","LTD Electric com.example.instrument_app.Guitar",
            "PRS Electric com.example.instrument_app.Guitar","Gretsch Electric com.example.instrument_app.Guitar","Guild Electric com.example.instrument_app.Guitar",
            "Jackson Electric com.example.instrument_app.Guitar","Yamaha Electric com.example.instrument_app.Guitar","Vintage Electric com.example.instrument_app.Guitar",
            "Washburn Electric com.example.instrument_app.Guitar",
            "C.Bechstein com.example.instrument_app.Piano","Bluthner com.example.instrument_app.Piano","Bosendorfer com.example.instrument_app.Piano","FAZIOLI com.example.instrument_app.Piano",
            "Grotrian-Steinweg com.example.instrument_app.Piano","Sauter com.example.instrument_app.Piano","Shigeru Kawai com.example.instrument_app.Piano","Steinway & Sons com.example.instrument_app.Piano",
            "Steingraeber & Sohne com.example.instrument_app.Piano","Yamaha com.example.instrument_app.Piano",
            "Makala com.example.instrument_app.Ukulele","Kala com.example.instrument_app.Ukulele","Donner com.example.instrument_app.Ukulele","Lohanu com.example.instrument_app.Ukulele",
            "Hricane com.example.instrument_app.Ukulele","Pomaikai com.example.instrument_app.Ukulele","Fender com.example.instrument_app.Ukulele","Lanikai com.example.instrument_app.Ukulele",
            "Mahalo com.example.instrument_app.Ukulele","Kapono com.example.instrument_app.Ukulele",
            "Tama Drums","DW Drums","Yamaha Drums","Sonor Drums", "Pearl Drums",
            "Ludwig Drums","Gretsch Drums","Canopus Drums","Noble & Cooley Drums",
            "British com.example.instrument_app.Drum Company Drums"
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
            "Washburn","Fender","Gibson","LTD","PRS","Gretsch","Guild","Jackson",
            "Yamaha","Vintage","Washburn","C.Bechstein","Bluthner","Bosendorfer","FAZIOLI",
            "Grotrian-Steinweg","Sauter","Shigeru Kawai","Steinway & Sons","Steingraeber & Sohne","Yamaha",
            "Makala","Kala","Donner","Lohanu","Hricane","Pomaikai","Fender","Lanikai", "Mahalo",
            "Kapono","Tama","DW","Yamaha","Sonor", "Pearl","Ludwig","Gretsch","Canopus","Noble & Cooley",
            "British com.example.instrument_app.Drum Company"
    };

    // Colours
    static String[] colours = {
            "Ice Blue","Chroma Black Cherry","Black","Spruce","Spruce","Antique Burst","Mahogany",
            "Sunset Blue","Red Tear Drop","Green",
            "Transparent Black","Seafoam Green","Purple Natural Burst","Crab Blue","Crest White",
            "Blonde","Pavo Purple","Red Raspberry","Cherry Sunburst","Black",
            "Black","Black","Black","Red","Harvest Stain","Black","Black","Black","Harvest Stain","White",
            "Blue","Mahogany","Mahogany","Sapele/Mahogany","Spruce","Pink","Surf Green","Purple",
            "Yellow","Natural",
            "Metallic Turquoise","Toasted Almond","Deep Red","Silver","Black","Blue Shell",
            "Golden","Natural Wood","Stained Wood","Cream"
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
            "Currently putting a ring on it, no time for a guitar",//Acoustic com.example.instrument_app.Guitar
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
            "I'm going on an adventure and can't bring the piano with me",//com.example.instrument_app.Piano
            "Went through mum's closet and found this behind the coats",
            "Won this in a Butterbeer competition",
            "This piano will self destruct in 5...4...",
            "Still too sad to play",
            "Ronnie said its either her or the piano, so long ol friend",
            "Went in empty handed, came out with this piano",
            "Followed a star and didn't get where I needed to but found this nice piano in an inn",
            "Already got too many pianos",
            "Got a bit soaked but had it refurbished",
            "It just fell from the sky",//com.example.instrument_app.Ukulele
            "I have a com.example.instrument_app.Ukulele-inator",
            "Too many arrows flying around, worried it's just gonna get damaged",
            "Learnt the ukulele too quickly, onto the next instrument",
            "Playing com.example.instrument_app.Ukulele is alien to me",
            "com.example.instrument_app.Ukulele is too big for our home",
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
    static int[] images = {R.drawable.fender_acoustic_1, R.drawable.fender_acoustic_2,
            R.drawable.fender_acoustic_3, R.drawable.gibson_acoustic_1, R.drawable.gibson_acoustic_2,
            R.drawable.gibson_acoustic_3, R.drawable.takamine_acoustic1, R.drawable.takamine_acoustic2,
            R.drawable.takamine_acoustic3, R.drawable.taylor_acoustic1, R.drawable.taylor_acoustic2,
            R.drawable.taylor_acoustic3, R.drawable.martin_acoustic1, R.drawable.martin_acoustic2,
            R.drawable.martin_acoustic3, R.drawable.guild_acoustic_1, R.drawable.guild_acoustic_2,
            R.drawable.guild_acoustic_3, R.drawable.seagull_acoustic1, R.drawable.seagull_acoustic2,
            R.drawable.seagull_acoustic3, R.drawable.yamaha_acoustic1, R.drawable.yamaha_acoustic2,
            R.drawable.yamaha_acoustic3, R.drawable.ovation_acoustic1, R.drawable.ovation_acoustic2,
            R.drawable.ovation_acoustic3, R.drawable.washburn_acoustic1, R.drawable.washburn_acoustic2,
            R.drawable.washburn_acoustic3, R.drawable.fender_electric_1, R.drawable.fender_electric_2,
            R.drawable.fender_electric_3, R.drawable.gibson_electric_1, R.drawable.gibson_electric_2,
            R.drawable.gibson_electric_3, R.drawable.ltd_electric_1, R.drawable.ltd_electric_2,
            R.drawable.ltd_electric_3, R.drawable.prs_electric1, R.drawable.prs_electric2,
            R.drawable.prs_electric3, R.drawable.gretsch_electric_1, R.drawable.gretsch_electric_2,
            R.drawable.gretsch_electric_3, R.drawable.guild_electric_1, R.drawable.guild_electric_2,
            R.drawable.guild_electric_3, R.drawable.jackson_electric_1, R.drawable.jackson_electric_2,
            R.drawable.jackson_electric_3, R.drawable.yamaha_electric1, R.drawable.yamaha_electric2,
            R.drawable.yamaha_electric3, R.drawable.vintage_electric1, R.drawable.vintage_electric2,
            R.drawable.vintage_electric3, R.drawable.washburn_electric1, R.drawable.washburn_electric2,
            R.drawable.washburn_electric3, R.drawable.c_bechstein_piano_1,
            R.drawable.c_bechstein_piano_2, R.drawable.c_bechstein_piano_3, R.drawable.bluthner_piano_1,
            R.drawable.bluthner_piano_2, R.drawable.bluthner_piano_3, R.drawable.bosendorfer_piano_1,
            R.drawable.bosendorfer_piano_2, R.drawable.bosendorfer_piano_3, R.drawable.fazioli_piano_1,
            R.drawable.fazioli_piano_2, R.drawable.fazioli_piano_3, R.drawable.grotrian_steinweg_piano_1,
            R.drawable.grotrian_steinweg_piano_2, R.drawable.grotrian_steinweg_piano_3,
            R.drawable.sauter_piano1, R.drawable.sauter_piano2, R.drawable.sauter_piano3,
            R.drawable.shigeru_kawai_piano1, R.drawable.shigeru_kawai_piano2,
            R.drawable.shigeru_kawai_piano3, R.drawable.steinway_sons_piano1,
            R.drawable.steinway_sons_piano2, R.drawable.steinway_sons_piano3,
            R.drawable.steingraeber_sohne_piano1, R.drawable.steingraeber_sohne_piano2,
            R.drawable.steingraeber_sohne_piano3, R.drawable.yamaha_piano1, R.drawable.yamaha_piano2,
            R.drawable.yamaha_piano3, R.drawable.makala_ukulele1, R.drawable.makala_ukulele2,
            R.drawable.makala_ukulele3, R.drawable.kala_ukulele_1, R.drawable.kala_ukulele_2,
            R.drawable.kala_ukulele_3, R.drawable.donner_ukulele_1, R.drawable.donner_ukulele_2,
            R.drawable.donner_ukulele_3, R.drawable.lohanu_ukulele_1, R.drawable.lohanu_ukulele_2,
            R.drawable.lohanu_ukulele_3, R.drawable.hricane_ukulele_1, R.drawable.hricane_ukulele_2,
            R.drawable.hricane_ukulele_3, R.drawable.pomaikai_ukulele1, R.drawable.pomaikai_ukulele2,
            R.drawable.pomaikai_ukulele3, R.drawable.fender_ukulele_1, R.drawable.fender_ukulele_2,
            R.drawable.fender_ukulele_3, R.drawable.lanikai_ukulele_1, R.drawable.lanikai_ukulele_2,
            R.drawable.lanikai_ukulele_3, R.drawable.mahalo_ukulele1, R.drawable.mahalo_ukulele2,
            R.drawable.mahalo_ukulele3, R.drawable.kapono_ukulele_1, R.drawable.kapono_ukulele_2,
            R.drawable.kapono_ukulele_3, R.drawable.tama_drums1, R.drawable.tama_drums2,
            R.drawable.tama_drums3, R.drawable.dw_drums_1, R.drawable.dw_drums_2, R.drawable.dw_drums_3,
            R.drawable.yamaha_drums1, R.drawable.yamaha_drums2, R.drawable.yamaha_drums3,
            R.drawable.sonor_drums1, R.drawable.sonor_drums2, R.drawable.sonor_drums3,
            R.drawable.pearl_drums1, R.drawable.pearl_drums2, R.drawable.pearl_drums3,
            R.drawable.ludwig_drums_1, R.drawable.ludwig_drums_2, R.drawable.ludwig_drums_3,
            R.drawable.gretsch_drums_1, R.drawable.gretsch_drums_2, R.drawable.gretsch_drums_3,
            R.drawable.canopus_drums_1, R.drawable.canopus_drums_2, R.drawable.canopus_drums_3,
            R.drawable.noble_cooley_drums1, R.drawable.noble_cooley_drums2,
            R.drawable.noble_cooley_drums3, R.drawable.british_drum_company_drums_1,
            R.drawable.british_drum_company_drums_2, R.drawable.british_drum_company_drums_3};

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
            int k = 0;
            while (j < i + 3) {
                images3[k] = images[j];
                j++;
                k++;
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
            int k = 0;
            while (j < i + 3) {
                images3[k] = images[j];
                j++;
                k++;
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
            int k = 0;
            while (j < i + 3) {
                images3[k] = images[j];
                j++;
                k++;
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
            int k = 0;
            while (j < i + 3) {
                images3[k] = images[j];
                j++;
                k++;
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
            int k = 0;
            while (j < i + 3) {
                images3[k] = images[j];
                j++;
                k++;
            }
            Drum drum = new Drum(title, price, brand, colour,
                    condition, location, description, id, images3);
            drums.add(drum);
        }
        return drums;
    }

}