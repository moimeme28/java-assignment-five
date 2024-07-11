public class StrassenMatrixMultiplication {

    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;
        
        // Base case
        if (n == 1) {
            int[][] result = { { A[0][0] * B[0][0] } };
            return result;
        }

        // Initialize result matrix
        int[][] result = new int[n][n];
        int newSize = n / 2;

        // Split matrices into quadrants
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];

        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        split(A, A11, 0, 0);
        split(A, A12, 0, newSize);
        split(A, A21, newSize, 0);
        split(A, A22, newSize, newSize);

        split(B, B11, 0, 0);
        split(B, B12, 0, newSize);
        split(B, B21, newSize, 0);
        split(B, B22, newSize, newSize);

        // Calculate the 7 products using Strassen's formulas
        int[][] M1 = strassenMultiply(add(A11, A22), add(B11, B22));
        int[][] M2 = strassenMultiply(add(A21, A22), B11);
        int[][] M3 = strassenMultiply(A11, subtract(B12, B22));
        int[][] M4 = strassenMultiply(A22, subtract(B21, B11));
        int[][] M5 = strassenMultiply(add(A11, A12), B22);
        int[][] M6 = strassenMultiply(subtract(A21, A11), add(B11, B12));
        int[][] M7 = strassenMultiply(subtract(A12, A22), add(B21, B22));

        // Compute the final submatrices
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Combine the final matrix
        join(C11, result, 0, 0);
        join(C12, result, 0, newSize);
        join(C21, result, newSize, 0);
        join(C22, result, newSize, newSize);

        return result;
    }