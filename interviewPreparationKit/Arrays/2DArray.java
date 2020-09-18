import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class 2DArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int sum[]= new int[16];
        int k=0;
        for(int a=0;a<4;a++) {
            for(int b=0;b<4;b++) {
                sum[k] = arr[a][b]+arr[a][b+1]+arr[a][b+2]+arr[a+1][b+1]+arr[a+2][b+1]+arr[a+2][b+2]+arr[a+2][b];
                k++;
            }
        }
        Arrays.sort(sum);
        return sum[sum.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
