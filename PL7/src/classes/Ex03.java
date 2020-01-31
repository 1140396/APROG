package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex03 {

    static Scanner ler = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {

        int n = 0;

        String[] nomes = new String[3];

        String m = "1- Ler Nomes \n2- Enigma    Nome\n3- Terminar\n\nEscolha uma opção: ";

        char op;

        do {

            System.out.println(m);
            op = ler.next().charAt(0);

            switch (op) {

                case '1':
                    n = lerNomes(nomes);
                    break;

                case '2':
                    System.out.println("Nome: ");
                    String nome = ler.next();
                    n = enigma(nomes, nome, n);
                    break;

                case '3':
                    break;

                default:
                    System.out.println("Opção inválida!!");
            }

        } while (op != '3');
    }

    /**
     * Método que insere os nomes no vetor nomes
     *
     * @param vec preenchido com nomes introduzidos pelo utilizador até digitar
     * a palavra "Fim" ou atingir o limite máximo de posições no vetor (100)
     * @return o número de elementos que foram introduzidos no vetor nomes
     */
    private static int lerNomes(String[] vec) {

        int nElem = 0;

        String nome = "";

        while (!nome.equalsIgnoreCase("FIM") && nElem < vec.length) {

            System.out.println("Introduza o nome que quer guardar no vetor: ");

            nome = ler.next();

            vec[nElem] = nome;

            nElem++;
        }

        return nElem;
    }

    /**
     * Método para listar todos os n elementos do vetor nomes
     *
     * @param vec vetor de String's que armazena os nomes introduzidos pelo
     * utilizador
     * @param n número inteiro de posições que o vetor possui
     * @return -1
     */
    private static int listar(String[] vec, int n) {

        System.out.println("---- Listagem vetor nomes ----");

        for (int i = 0; i < n; i++) {

            out.format("%s\t", vec[i]);

        }

        return -1;
    }

    /**
     * Método para remover o 1º nome no vetor encontrado igual ao nome passado
     * por parâmetro
     *
     * @param nomes vetor de String's que contem os nomes introduzidos pelo
     * utilizador
     * @param nome parâmetro do tipo String introduzido pelo utilizador para
     * remover no vetor
     * @param n número de elementos existentes no vetor nomes
     * @return o número de elementos inicial do vetor caso não encontre nenhum
     * nome igual ao passado como parâmetro ou menos uma posição no caso de
     * encontrar algum nome igual no vetor ao que foi passado por parâmetro
     */
    private static int enigma(String[] nomes, String nome, int n) {

        int i = 0;

        while (i < n && !nomes[i].equalsIgnoreCase(nome)) {

            i++;

            if (i == n) {

                return n;
            } else {

                for (int j = i; j < n - 1; j++) {

                    nomes[j] = nomes[j + 1];

                    return --n;
                }
            }
        }
        return -1;
    }
}
