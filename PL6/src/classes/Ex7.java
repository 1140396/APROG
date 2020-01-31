package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex7 {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduza um número Octal");

        int octal = ler.nextInt();

        if (verificarOctal(octal) == true) {

            corversorOctal(octal);

        }
    }

    public static boolean verificarOctal(int n) {

        int num;

        int cont = 0;

        boolean valida = false;

        for (int i = 1; i <= n; i++) {

            num = n % 10;

            n /= 10;

            if (num >= 8) {

                System.out.println("----NÚMERO DIGITADO NÃO É OCTAL----");

                return valida;

            }
        }
        valida = true;

        return valida;
    }

    public static int corversorOctal(int n) {

        int numero = n;

        int cont = 0;

        int nDecimal = 0;

        int decimal;

        while (n > 0) {

            decimal = n % 10;

            n /= 10;

            nDecimal += (decimal * (Math.pow(8, cont)));

            cont++;
        }

        System.out.println("O número " + numero + " em base octal, fica " + nDecimal + " em base decimal");

        return nDecimal;
    }

}
