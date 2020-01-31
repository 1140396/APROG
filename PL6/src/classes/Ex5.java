package classes;

import java.util.Scanner;

/**
 *
 * @author bruno 
 */
public class Ex5 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int a, b, n, flag = 0;

        int guardaDigA, guardaDigB, maisDigitos = 1;

        int cont = 0;

        String txt = "";

        do {
            System.out.println("Quantos n pares de números quer ler?");

            n = ler.nextInt();
        } while (n <= 0);

        while (n != cont) {
            System.out.println("Introduza o digito a");

            a = ler.nextInt();
            guardaDigA = a;

            System.out.println("Introduza o digito b");

            b = ler.nextInt();
            guardaDigB = b;

            cont++;

            //Como fazer para apresentar msg de "sem dados"
            if (digComuns(a, b) >= maisDigitos) {

                maisDigitos = digComuns(a, b);

                txt = (guardaDigA + "/" + guardaDigB);

                flag = 1;
            }
        }
        if (flag == 1) {

            System.out.println(txt);
        } else {

            System.out.println("sem dados");
        }
    }

    /**
     * Método que retorna um inteiro com o número que tenha mais digitos iguais
     * na mesma posição
     *
     * @param a número positivo inteiro diferente de 0
     * @param b número positivo inteiro diferente de 0;
     * @return o valor inteiro do número que tenha mais digitos iguais na mesma
     * posição
     */
    public static int digComuns(int a, int b) {

        int auxA, auxB;

        int contDig = 0;

        int contMaisDig = 0;

        while (a != 0 || b != 0) {

            auxA = a % 10;

            a /= 10;

            auxB = b % 10;

            b /= 10;

            if (auxA == auxB) {

                contDig++;

                if (contDig > contMaisDig) {

                    contMaisDig = contDig;
                }
            }
        }
        return contMaisDig;
    }
}
