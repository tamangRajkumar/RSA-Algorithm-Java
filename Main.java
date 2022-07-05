
import java.util.*;

class Main {

    public static void main(String[] args) {
        int p1 = 2;

        int p2 = 7;
        int n = p1 * p2; // value 14
        System.out.println("value of n is " + n);

        int m = (p1 - 1) * (p2 - 1); // value 6
        System.out.println("value of m is " + m);

        // take key\
        int key = 0;
        System.out.println("Enter key");
        Scanner sc = new Scanner(System.in);
        key = sc.nextInt();
        System.out.println("Value=>" + key);

        // choose the value of e where hcf of e and n is 1
        int noHCF = 0;
        while (noHCF == 0) {
            for (int i = 2; i <= key || i <= n; i++) {
                if (key % i == 0 && n % i == 0) {

                    System.out.println("Choose another key");
                    // take key\
                    System.out.println("Enter key");
                    Scanner input = new Scanner(System.in);
                    key = input.nextInt();

                    System.out.println("Value=>" + key);

                }
                noHCF = 1;

            }
            System.out.println("npHCF=> " + noHCF);
            System.out.println(key + " " + m + " " + n);
            gcd(key, m, n);

        }
    }

    public static void gcd(int key, int m, int n) {
        System.out.println("Gcd method");
        LinkedList<Integer> wholeNumList = new LinkedList<Integer>();
        for (int j = 10; j <= 20; j++) {
            double d = (1 + j * m) / key;
            // System.out.println(d + "," + n);
            if ((d % 1) == 0) {
                System.out.println(d + "," + n);

                wholeNumList.push((int) d);
            }
        }
        int wholeNumChoose = wholeNumList.getFirst();
        System.out.println("choosed whole number list last number => " + wholeNumChoose);

        System.out.println("Public Key is: " + wholeNumChoose + "," + n);
    }
}