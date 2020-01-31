package classes;

import java.util.Scanner;

/**
 *
 * @author bruno 
 */
public class Ex9 {

    private static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Quantos termos quer visualizar?");

        int n = ler.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("(" + i + "):" + fibonacci(i) + "\t");
        }
        System.out.println();
    }

    public static int fibonacci(int num) {

        int a = 1;

        int b = 0;

        int aux;

        for (int i = 0; i < num; i++) {

            aux = a;

            a += b;

            b = aux;

        }
        return a;
    }
}
