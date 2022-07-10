
import java.util.*;
import java.math.*;

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
                    // take key
                    System.out.println("Enter key");
                    Scanner input = new Scanner(System.in);
                    key = input.nextInt();

                    System.out.println("Value=>" + key);
                    input.close();

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
            // System.out.println(j + "," + d);
            if ((d % 1) == 0) {
                // System.out.println(d + "," + n);
                wholeNumList.push((int) d);
            }
        }
        int wholeNumChoose = wholeNumList.getFirst();
        System.out.println("choosed whole number list last number => " + wholeNumChoose);
        // wholeNumChoose private key
        System.out.println("Private Key is: " + wholeNumChoose + "," + n);

        System.out.println("Public Key is : " + key + "," + n);

        System.out.println("Input your message");
        Scanner sc = new Scanner(System.in);
        int plainText = sc.nextInt();
        encryptText(plainText, key, n, wholeNumChoose);
        // math.pow(plainText,key)%n

        // decrypt(cypherText, privatewholeNumChoose)
        //

    }

    public static void encryptText(int plainText, int key, int n, int wholeNumChoose) {
        double encryptedMessage = (Math.pow(plainText, key) % n);
        System.out.println("Encrypted message is: " + encryptedMessage);

        System.out.println("Do you want to decrypt your message type 'y' for yes and 'n for no");
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);

        if (input == 'y') {
            // System.out.print("yes");
            decryptMessage(encryptedMessage, wholeNumChoose, n);
        } else {
            System.out.println("Try again...");
        }

    }

    static void decryptMessage(double encryptedMessage, int wholeNumChoose, int n) {
        BigInteger N = BigInteger.valueOf(n);
        BigInteger BigIntEncryptedMessage = BigDecimal.valueOf(encryptedMessage).toBigInteger();
        BigInteger plainText = (BigIntEncryptedMessage.pow(wholeNumChoose)).mod(N);

        System.out.println("Plain text is : " + plainText);
    }

}