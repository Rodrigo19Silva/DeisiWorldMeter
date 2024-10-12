package pt.ulusofona.aed.deisiworldmeter;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestCountRegions {
    @Test
    public void countRegions() {
        if (Main.parseFiles(new File("test-files/countRegions"))) {
            Result result = Main.execute("COUNT_REGIONS Andorra");
            assertNotNull(result);
            assertTrue(result.success);
            String[] resultParts = result.result.split("\n");
            assertArrayEquals(new String[]{
                    "5"
            }, resultParts);
            result = Main.execute("COUNT_REGIONS asdghda");
            assertNotNull(result);
            assertTrue(result.success);
            resultParts = result.result.split("\n");
            assertArrayEquals(new String[]{
                    "-1"
            }, resultParts);
        }else {
            fail("Ficheiro não encontrado");
        }
    }
}
