import java.util.Scanner;

public class IndovinaIlNumero {
    public static void main(String[] args) {

        // Il bot sceglierà un numero casuale compreso tra 1 e 100
        // il giocatore dve indovinarlo

        // Uso math.random per generare un numero casuale

        // [0; 1[
        // 0 e 0.99999999 * 100 -> -99.999999 ->
        int numeroRandom = (int)(Math.random() * 100)+ 1;
        // System.out.println(numeroRandom); // per il debug
        System.out.println("Benvenuto a gioco 'Indovina il numero'!");
        System.out.println("Ho scelto un numero tara 1 e 100, riesci ad indovinarlo?");

        // variabile tiene il conto dei tentativi del giocatore
        int numeroTentativi = 0;

        Scanner scanner = new Scanner(System.in);
        int numGiocatore;

        do {
            System.out.print("Fai un tentativo: ");
            numGiocatore = scanner.nextInt();
            if(numGiocatore<=0 || numGiocatore > 100){
                System.out.println("Il numero che hai inserito non è nel  range 1 - 100");
                continue;
            }
            numeroTentativi++;

            if(numeroRandom == numGiocatore) System.out.println("Bravo hai indovinato in " + numeroTentativi + (numeroTentativi>1 ? " tentativi" : " tentativo"));
            else if (numGiocatore > numeroRandom) System.out.println("Troppo grande!");
            else System.out.println("Troppo piccolo!");

        } while(nonHaiIndovinato(numeroRandom, numGiocatore));

    }

    private static boolean nonHaiIndovinato(int numeroRandom, int numeroGiocatore) {

        return numeroRandom!=numeroGiocatore;
    }
 }
