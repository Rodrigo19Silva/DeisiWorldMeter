package pt.ulusofona.aed.deisiworldmeter;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestGetDensity {
    @Test
    public void getDensity() {
        if (Main.parseFiles(new File("test-files/getDensity"))) {
            Result result = Main.execute("GET_DENSITY_BELOW 1000 Andorra");
            assertNotNull(result);
            assertTrue(result.success);
            String[] resultParts = result.result.split("\n");
            assertArrayEquals(new String[]{
                    "2020 - 962.054"
            }, resultParts);
            result = Main.execute("GET_DENSITY_BELOW 10000 Alemanha");
            assertNotNull(result);
            assertTrue(result.success);
            resultParts = result.result.split("\n");
            assertArrayEquals(new String[]{
                    "2022 - 1154.92","2021 - 1104.078",
                    "2020 - 1055.186"
            }, resultParts);
        }else {
            fail("Ficheiro não encontrado");
        }
    }
}
