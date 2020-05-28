// The InstrumentProvider class simulates fetching data from our static 'database' of 50
// instruments (10 instruments per category/sub-category).

import com.example.instrument_app.R;

import java.util.ArrayList;
import java.util.Arrays;

public class InstrumentProvider {

    // Titles
    static String[] titles = {
            "Fender Acoustic Guitar","Gibson Acoustic Guitar","Takamine Acoustic Guitar",
            "Taylor Acoustic Guitar","Martin Acoustic Guitar","Guild Acoustic Guitar",
            "Seagull Acoustic Guitar","Yamaha Acoustic Guitar","Ovation Acoustic Guitar",
            "Washburn Acoustic Guitar",
            "Fender Electric Guitar","Gibson Electric Guitar","LTD Electric Guitar",
            "PRS Electric Guitar","Gretsch Electric Guitar","Guild Electric Guitar",
            "Jackson Electric Guitar","Yamaha Electric Guitar","Vintage Electric Guitar",
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
            "Washburn","Fender","Gibson","LTD","PRS","Gretsch","Guild","Jackson",
            "Yamaha","Vintage","Washburn","C.Bechstein","Bluthner","Bosendorfer","FAZIOLI",
            "Grotrian-Steinweg","Sauter","Shigeru Kawai","Steinway & Sons","Steingraeber & Sohne","Yamaha",
            "Makala","Kala","Donner","Lohanu","Hricane","Pomaikai","Fender","Lanikai", "Mahalo",
            "Kapono","Tama","DW","Yamaha","Sonor", "Pearl","Ludwig","Gretsch","Canopus","Noble & Cooley",
            "British Drum Company"
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
    static int[] images = {R.drawable.FenderAcoustic1, R.drawable.FenderAcoustic2,
            R.drawable.FenderAcoustic3, R.drawable.GibsonAcoustic1, R.drawable.GibsonAcoustic2,
            R.drawable.GibsonAcoustic3, R.drawable.TakamineAcoustic1, R.drawable.TakamineAcoustic2,
            R.drawable.TakamineAcoustic3, R.drawable.TaylorAcoustic1, R.drawable.TaylorAcoustic2,
            R.drawable.TaylorAcoustic3, R.drawable.MartinAcoustic1, R.drawable.MartinAcoustic2,
            R.drawable.MartinAcoustic3, R.drawable.GuildAcoustic1, R.drawable.GuildAcoustic2,
            R.drawable.GuildAcoustic3, R.drawable.SeagullAcoustic1, R.drawable.SeagullAcoustic2,
            R.drawable.SeagullAcoustic3, R.drawable.YamahaAcoustic1, R.drawable.YamahaAcoustic2,
            R.drawable.YamahaAcoustic3, R.drawable.OvationAcoustic1, R.drawable.OvationAcoustic2,
            R.drawable.OvationAcoustic3, R.drawable.WashburnAcoustic1, R.drawable.WashburnAcoustic2,
            R.drawable.WashburnAcoustic3, R.drawable.FenderElectric1, R.drawable.FenderElectric2,
            R.drawable.FenderElectric3, R.drawable.GibsonElectric1, R.drawable.GibsonElectric2,
            R.drawable.GibsonElectric3, R.drawable.LTDElectric1, R.drawable.LTDElectric2,
            R.drawable.LTDElectric3, R.drawable.PRSElectric1, R.drawable.PRSElectric2,
            R.drawable.PRSElectric3, R.drawable.GretschElectric1, R.drawable.GretschElectric2,
            R.drawable.GretschElectric3, R.drawable.GuildElectric1, R.drawable.GuildElectric2,
            R.drawable.GuildElectric3, R.drawable.JacksonElectric1, R.drawable.JacksonElectric2,
            R.drawable.JacksonElectric3, R.drawable.YamahaElectric1, R.drawable.YamahaElectric2,
            R.drawable.YamahaElectric3, R.drawable.VintageElectric1, R.drawable.VintageElectric2,
            R.drawable.VintageElectric3, R.drawable.WashburnElectric1, R.drawable.WashburnElectric2,
            R.drawable.WashburnElectric3, R.drawable.C_BechsteinPiano1,
            R.drawable.C_BechsteinPiano2, R.drawable.C_BechsteinPiano3, R.drawable.BluthnerPiano1,
            R.drawable.BluthnerPiano2, R.drawable.BluthnerPiano3, R.drawable.BosendorferPiano1,
            R.drawable.BosendorferPiano2, R.drawable.BosendorferPiano3, R.drawable.FAZIOLIPiano1,
            R.drawable.FAZIOLIPiano2, R.drawable.FAZIOLIPiano3, R.drawable.GrotrianSteinwegPiano1,
            R.drawable.GrotrianSteinwegPiano2, R.drawable.GrotrianSteinwegPiano3,
            R.drawable.SauterPiano1, R.drawable.SauterPiano2, R.drawable.SauterPiano3,
            R.drawable.ShigeruKawaiPiano1, R.drawable.ShigeruKawaiPiano2,
            R.drawable.ShigeruKawaiPiano3, R.drawable.Steinway_SonsPiano1,
            R.drawable.Steinway_SonsPiano2, R.drawable.Steinway_SonsPiano3,
            R.drawable.Steingraeber_SohnePiano1, R.drawable.Steingraeber_SohnePiano2,
            R.drawable.Steingraeber_SohnePiano3, R.drawable.YamahaPiano1, R.drawable.YamahaPiano2,
            R.drawable.YamahaPiano3, R.drawable.MakalaUkulele1, R.drawable.MakalaUkulele2,
            R.drawable.MakalaUkulele3, R.drawable.KalaUkulele1, R.drawable.KalaUkulele2,
            R.drawable.KalaUkulele3, R.drawable.DonnerUkulele1, R.drawable.DonnerUkulele2,
            R.drawable.DonnerUkulele3, R.drawable.LohanuUkulele1, R.drawable.LohanuUkulele2,
            R.drawable.LohanuUkulele3, R.drawable.HricaneUkulele1, R.drawable.HricaneUkulele2,
            R.drawable.HricaneUkulele3, R.drawable.PomaikaiUkulele1, R.drawable.PomaikaiUkulele2,
            R.drawable.PomaikaiUkulele3, R.drawable.FenderUkulele1, R.drawable.FenderUkulele2,
            R.drawable.FenderUkulele3, R.drawable.LanikaiUkulele1, R.drawable.LanikaiUkulele2,
            R.drawable.LanikaiUkulele3, R.drawable.MahaloUkulele1, R.drawable.MahaloUkulele2,
            R.drawable.MahaloUkulele3, R.drawable.KaponoUkulele1, R.drawable.KaponoUkulele2,
            R.drawable.KaponoUkulele3, R.drawable.TamaDrums1, R.drawable.TamaDrums2,
            R.drawable.TamaDrums3, R.drawable.DWDrums1, R.drawable.DWDrums2, R.drawable.DWDrums3,
            R.drawable.YamahaDrums1, R.drawable.YamahaDrums2, R.drawable.YamahaDrums3,
            R.drawable.SonorDrums1, R.drawable.SonorDrums2, R.drawable.SonorDrums3,
            R.drawable.PearlDrums1, R.drawable.PearlDrums2, R.drawable.PearlDrums3,
            R.drawable.LudwigDrums1, R.drawable.LudwigDrums2, R.drawable.LudwigDrums3,
            R.drawable.GretschDrums1, R.drawable.GretschDrums2, R.drawable.GretschDrums3,
            R.drawable.CanopusDrums1, R.drawable.CanopusDrums2, R.drawable.CanopusDrums3,
            R.drawable.Noble_CooleyDrums1, R.drawable.Noble_CooleyDrums2,
            R.drawable.Noble_CooleyDrums3, R.drawable.BritishDrumCompanyDrums1,
            R.drawable.BritishDrumCompanyDrums2, R.drawable.BritishDrumCompanyDrums3};

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
