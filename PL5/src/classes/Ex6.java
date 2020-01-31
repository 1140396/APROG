package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex6 {

    private static Scanner ler = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int seq1, seq2;

        int contSeq1 = 0;

        int contSeq2 = 0;

        System.out.println("Introduza o 1º número da sequência 1 (termina com 0)");
        seq1 = ler.nextInt();

        while (seq1 != 0) {

            int aux = seq1 % 2;

            if (aux == 0) {

                contSeq1++;
            }
            System.out.println("Introduza o número seguinte da sequência 1 (termina com 0)");
            seq1 = ler.nextInt();
        }

        System.out.println("Introduza o 1º número da sequência 2 (termina com -1)");
        seq2 = ler.nextInt();

        while (seq2 != -1) {

            int aux1 = seq2 % 2;

            if (aux1 == 0) {

                contSeq2++;

            }
            System.out.println("Introduza o número seguinte da sequência 2 (termina com -1)");
            seq2 = ler.nextInt();
        }

        if (contSeq1 > contSeq2) {

            System.out.println("A sequência com mais números pares é a sequência 1");

        } else {

            System.out.println("A sequência com mais números pares é a sequência 2");

        }
        
        // Condição ==
    }

}
