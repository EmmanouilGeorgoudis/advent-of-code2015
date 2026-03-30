package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
I den här uppgiften har jag utvecklat 3b-metoden till att arbeta dynamiskt genom att ta in antal arbetare
(oavsett om det är människor eller robotar) som parametrar. Den ersätter 3a eftersom den även löser den uppgiften.
Det väcker dock frågan om separation of concerns, vilket jag i nuläget inte ser som problematiskt.
Intressant är att Kotlin stödjer default-parametrar, vilket gör att detta inte ens blir en fråga där.
 */

public class Main {

    //AoC2015 uppgift 3a+b
    public static int countUniqueVisits(String input, int amountOfWorkers) {
        return (int) collectWorkerVisits(input, amountOfWorkers).stream()
                .distinct()
                .count();
    }

    private static List<String> collectWorkerVisits(String input, int amountWorkers) {
        List<String> coordinates = new ArrayList<>();

        for (int i = 0; i < amountWorkers; i++) {
            List<String> workerCoords = getWorkerVisits(input, i, amountWorkers);
            coordinates.addAll(workerCoords);
        }
        return coordinates;
    }

    private static List<String> getWorkerVisits(String input, int startIndex, int amountOfWorkers) {
        List<String> coordinates = new ArrayList<>();
        int x = 0; int y = 0;

        coordinates.add("0,0");

        for (int i = startIndex; i < input.length(); i+=amountOfWorkers) {
            char direction = input.charAt(i);
            switch (direction) {
                case '>' -> x++;
                case '<' -> x--;
                case '^' -> y++;
                case 'v' -> y--;
            }
            coordinates.add(x + "," + y);
        }
        return coordinates;
    }




    public static void main(String[] args) {

        Path path = Paths.get("src/day3/AoCdataDay3");

        String data = "";
        try {
            data = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //AoCDay3a
        System.out.println(countUniqueVisits(data, 1));
        //AoCDay3b
        System.out.println(countUniqueVisits(data, 2));
    }
}