package testen;
import domein.Speler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpelerTest {

    @Test
    public void maakSpelerAan_legeGebruikersnaam_retourneertFalse() {
        Speler testSpeler;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Speler("", 2001);});
    }

    @Test
    public void maakSpelerAan_leegGeboortejaar_retourneertFalse() {
        Speler testSpeler;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Speler("Test", 0);});
    }

    @Test
    public void maakSpelerAan_teJong_retourneertFalse() {
        Speler testSpeler;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Speler("Test", 2020);});
    }

    @Test
    public void maakSpelerAan_oudGenoeg_retourneertTrue() {
        Speler testSpeler = new Speler("Test", 2001);

        boolean res = 2022 - testSpeler.getGeboortejaar() >= 6;
        assertTrue(res);

    }

    @Test
    public void maakSpelerAan_gebruikersnaamNietLangGenoeg_retourneertFalse() {
        Speler testSpeler;
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Speler("Bob", 2020);});
        
    }

    @Test
    public void maakSpelerAan_gebruikersnaamLangGenoeg_retourneertTrue() {
        Speler testSpeler = new Speler("Nicolas", 2001);

        boolean res = testSpeler.getGebruikersnaam().length() >= 5;

        assertTrue(res);


    }


}