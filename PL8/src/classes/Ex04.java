package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex04 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int tamanhoVec = tamanhoVec();

        int[] vetor = new int[tamanhoVec];

        preencherVec(vetor);

        organizaCrescente(vetor);

        if (validaDigitos(vetor) == true) {

            System.out.println("O vetor possui números iguais, não pode");

        } else {

            System.out.println("Quantos M números maiores quer visualizar?");

            int m = in.nextInt();
            in.nextLine();

            System.out.println("--- Listagem do vetor ordenado ---");

            for (int i = 0; i < m; i++) {

                System.out.printf("%d\t", vetor[i]);

            }
            System.out.println();
        }
    }

    /**
     * Método em que o utilizador define o tamanho do vetor
     *
     * @return nElem número inteiro positivo e diferente de 0
     */
    private static int tamanhoVec() {

        int nElem;

        do {
            System.out.println("Quantos digitos vai introduzir no vetor?");

            nElem = in.nextInt();
            in.nextLine();
        } while (nElem <= 0);

        return nElem;
    }

    /**
     * Método que faz o preenchimento do vetor criado pelo utilizador
     *
     * @param vec de inteiros
     */
    private static void preencherVec(int[] vec) {

        for (int i = 0; i < vec.length; i++) {

            System.out.println("Introduza o valor no vetor");
            vec[i] = in.nextInt();
            in.nextLine();
        }
    }

    /**
     * Método que faz a organização do vetor por ordem crescente
     *
     * @param vec de inteiros
     */
    public static void organizaCrescente(int[] vec) {

        int aux;

        for (int i = 0; i < vec.length; i++) {
            for (int j = i + 1; j < vec.length; j++) {
                if (vec[i] < vec[j]) {

                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }

    }

    /**
     * Método que valida se existe ou não valores inteiros iguais
     *
     * @param vec de inteiros
     * @return false no caso de os valores serem todos diferentes e true no caso
     * de existir um único valor igual
     */
    private static boolean validaDigitos(int[] vec) {

        boolean repetiu = false;

        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = i + 1; j < vec.length; j++) {

                if (vec[j] == vec[i]) {

                    repetiu = true;
                }
            }
        }

        return repetiu;
    }
}
