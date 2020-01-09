import java.util.Scanner;
public class recursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFactorial(n));
    }

    private static long getFactorial(int n) {
        if (n==1){
            return 1;
        }
        return n*getFactorial(n-1);
    }
}
