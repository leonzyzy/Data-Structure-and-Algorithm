package structure.implement.linear_structure.SparseArray;

public class SparseArray {
    public static void main(String[] args) {
        // define a original 2D array with size 11*11
        // 0: no data, 1: data A, 2: data B
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][4] = 2;
        // print 2D array
        for (int[] row: chessArray) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("After transfer");

        // translate 2D array into sparse array
        // iterate 2D array, find non-zero data
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray.length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        // define a sparse array
        int sparseArray[][] = new int[sum+1][3];

        // assign data into sparse array
        // first row
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray.length;
        sparseArray[0][2] = sum;

        // store data into sparse array
        int count = 0; // record the row of non-zero data
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray.length; j++) {
                if (chessArray[i][j] != 0) {
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        // print sparse array
        for (int[] row: sparseArray) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // transfer sparse array into chess array
        int twoDArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            twoDArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // transfer back
        System.out.println("transfer back");
        // print 2D array
        for (int[] row: twoDArray) {
            for (int data: row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
