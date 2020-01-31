package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex3 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Insira o lado A do triângulo");

        double a = ler.nextDouble();

        System.out.println("Insira o lado B do triângulo");

        double b = ler.nextDouble();

        System.out.println("Insira o lado C do triângulo");

        double c = ler.nextDouble();

        verificaLadosTriang(a, b, c);

        if (verificaLadosTriang(a, b, c) == false) {
            //do {
                System.out.println("impossivel");

//                System.out.println("Insira o lado A do triângulo");
//
//                a = ler.nextDouble();
//
//                System.out.println("Insira o lado B do triângulo");
//
//                b = ler.nextDouble();
//
//                System.out.println("Insira o lado C do triângulo");
//
//                c = ler.nextDouble();
            //} while (verificaLadosTriang(a, b, c) == false);

        }
        if (verificaLadosTriang(a, b, c) == true) {

            int angAB = (int) Math.round(calcAng(a, b, c));
            int angAC = (int) Math.round(calcAng(a, c, b));
            int angBC = (int) Math.round(calcAng(b, c, a));

            System.out.println(angAB + " " + angAC + " " + angBC);
        }
    }

    /**
     * Método que calcula o valor dos ângulos internos do triângulo
     *
     * @param x número inteiro positivo de um dos lados do triângulo
     * @param y número inteiro positivo de um dos lados do triângulo
     * @param z número inteiro positivo de um dos lados do triângulo
     * @return o valor do ângulo formado por 2 dos lados triângulo
     */
    private static double calcAng(double x, double y, double z) {

        double auxX = Math.pow(x, 2);

        double auxY = Math.pow(y, 2);

        double auxZ = Math.pow(z, 2);

        double lados = (auxX + auxY - auxZ) / (2 * x * y);
        double calcularAng = ((Math.toDegrees(Math.acos(lados))));

        return calcularAng;
    }

    /**
     * Método que verifica se é possível formar um triângulo com os lados
     * fornecidos pelo utilizador
     *
     * @param x valor inteiro positivo de um dos lados do triângulo
     * @param y valor inteiro positivo de um dos lados do triângulo
     * @param z valor inteiro positivo de um dos lados do triângulo
     * @return true no caso de ser possível formar um triângulo e false no caso
     * de não ser possível
     */
    private static boolean verificaLadosTriang(double x, double y, double z) {

        boolean valida = false;

        if ((z < x + y) && (y < z + x) && (x < z + y)) {

            valida = true;

            return valida;
        } else {
            return valida;
        }
    }
}
