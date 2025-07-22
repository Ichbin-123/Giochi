public class Matrici {
    public static void main(String[] args) {

        int numeroDiRighe = 3;
        int numeroColonne = 3;

        int[][] matrice = new int[numeroDiRighe][numeroColonne];

        int counter = 0;
        // Riempier la matrice
        for (int riga = 0; riga < matrice.length; riga++) {
            for (int colonna = 0; colonna < matrice[0].length; colonna++) {
                matrice[riga][colonna] = ++counter;
            }
        }

        //
        for(int i=0; i<matrice.length; i++){
            for(int j=0; j<matrice[0].length; j++){
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
    }
}
