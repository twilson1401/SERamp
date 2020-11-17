import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {

        // this checks to see if it is even possible for Kangaroo 1 to catch up.
        // Since Kangaroo 1 is already behind 2 at the start, if Kangaroo 2's speed is greater or equal, Kangaroo 1 will never catch up
        if (v2 >= v1) {
            return "NO";
        }

        // this loops through each jump to see whether it leads to the kangaroos occupying the same space. The key expression to weigh here is starting position + (distance travelled per jump * number of jumps)
        // it returns 'yes' when the values match - otherwise it continues looping through.
        else {
            for (int jump = 0; jump <= Integer.MAX_VALUE; jump++) {
                int positionKangaroo1 = x1 + (jump * v1);
                int positionKangaroo2 = x2 + (jump * v2);
                if (positionKangaroo1 == positionKangaroo2) {
                    return "YES";
                }

            }

            // You will note that I have invoked the max integer value as the upper limit of the jumps.
            // This is a problem - not only is it arbitrary as a limit, it is also liable to make the process time out, or stretch performance by looping through so many numbers.
            // I will try to solve this by finding a more elegant expression of the conditional logic, which will allow us to test a greater number of jumps, whilst improving performance at high jump values.
            // My suspicion is that this could involve expressing the inputs as an equation and working out the divisibility.

        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



