package domein;

public class Speler {
	private String gebruikersnaam;
    private int geboortejaar;
    private int speelkansen = 5;


    public Speler(String gebruikersnaam, int geboortejaar) {
        setGebruikersnaam(gebruikersnaam);
        setGeboortejaar(geboortejaar);
    }

    private void setGebruikersnaam(String gebruikersnaam) {
        if (gebruikersnaam.length() >= 5)
            this.gebruikersnaam = gebruikersnaam;
        else 
        	throw new IllegalArgumentException(String.format("Gebruikersnaam is te kort!"));
    }

	public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    private void setGeboortejaar(int geboortejaar) {
        if (2022 - geboortejaar >= 6)
            this.geboortejaar = geboortejaar;
        else 
        	throw new IllegalArgumentException(String.format("Gebruiker moet 6 jaar zijn of 6 jaar worden in het huidige jaar!"));
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    private void setSpeelkansen(int speelkansen) {
        this.speelkansen = speelkansen;
    }

    public int getSpeelkansen() {
        return speelkansen;
    }
}

