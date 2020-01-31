package testesunitarios;

import classes.Ex02;

/**
 *
 * @author bruno
 */
public class TestesUnitariosEx02 {

    public static void main(String[] args) {

        int[][] matriz = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};

        System.out.println(testeQuadradoMagico(matriz));

        int[][] matrizFalha = {{6, 1, 6}, {3, 9, 7}, {4, 9, 10}};

        System.out.println(testeQuadradoMagico(matrizFalha));

    }

    private static String testeQuadradoMagico(int[][] matriz) {

        if ((Ex02.verificaQuadradoMagico(matriz)) == true) {

            return "SUCESSO";
        } else {

            return "FALHOU";
        }
    }
}
