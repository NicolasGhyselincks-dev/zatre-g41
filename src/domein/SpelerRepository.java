package domein;

import java.util.*;

public class SpelerRepository {
	private Collection<Speler> spelers; //actieve spelers?
    private List<Speler> spelerList;

    public SpelerRepository() {
        spelerList = new ArrayList<Speler>();
    }

    public void voegSpelerToe(Speler speler) throws IllegalArgumentException {
        if(spelerList.isEmpty() || !spelerInLijst(speler)) {
            spelerList.add(speler);
        } else {
            throw new IllegalArgumentException("Speler zit al in de spelerlijst.");
        }
    }

    private boolean spelerInLijst(Speler speler){
        int i = 0;
        boolean bevat = false;
        while(bevat == false && i < spelerList.size()){
            if(speler.getGebruikersnaam().equals(spelerList.get(i).getGebruikersnaam()) && speler.getGeboortejaar() == spelerList.get(i).getGeboortejaar()){
                bevat = true;
            }
            i++;
        }
        return bevat;
    }

    public List<Speler> geefSpelerLijst() {
        return spelerList;
    }


    public Speler getSpelerByUsername(String username) throws PlayerNotFoundException{
        Speler returnPlayer = null;
        int i = 0;
        while(returnPlayer == null && i < spelerList.size()) {
            if (spelerList.get(i).getGebruikersnaam().equals(username)) { //juiste methode gebruiken
                returnPlayer = spelerList.get(i);
            }
            i++;
        }
        if(returnPlayer == null){
            throw new PlayerNotFoundException(String.format("Er werd geen speler met de naam %s gevonden.", username));
        }
        return returnPlayer;
    }

    public void verwijderSpeler(String username) throws Exception {
            spelerList.remove(getSpelerByUsername(username));
    }

}