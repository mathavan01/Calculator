import java.util.*;
public class Determinant{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What size is the square matrix? (Minimum 2*2)");
        int d = s.nextInt();
        int[][] matrix = new int[d][d];
        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++){
                System.out.println("Enter a value:");
                matrix[i][j] = s.nextInt();
                for (int k = 0; k < d; k++){
                    for (int l = 0; l < d; l++){
                        System.out.print(matrix[k][l] + "\t");
                    }
                    System.out.println();
                }
            }
        }
        int det = 0;
        if (d == 2){
            det = (matrix[0][0] * matrix[1][1]) / (matrix[0][1] * matrix[1][0]);
        } else {
            int left_right = 0;
            int right_left = 0;
            int temp = 1;
            int[][] new_matrix = new int[d][2 * d - 1];
            for (int i = 0; i < d; i++){
                for (int j = 0; j < 2 * d - 1; j++){
                    new_matrix[i][j] = matrix[i][j % d];
                }
            }
            for (int i = 0; i < d; i++){
                for (int j = 0; j < d; j++){
                    temp *= new_matrix[j][i + j];
                }
                left_right += temp;
                temp = 1;
            }
            for (int i = 2 * d - 2; i >= d - 1; i--){
                for (int j = 0; j < d; j++){
                    temp *= new_matrix[j][i - j];
                }
                right_left += temp;
                temp = 1;
            }
            det = left_right - right_left;
        }
        System.out.println("Determinant: " + det);
    }
}
