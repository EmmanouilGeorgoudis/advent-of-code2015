package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //AoC2015 uppgift 2a
    public static int calculateWrappingPapper(String input) {
        Scanner scan = new Scanner(input);
        int totalFeetPapper = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] dimensions = line.split("x");

            int length = Integer.parseInt(dimensions[0]);
            int width = Integer.parseInt(dimensions[1]);
            int height = Integer.parseInt(dimensions[2]);

            int d1 = length * width;
            int d2 = width * height;
            int d3 = length * height;

            int surfaceNeeded = 2*d1 + 2*d2 + 2*d3 + (Math.min(d1,Math.min(d2, d3)));
            totalFeetPapper += surfaceNeeded;

        }
        return totalFeetPapper;
    }

    //AoC2015 uppgift 2b
    public static int calculateRibbon(String input) {
        Scanner scan = new Scanner(input);
        int totalRibbon = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("x");
            int[] dimensions = new int[3];

            for (int i = 0; i < parts.length; i++) {
                dimensions[i]= Integer.parseInt(parts[i]);
            }
            Arrays.sort(dimensions);

            int smallSide = dimensions[0];
            int mediumSide = dimensions[1];
            int bigSide = dimensions[2];

            int wrapRibbon = 2 * smallSide + 2 * mediumSide;
            int bowRibbon = smallSide * mediumSide * bigSide;

            totalRibbon += (bowRibbon + wrapRibbon);
        }
        return totalRibbon;
    }




    public static void main(String[] args) {

        Path path = Paths.get("src/day2/AoCdataDay2");

        String data = "";
        try {
            data = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(calculateWrappingPapper(data));
        System.out.println(calculateRibbon(data));
    }
}