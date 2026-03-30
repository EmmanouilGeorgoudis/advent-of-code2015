package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    //AoC2015 uppgift 1a
    public static int getFinalFloor(String input) {
        int floor = 0;

        for (int i = 0; i < input.length() ; i++) {
            char c = input.charAt(i);
            if (c == '(') {
                floor++;
            } else if (c == ')') {
                floor--;
            }
        }
        return floor;
    }

    //AoC2015 uppgift 1b
    public static int findFirstBasementPosition(String input) {
        int floor = 0;

        for (int i = 0; i < input.length() ; i++) {
            char c = input.charAt(i);
            if (c == '(') {
                floor++;
            } else if (c == ')') {
                floor--;
            }

            if (floor == -1)
                return i + 1;
        }

        return -1;
    }




    public static void main(String[] args) {

        Path path = Paths.get("src/day1/AoCdataDay1");

        String data = "";
        try {
            data = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(getFinalFloor(data));
        System.out.println(findFirstBasementPosition(data));
    }
}