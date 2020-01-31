package classes;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex06 {

    static Scanner ler = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    static String[] visitantes = new String[100];

    public static void main(String[] args) {

        int nElem = 0;

        String m = "1 - Inserir um visitante \n2 - Listar todos os visitantes \n3 - Atualizar um nome dado \n4 - Eliminar um visitante "
                + "\n5 - Listar nomes começados por uma dada letra \n6 - Listar nomes repetidos \n7 - Terminar programa";

        char op;

        do {

            System.out.println(m);
            System.out.println("Digite uma opção: ");
            op = ler.next().charAt(0);
            ler.nextLine();
            switch (op) {

                case '1':

                    nElem = inserirVisitante(visitantes, nElem);
                    ler.nextLine();
                    break;

                case '2':

                    listarVetor(visitantes, nElem);
                    System.out.println("");
                    break;

                case '3':
                    String novoVisitante;
                    int verifica;
                    do {
                        System.out.println("Digite o nome que quer atualizar no vetor visitantes: ");
                        novoVisitante = ler.next();
                        ler.nextLine();
                        verifica = procurarVisitante(visitantes, nElem, novoVisitante);
                    } while (verifica == -1);

                    System.out.println("Introduza o novo nome: ");
                    novoVisitante = ler.next();
                    ler.nextLine();
                    visitantes[verifica] = novoVisitante;
                    System.out.println("---- NOME ATUALIZADO COM SUCESSO ----");

                    break;

                case '4':
                    String eliminarVisitante;
                    int valida;
                    do {

                        System.out.println("Digite o nome que quer eliminar no vetor visitantes");
                        eliminarVisitante = ler.next();
                        ler.nextLine();
                        valida = procurarVisitante(visitantes, nElem, eliminarVisitante);

                    } while (valida == -1);

                    nElem = eliminarVisitante(visitantes, nElem, eliminarVisitante);
                    System.out.println("---- NOME REMOVIDO COM SUCESSO ----");

                    break;

                case '5':

                    char letra;

                    System.out.println("Introduza a letra que quer visualizar os nomes começados por ela");
                    letra = ler.next().charAt(0);
                    listarNomesChar(visitantes, letra, nElem);

                    break;

                case '6':

                    System.out.println("---- LISTAGEM DE NOMES REPETIDOS ----");
                    listarNomesRepetidos(visitantes, nElem);

                    break;

            }

        } while (op != '7');

    }

    /**
     * Método que permite ao utilizador inserir um elemento do tipo String no
     * vetor passado como parâmetro
     *
     * @param vec vetor do tipo String
     * @return número inteiro de elementos que foram inseridos no vetor
     */
    static int inserirVisitante(String[] vec, int nElem) {

        String nome = "";

        while (nElem < vec.length && !nome.equalsIgnoreCase("Terminar")) {

            System.out.println("Introduza o nome do visitante");

            nome = ler.next();

            vec[nElem] = nome;

            nElem++;
        }

        return nElem - 1;
    }

    /**
     * Método que lista um vetor de String's passado por parâmetro
     *
     * @param vec de String's
     * @param nElem número inteiro de elementos que o utilizador digitou no
     * vetor
     */
    static void listarVetor(String[] vec, int nElem) {

        System.out.println("---- LISTAGEM VISITANTES ----");

        for (int i = 0; i < nElem; i++) {

            out.format("%s\t", vec[i]);
        }
    }

    /**
     * Método que procura uma String no array definido pelo utilizador
     *
     * @param vec de String's definido pelo utilizador
     * @param nElem número inteiro de String's que fazem parte do array
     * @param nome String que vai ser comparada a todos os elementos que se
     * encontram no array
     * @return posição da String nome no caso de existir uma igual no array ou
     * -1 no caso de não existir nunhuma String no vetor igual a nome
     */
    static int procurarVisitante(String[] vec, int nElem, String nome) {

        for (int i = 0; i < nElem; i++) {

            if (vec[i].trim().toLowerCase().equalsIgnoreCase(nome.trim().toLowerCase())) {

                return i;
            }
        }

        return -1;
    }

    /**
     * Método que elimina um nome do tipo String introduzido pelo utilizador, do
     * vetor visitantes
     *
     * @param vec de String's definido pelo utilizador
     * @param nElem número inteiro de elementos que o vetor de String's contém
     * @param nome passado por parâmetro que o utilizador quer eliminar
     * @return novo número de elementos do vetor no caso de algum elemento ser
     * removido ou o tamanho inicial do vetor no caso de nada se ter alterado
     */
    static int eliminarVisitante(String[] vec, int nElem, String nome) {

        int p = procurarVisitante(vec, nElem, nome);

        if (p == - 1) {

            return nElem;
        } else {

            for (int i = p; i < nElem - 1; i++) {

                vec[i] = vec[i + 1];
            }
            return nElem - 1;
        }
    }

    /**
     * Método que lista todos os nomes começados por uma letra alfabética
     * introduzida pelo utilizador
     *
     * @param vec de String's definido pelo utilizador
     * @param letra caracter introduzido pelo utilizador
     * @param nElm número inteiro positivo de elementos que o vetor contém
     */
    static void listarNomesChar(String[] vec, char letra, int nElm) {

        String escreverNomes = "";

        int flag = -1;

        for (int i = 0; i < nElm; i++) {

            if (vec[i].trim().toLowerCase().charAt(0) == letra) {

                escreverNomes += vec[i] + "\t";

                flag = 1;
            }
        }
        if (flag == 1) {

            System.out.println("--- LISTAGEM DOS NOMES COMEÇADOS PELA LETRA " + letra + " ----");

            out.format("%s", escreverNomes);
            System.out.println("");
        } else {

            System.out.println("Não existe nenhum nome começado pela letra " + letra);
        }
    }

    /**
     * Método que lista todos os nomes repetidos existentes no vetor recebido
     * como parâmetro
     *
     * @param vec de String's definido pelo utilizador
     * @param nElem número inteiro positivo que o vetor contém
     */
    static void listarNomesRepetidos(String[] vec, int nElem) {

        String guardaNomes = "";

        boolean flag = false;

        for (int i = 0; i < nElem; i++) {
            for (int j = i + 1; j < nElem; j++) {

                if (vec[i].trim().toLowerCase().equalsIgnoreCase(vec[j])) {

                    String aux = vec[i];

                    guardaNomes += aux + "\t";

                    flag = true;

                    break;
                }
            }
        }

        if (flag == true) {

            System.out.println("Os nomes repetidos são: " + guardaNomes);
        } else {
            System.out.println("sem resultados");
        }
    }
}
