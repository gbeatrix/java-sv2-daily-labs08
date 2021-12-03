package day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    @Test
    void testFileReader(){
        String filename = "weather.dat";
        int result = new FileReader().findSmallestTemperatureSpread(filename);
        assertEquals(14, result);
    }

    @Test
    void testFileReaderFileNotExists(){
        IllegalStateException err = assertThrows(IllegalStateException.class,
                () -> new FileReader().findSmallestTemperatureSpread("filename"));
        assertEquals("Error reading file.", err.getMessage());
    }

    @Test
    void testFindSmallestDifference() {
        String filename = "football.dat";
        assertEquals("Aston_Villa", new FileReader().findSmallestDifference(filename));
    }

    @Test
    void testFindSmallestDifferenceFileNotExists(){
        IllegalStateException err = assertThrows(IllegalStateException.class,
                () -> new FileReader().findSmallestDifference("filename"));
        assertEquals("Error reading file.", err.getMessage());
    }
}