package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex4 {

    public static void main(String[] args) {

        long n1, n2, resC, resP, resA;

        Formatter obj1 = new Formatter(System.out);

        Scanner obj2 = new Scanner(System.in);

        obj1.format("%s%n", "Escreva n");

        n1 = obj2.nextLong();

        obj1.format("%s%n", "Escreva p");

        n2 = obj2.nextLong();

        resC = combinacoes(n1, n2);

        if (resC != -1) {
            System.out.println("----COMBINAÇÔES----");
            obj1.format("%s%d%n", "Resultado = ", resC);
        } else {

            obj1.format("ERRO!");
        }

        resP = permutacao(n1, n2);

        if (resP != -1) {
            System.out.println("----PERMUTAÇÕES----");
            obj1.format("%s%d%n", "Resultado = ", resP);
        } else {

            obj1.format("ERRO!");
        }

        resA = arranjos(n1, n2);

        if (resA != -1) {

            System.out.println("----ARRANJOS----");
            obj1.format("%s%d%n", "Resultado = ", resA);
        } else {

            obj1.format("ERRO!");
        }
    }

    /**
     * Calcular o factorial de um número
     *
     * @param num número inteiro não negativo
     * @return o valor do factorial do num
     */
    public static long fatorial(long num) {

        long fact = 1;

        for (long i = num; i > 1; i -= 1) {

            fact = fact * i;
        }

        return fact;
    }

    /**
     * Calcula combinações de n p a p
     *
     * @param n número inteiro não negativo
     * @param p número inteiro não negativo
     * @return o valor da combinação de n p a p ou -1 no caso n<p
     */
    public static long combinacoes(long n, long p) {

        long calcFact;

        if (n < p) {
            return -1;
        }

        calcFact = fatorial(n) / ((fatorial(p) * fatorial(n - p)));

        return calcFact;
    }

    /**
     * Calcula permutações de n a n1
     *
     * @param n número interio não negativo
     * @param n1 número interio não negativo
     * @return o valor da permutação de n a n1 ou -1 no caso de n < n1
     */
    public static long permutacao(long n, long n1) {

        long calcP;

        if (n < n1) {

            return -1;
        }

        calcP = (fatorial(n) / fatorial(n1));

        return calcP;

    }

    /**
     * Calcula arranjos de n a p
     *
     * @param n número inteiro não negativo
     * @param p número inteiro não negativo
     * @return o valor do arranjo de n a p ou -1 no caso de n<p
     */
    public static long arranjos(long n, long p) {

        long calcA;

        if (n < p) {

            return -1;
        }

        calcA = fatorial(n) / fatorial(n - p);

        return calcA;

    }

}
