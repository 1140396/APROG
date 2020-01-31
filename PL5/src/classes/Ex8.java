package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex8 {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int contBin = 0;

        System.out.println("Escreva um número binário");
        int bin = ler.nextInt();

        while (bin != 0) {

            int aux = bin % 10;

            bin /= 10;

            if (aux != 0 && aux != 1) {

                contBin++;
            }
        }
        if (contBin > 0) {

            System.out.println("O número introduzido não é binário");
        } else {

            System.out.println("O número introduzido é binário");
        }
    }
}
