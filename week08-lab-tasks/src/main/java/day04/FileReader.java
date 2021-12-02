package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public int findSmallestTemperatureSpread(String pathString) {
        int min = Integer.MAX_VALUE;
        int dayOfMinTemp = -1;
        Path path = Paths.get("src/main/resources/" + pathString);
        List<String> contents;
        try {
            contents = Files.readAllLines(path);
        } catch (IOException err) {
            throw new IllegalStateException("Error reading file.", err);
        }
        for (int i = 2; i < 32; i++) {
            try {
                int day = Integer.parseInt(contents.get(i).substring(2, 4).trim());
                int dailyMax = Integer.parseInt(contents.get(i).substring(6, 8).trim());
                int dailyMin = Integer.parseInt(contents.get(i).substring(12, 14).trim());
                if(dailyMax - dailyMin < min){
                    min =dailyMax - dailyMin;
                    dayOfMinTemp = day;
                }
            } catch (NumberFormatException err) {
                throw new IllegalArgumentException("Invalid data.", err);
            }
        }
        return dayOfMinTemp;
    }
}
