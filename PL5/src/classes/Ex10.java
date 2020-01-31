package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex10 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduza um número décimal para converter em binário");
        int decimal = ler.nextInt();

        int guardaDecimal = decimal;

        String bin = "";

        while (decimal > 0) {

            if (decimal % 2 == 0) {

                bin = "1" + bin;
            } else {

                bin = "0" + bin;
            }

            decimal /= 2;
        }

        System.out.println("O número " + guardaDecimal + " em binário é " + bin);
    }
}
