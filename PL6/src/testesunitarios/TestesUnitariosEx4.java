package testesunitarios;

import classes.Ex4;

/**
 *
 * @author bruno
 */
public class TestesUnitariosEx4 {

    public static void main(String[] args) {

        //Teste ao fatorial de um dado n
        System.out.print("Teste Fatorial de 3");
        System.out.println(" ... " + testeFatorial(3) + "");

        //Teste a combinações n a p
        System.out.print("Teste Combinações de n = 3 e p = 2");
        System.out.println(" ... " + testeCombinacoes(3, 2));

        //Teste permutações n a p
        System.out.print("Teste permutações de n = 3 e p = 2");
        System.out.println(" ... " + testePermutacoes(3, 2));

        //Teste arranjos de n a p
        System.out.print("Teste arranjos de n = 4 e p = 3");
        System.out.println(" ... " + testeArranjos(4, 3));
    }

    // Teste Fatorial de n
    public static String testeFatorial(long n) {

        if (Ex4.fatorial(n) == 6) {

            return "Sucesso!";
        } else {
            return "Falhou!";
        }
    }

    //Teste Combinaçoes n a p
    public static String testeCombinacoes(long n, long p) {

        if (Ex4.combinacoes(n, p) == 3) {

            return "Sucesso!";
        }
        return "Falhou!";
    }

    //Teste permutações n a p
    public static String testePermutacoes(long n, long p) {

        if (Ex4.permutacao(n, p) == 3) {

            return "Sucesso!";
        }
        return "Falhou!";
    }

    //Teste arranjos n a p
    public static String testeArranjos(long n, long p) {

        if (Ex4.arranjos(n, p) == 24) {

            return "Sucesso!";
        }
        return "Falhou!";
    }

}
