import java.util.Scanner;

public class EscapeTheMatrix {
    public static void main(String[] args) {
        char[][] labirinto = {
                {'S', '-', '-', '#', '-', '-', '#'},
                {'#', '#', '-', '-', '-', '-', '#'},
                {'-', '#', '#', '#', '#', '-', '#'},
                {'-', '-', '#', '-', '-', '-', '#'},
                {'-', '#', '#', '-', '-', '-', 'E'},
        };

        char simboloGiocatore = 'G';
        int rigaGiocatore = 0;
        int colonnaGiocatore = 0;

        System.out.println("Benvenuto al gioco \"Escape the Matrix\"");
        System.out.println("Muoviti utilizzando i tasti W (sopra), A (sinistra), S (sotto), D (destra)");

        stampaLabirinto(labirinto, simboloGiocatore, rigaGiocatore, colonnaGiocatore);

        Scanner scanner = new Scanner(System.in);
        boolean uscitaTrovata = false;
        while(!uscitaTrovata){
            System.out.print("Inserisci mossa: ");
            String mossa = scanner.nextLine().toLowerCase();

            switch (mossa){
                case "w": if(rigaGiocatore>0 && labirinto[rigaGiocatore-1][colonnaGiocatore]!='#') rigaGiocatore--;
                    break;
                case "a":  if(colonnaGiocatore>0 && labirinto[rigaGiocatore][colonnaGiocatore-1]!='#') colonnaGiocatore--;
                    break;
                case "s": if(rigaGiocatore< labirinto.length -1  && labirinto[rigaGiocatore+1][colonnaGiocatore]!='#') rigaGiocatore++;
                    break;
                case "d":  if(colonnaGiocatore<labirinto[0].length  && labirinto[rigaGiocatore][colonnaGiocatore+1]!='#') colonnaGiocatore++;
                    break;
                default:
                    System.out.println("Mossa non valida...");
                    break;
            }
            stampaLabirinto(labirinto, simboloGiocatore, rigaGiocatore, colonnaGiocatore);
            if(labirinto[rigaGiocatore][colonnaGiocatore]=='E'){
                uscitaTrovata = true;
                System.out.println("Morfeus è orgoglioso di te!");
            }
        }
    }

    private static void stampaLabirinto(char[][] labirinto, char simboloGiocatore, int rigaGiocatore, int colonnaGiocatore) {
        for(int i=0; i<labirinto.length; i++){
            for(int j=0; j<labirinto[0].length; j++){
                if(i==rigaGiocatore && j==colonnaGiocatore && labirinto[i][j] !='S' && labirinto[i][j] !='E')
                    System.out.print(simboloGiocatore);
                else System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
