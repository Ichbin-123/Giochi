import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Impiccato {
    public static void main(String[] args) {
        //
        String[] parole = {
                "Bulbasaur", "Ivysaur", "Venusaur",
                "Charmander", "Charmeleon", "Charizard",
                "Squirtle", "Wartortle", "Blastoise",
                "Caterpie", "Metapod", "Butterfree",
                "Weedle", "Kakuna", "Beedrill",
                "Pidgey", "Pidgeotto", "Pidgeot",
                "Rattata", "Raticate", "Spearow",
                "Fearow", "Ekans", "Arbok",
                "Pikachu", "Raichu"};

        Random random = new Random();
        int index = random.nextInt(parole.length);
        String parolaRandom = parole[index].toLowerCase();

        System.out.println(parolaRandom);

        char[] parola = parolaRandom.toCharArray();
        char[] progress = new char[parola.length];
        Arrays.fill(progress, '_');

        Scanner scanner = new Scanner(System.in);
        boolean indovinato = false;

        System.out.println("Benvenuto al gioco dell'impiccato");
        System.out.println("Scegli il livello di difficoltà");
        System.out.println("1. Facile");
        System.out.println("2. Medio");
        System.out.print("3. Difficile");
        System.out.println("Difficoltà: ");
        int difficolta = scanner.nextInt();
        int numTentativi;

        switch (difficolta) {
            case 1: numTentativi = parolaRandom.length() + 5;
                break;
            case 2: numTentativi = parolaRandom.length() + 3;
                break;
            case 3: numTentativi = parolaRandom.length();
                break;
            default:
                System.out.println("Livello non valido, impostato a Medio di default");
                numTentativi = parolaRandom.length() + 3;
        }
        System.out.println(numTentativi);

        String lettereInserite = "";

        while(numTentativi > 0 && !indovinato)
        {
            // Game Loop
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.next().toLowerCase().charAt(0);
            if(lettereInserite.contains(lettera + "")){
                System.out.println("Hai già inserito la lettera: " + lettera + ", riprova");
                continue;
            }
            lettereInserite += lettera;
            boolean trovato = false;

            for(int i=0; i< parola.length; i++){
                if(parola[i]== lettera ){

                    progress[i] = lettera;
                    trovato = true;
                }
            }

            if(trovato){
                System.out.println("Lettera presente: " + String.valueOf(progress));
            } else {
                System.out.println("Lettera sbagliata. Tentativi rimati: " + --numTentativi);
            }

            if(parolaRandom.equals(String.valueOf(progress))) indovinato = true;
        }

        if(indovinato) System.out.println("Complimenti, hai indovinato la parola: " + parolaRandom);
        else System.out.println("Hai perso, la parola era: " + parolaRandom);
    }
}
