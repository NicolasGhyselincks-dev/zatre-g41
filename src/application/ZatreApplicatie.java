package application;

import domein.DomeinController;

import java.util.Scanner;

public class ZatreApplicatie {
    public static void main(String[] args) {
        int keuze = 0;
        int huidigJaar = 2022;

        Scanner input = new Scanner(System.in);
        DomeinController dc = new DomeinController();

        

        String gebruikersnaam = null;
        
        do {
        	System.out.print("Wenst u zich te registreren (=1) of in te loggen (=2)? ");

            while (!input.hasNextInt()) {
            	String in = input.next();
            	System.out.printf("\"%s\" is geen geldige keuze\n", in);
            }
            
            keuze = input.nextInt();
        } while (keuze != 1 && keuze != 2);
        
        int geboortejaar = 0;
        if (keuze == 1) {
            gebruikersnaam = "";
            geboortejaar = 0;

            System.out.print("Wat is je gebruikersnaam? ");
            gebruikersnaam = input.next();

            if (gebruikersnaam == "" || gebruikersnaam == " ")
                throw new IllegalArgumentException(String.format("Gebruikersnaam is verplicht!"));

            if (gebruikersnaam.length() < 5) {
                throw new IllegalArgumentException(String.format("Je gebruikersnaam moet minstens 5 karakters lang zijn!"));
            }

            //System.out.print("Wat is je geboortejaar? ");
            //geboortejaar = input.nextInt();
            
            boolean juisteGeboorteJaar = false;
            do {
            	System.out.print("Wat is je geboortejaar? ");
            	
            	while (!input.hasNextInt()) {
            		String inp = input.next();
            		System.out.printf("\"%s\" is geen geldige input\n", inp);
            	}
            	
            	geboortejaar = input.nextInt();
            	
            } while (geboortejaar == 0);
            
            

            if (geboortejaar == 0)
                throw new IllegalArgumentException(String.format("Geboortejaar is verplicht!"));

            if (!(2022 - geboortejaar >= 6))
                throw new IllegalArgumentException(String.format("Je moet minstens 6 jaar of 6 jaar worden in het lopende jaar om te kunnen registreren!"));

            
            
            dc.registreerSpeler(gebruikersnaam, geboortejaar);
            
            System.out.printf("Gebruiker %s met geboortedatum %d werd succesvol geregistreerd!", gebruikersnaam, geboortejaar);
        }

        if (keuze == 2) {
            System.out.print("Wat is je gebruikersnaam? ");
            gebruikersnaam = input.next();

            System.out.print("Wat is je geboortejaar? ");
            geboortejaar = input.nextInt();

            
            // speelkansen tonen + enkel selecteren met speelkansen
            System.out.printf("je hebt succesvol speler %s met geboortejaar %d geselecteerd!", gebruikersnaam, geboortejaar);
        }

        if (keuze != 1 && keuze != 2)
            throw new IllegalArgumentException(String.format("Dit is geen geldige actie"));

        
        // Momenteel nog de fout in SpelerRepo, zit zogezegd al in de lijst...
    }
}
