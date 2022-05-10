package domein;

public class DomeinController {

    private SpelerRepository spelerRepo;
    // Database databank;

    public DomeinController() {
        spelerRepo = new SpelerRepository();
    }

    public Speler registreerSpeler(String gebruikersnaam, int geboortejaar) {
        Speler speler = new Speler(gebruikersnaam, geboortejaar);

        spelerRepo.voegSpelerToe(speler);
        return speler;
    }
    
    //public int selecteerSpeler(String gebruikersnaam, int geboortejaar) {
    	
    //}
    
    
}
