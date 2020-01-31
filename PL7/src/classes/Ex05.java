package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex05 {

    static Scanner ler = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    public static void main(String[] args) {

        String[] nomes = new String[100];

        String[] aux = new String[100];

        int nElem = preencherVec(nomes);

        mostrarListagem(nomes, nElem);

        int nApelidos = preencherVetorApelidos(nomes, aux);

        String[] vecApelidoS = new String[nApelidos];

        mostrarListagem(vecApelidoS, nApelidos);
    }

    /**
     * Método que preenche o vetor de String's
     *
     * @param vec de String's que contem as String's que o utilizador colocar
     * @return número inteiro positivo da quantidade de elementos que fazem
     * parte do vetor
     */
    static int preencherVec(String[] vec) {

        int nElem = 0;

        String nome = "";

        int valor = vec.length;

        while (!nome.equalsIgnoreCase("fim") && nElem < valor) {

            System.out.println("Introduza o nome no vetor (para terminar digite FIM)");

            nome = ler.nextLine();

            vec[nElem] = nome;

            nElem++;
        }

        return nElem - 1;

    }

    /**
     * Método que faz a listagem do vetor preenchido pelo utilizador
     *
     * @param vec de String's introduzido pelo utilizador
     * @param nElem número inteiro positivo do número de elementos preenchidos
     * que o vetor contem
     */
    static void mostrarListagem(String[] vec, int nElem) {

        for (int i = 0; i < nElem; i++) {

            out.format("%s\t", vec[i]);
        }

        System.out.println("");
    }

    /**
     * Método que retorna o apelido de um nome passado por parâmetro
     *
     * @param nome do tipo String
     * @return o último nome de uma String recebida por parâmetro
     */
    static String apelido(String nome) {

        String apelido = nome.substring(nome.lastIndexOf(" ") + 1);

        return apelido;
    }

    /**
     * Método que preenche o vetor apelidos com todos os apelidos começados pela
     * letra "S"
     *
     * @param v1 vetor de String's que contem todos os nomes introduzidos pelo
     * utilizador
     * @param v2 vetor de String's que contém os nomes com apelidos começados
     * pela letra "S"
     * @return número inteiro de apelidos que o vetor v2 contém com a letra "S"
     * no ínicio
     */
    static int preencherVetorApelidos(String[] v1, String[] v2) {

        int cont = 0;

        int contApelidoS = 0;

        while (cont < v1.length) {

            String auxApelido = apelido(v1[cont]);

            if (auxApelido.trim().toLowerCase().equalsIgnoreCase("S")) {

                v2[contApelidoS] = v1[cont];

                contApelidoS++;
            }
            cont++;
        }

        return contApelidoS;
    }
}
