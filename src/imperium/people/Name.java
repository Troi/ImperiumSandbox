package imperium.people;

import java.util.Random;

public final class Name {

    private static String[] maleNames = new String[]{
            "Fausto",
            "Carol",
            "Gene",
            "Gerard",
            "Jacques",
            "Jospeh",
            "Clair",
            "Hai",
            "Adolph",
            "Joel",
            "Alfonso",
            "Bennie",
            "Antione",
            "Lance",
            "Florencio",
            "Austin",
            "Tyree",
            "Winston",
            "Aubrey",
            "Deangelo",
            "Augustine",
            "Felix",
            "Lester",
            "Clay",
            "Hayden",
            "Tristan",
            "Wilford",
            "Kristofer",
            "Kenny",
            "Ramiro",
            "Fredrick",
            "Darrin",
            "Stan",
            "Esteban",
            "Rudy",
            "Jefferey",
            "Leon",
            "Porter",
            "Edwin",
            "Williams",
            "Chuck",
            "Franklin",
            "Harry",
            "Terrell",
            "Todd",
            "Emanuel",
            "Garfield",
            "Byron",
            "Luther",
            "Nolan"
    };
    private static String[] femaleNames = new String[]{
            "Pearlene",
            "Genoveva",
            "Florentina",
            "Carmina",
            "Sherise",
            "Maisha",
            "Penni",
            "Reagan",
            "Thresa",
            "Tama",
            "Jesenia",
            "Shonta",
            "Leta",
            "Particia",
            "Alita",
            "Pamula",
            "Karma",
            "Mavis",
            "Blanche",
            "Collene",
            "Krystle",
            "Dominica",
            "Jonell",
            "Bertie",
            "Alyson",
            "Sheilah",
            "Darline",
            "Willia",
            "Skye",
            "Ana",
            "Vernia",
            "Etsuko",
            "Madalene",
            "Miranda",
            "Fay",
            "Whitley",
            "Aleen",
            "Melynda",
            "Allyn",
            "Cleotilde",
            "Temika",
            "Salena",
            "Spring",
            "Felecia",
            "Kyoko",
            "Obdulia",
            "Tracie",
            "Elia",
            "Rochelle",
            "Eileen"
    };

    public static String getRandomMaleName() {
        Random rnd = new Random();
        return maleNames[rnd.nextInt(maleNames.length - 1)];
    }


    public static String getRandomFemaleName() {
        Random rnd = new Random();
        return femaleNames[rnd.nextInt(femaleNames.length - 1)];
    }

}
