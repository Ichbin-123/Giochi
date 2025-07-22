import java.util.Random;
import java.util.Scanner;

public class EscapeTheMatrix {
    public static void main(String[] args) {

        // Ci devono essre almeno due trattini consecutivi
        final int RIGHE = 5;
        final int COLONNE = 7;
        final double PERC_MURI = 0.5; // Trenta percento è muro

        char[][] labirinto = generaLabirintoRandom(RIGHE, COLONNE, PERC_MURI);

        // Labirinto di test
//        char[][] labirinto = {
//                {'S', '-', '-', '#', '-', '-', '#'},
//                {'S', '-', '-', '#', '-', '-', '#'},
//                {'#', '#', '-', '-', '-', '-', '#'},
//                {'-', '#', '#', '#', '#', '-', '#'},
//                {'-', '-', '#', '-', '-', '-', '#'},
//                {'-', '#', '#', '-', '-', '-', 'E'},
//        };


        char simboloGiocatore = 'G';
        int rigaGiocatore = 0;
        int colonnaGiocatore = 0;

        System.out.println("Benvenuto al gioco \"Escape the Matrix\"");
        System.out.println("Muoviti utilizzando i tasti W (sopra), A (sinistra), S (sotto), D (destra)");

        stampaLabirinto(labirinto, simboloGiocatore, rigaGiocatore, colonnaGiocatore);

        Scanner scanner = new Scanner(System.in);
        boolean uscitaTrovata = false;
        while (!uscitaTrovata) {
            System.out.print("Inserisci mossa: ");
            String mossa = scanner.nextLine().toLowerCase();

            switch (mossa) {
                case "w":
                    if (rigaGiocatore > 0 && labirinto[rigaGiocatore - 1][colonnaGiocatore] != '#') rigaGiocatore--;
                    else System.out.println("Hai preso er muro fratellì");
                    break;
                case "a":
                    if (colonnaGiocatore > 0 && labirinto[rigaGiocatore][colonnaGiocatore - 1] != '#')
                        colonnaGiocatore--;
                    else System.out.println("Hai preso er muro fratellì");
                    break;
                case "s":
                    if (rigaGiocatore < labirinto.length - 1 && labirinto[rigaGiocatore + 1][colonnaGiocatore] != '#')
                        rigaGiocatore++;
                    else System.out.println("Hai preso er muro fratellì");
                    break;
                case "d":
                    if (colonnaGiocatore < labirinto[0].length && labirinto[rigaGiocatore][colonnaGiocatore + 1] != '#')
                        colonnaGiocatore++;
                    else System.out.println("Hai preso er muro fratellì");
                    break;
                default:
                    System.out.println("Mossa non valida...");
                    break;
            }
            stampaLabirinto(labirinto, simboloGiocatore, rigaGiocatore, colonnaGiocatore);
            if (labirinto[rigaGiocatore][colonnaGiocatore] == 'E') {
                uscitaTrovata = true;
                System.out.println("Morfeus è orgoglioso di te!");
            }
        }
    }

    private static void stampaLabirinto(char[][] labirinto, char simboloGiocatore, int rigaGiocatore, int colonnaGiocatore) {
        System.out.println(String.format("Percentuale muri: %.2f%%", ritornaPercentualeMuri(labirinto)));
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (i == rigaGiocatore && j == colonnaGiocatore && labirinto[i][j] != 'S' && labirinto[i][j] != 'E')
                    System.out.print(simboloGiocatore);
                else System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static char[][] generaLabirintoRandom(int righe, int colonne, double percMuri) {
        char[][] lab = new char[righe][colonne];
        Random random = new Random();

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (i == 0 && j == 0) lab[i][j] = 'S';
                else if (i == righe - 1 && j == colonne - 1) lab[i][j] = 'E';
                else if ((i == 1 && j == 0) && lab[0][1] == '#') lab[i][j] = '-';
                else if ((i == righe - 1 && j == colonne - 2) && lab[righe - 2][colonne - 1] == '#') lab[i][j] = '-';
                else {
                    if (i > 0 && lab[i - 1][j] == '#') lab[i][j] = '-';
                    else if (j > 0 && lab[i][j - 1] == '#') lab[i][j] = '-';
                    else if (i > 1 && j < colonne - 2 && lab[i - 1][j + 1] == '#' && lab[i - 2][j + 2] == '#')
                        lab[i][j] = '-';
                    else if (i > 1 && j > 2 && lab[i - 1][j - 1] == '#' && lab[i - 2][j - 2] == '#') lab[i][j] = '-';
                    else lab[i][j] = random.nextDouble() < percMuri ? '#' : '-';
                }
            }
        }
        return lab;
    }

    private static double ritornaPercentualeMuri(char[][] labirinto) {
        double percentualeMuri = 0.0;
        double totaleCaselle = (labirinto.length * labirinto[0].length) - 2;
        int contatore = 0;

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if(labirinto[i][j]=='#') contatore++;
            }
        }
        percentualeMuri = contatore/totaleCaselle;

        return percentualeMuri;
    }
}
