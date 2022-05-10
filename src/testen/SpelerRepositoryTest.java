package testen;

import java.util.ArrayList;
import java.util.List;

import domein.PlayerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.Speler;
import domein.SpelerRepository;

public class SpelerRepositoryTest {//@before & @after methoden toevoegen
	
	private SpelerRepository testRepo;
	
	public SpelerRepositoryTest() {

	}
	
	@Test
	public void maakSpelerRepositoryTest() {
		testRepo = new SpelerRepository();
		Assertions.assertNotNull(testRepo);
	}
	
	@Test
	public void voegSpelerToeTest() throws Exception {//speler toevoegen, opvragen, verwijderen in een methode
		testRepo = new SpelerRepository();
		Speler testSpeler = new Speler("tester", 2000);
		List<Speler> testSpelerList = new ArrayList<Speler>();
		testSpelerList.add(testSpeler);
		
		testRepo.voegSpelerToe(testSpeler);
		
		Assertions.assertEquals(testSpeler, testRepo.getSpelerByUsername("tester"));


		Assertions.assertEquals(testSpelerList, testRepo.geefSpelerLijst());
		
		testRepo.verwijderSpeler("tester");
		Assertions.assertTrue(testRepo.geefSpelerLijst().isEmpty());
	}
	
	@Test
	public void duplicatePlayerTest() {
		testRepo = new SpelerRepository();
		Speler testSpeler = new Speler("Chadwick", 1969);
		
		testRepo.voegSpelerToe(testSpeler);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {testRepo.voegSpelerToe(testSpeler);});
	}
	
	@Test
	public void verwijderOnbestaandeSpelerTest() {
		testRepo = new SpelerRepository();
		
		Assertions.assertThrows(Exception.class, () -> {
			testRepo.verwijderSpeler("Brodie");
		});
	}
	

}