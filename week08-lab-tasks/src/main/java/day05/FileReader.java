package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    private String solutionString;
    private int solutionInteger;
    private int min;

    void init(){
        solutionInteger = 0;
        solutionString = "";
        min = Integer.MAX_VALUE;
    }

    public int findSmallestTemperatureSpread(String filename) {
        init();
        List<String> contents = getContents(getPath(filename));
        List<Integer> exclusions = Arrays.asList(0, 1, 32);
        for (int i = 0; i < contents.size(); i++) {
            if (!exclusions.contains(i)) {
                setMinTemp(contents, i);
            }
        }
        return solutionInteger;
    }

    private void setMinTemp(List<String> contents, int i) {
        int day = getData(contents.get(i), 2, 4);
        int dailyMax = getData(contents.get(i), 6, 8);
        int dailyMin = getData(contents.get(i), 12, 14);
        if (dailyMax - dailyMin < min) {
            min = dailyMax - dailyMin;
            solutionInteger = day;
        }
    }

    private int getData(String s, int from, int to) {
        return Integer.parseInt(s.substring(from, to).trim());
    }

    private List<String> getContents(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException err) {
            throw new IllegalStateException("Error reading file.", err);
        }
    }

    public String findSmallestDifference(String filename) {
        init();
        List<String> contents = getContents(getPath(filename));
        List<Integer> exclusions = Arrays.asList(0, 18);
        for (int i = 0; i < contents.size(); i++) {
            if (!exclusions.contains(i)) {
                setMinDiff(contents, i);
            }
        }
        return solutionString;
    }

    private void setMinDiff(List<String> contents, int i) {
        int score = getData(contents.get(i), 43, 45);
        int got = getData(contents.get(i), 50, 52);
        if (Math.abs(score - got) < min) {
            min = Math.abs(score - got);
            solutionString = contents.get(i).substring(6, 23).trim();
        }
    }

    private Path getPath(String filename) {
        return Paths.get("src/main/resources/" + filename);
    }
}
