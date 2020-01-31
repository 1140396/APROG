package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Formatter;

/**
 *
 * @author bruno
 */
public class ServicosFicheiros {

    private static final String SEPARADOR_DADOS_FICHEIRO = ";";

    /**
     * Método que permite passar para um vetor toda a informação lida num
     * ficheiro .txt, relativa aos jogos a serem realizados numa determinada
     * data correspondente a um Evento
     *
     * @param nomeFichJogos - String do ficheiro que o utilizador quer ler para
     * o vetor
     * @param jogos - vetor de String's que vai armazenar a informação dos jogos
     * que se vão realizar num determinado Evento
     * @return true no caso do vetor estar completamente preenchido com toda a
     * informação relativa aos jogos a serem realizados num Evento ou false no
     * caso de faltar informação no ficheiro
     * @throws FileNotFoundException
     */
    public static boolean carregarJogosDoEvento(String nomeFichJogos, String[] jogos) throws FileNotFoundException {

        Scanner fInput = new Scanner(new File(nomeFichJogos));

        int i = 0;

        while (fInput.hasNext() && i < Configuracoes.N_JOGOS) {

            String linha = fInput.nextLine();

            if ((linha.trim()).length() > 0) {

                jogos[i] = linha;

                i++;
            }
        }

        fInput.close();

        // Retorna true caso o array esteja completamente preenchido com a informação do ficheiro
        if (i == Configuracoes.N_JOGOS) {

            return true;
        }

        return false;
    }

    /**
     * Carrega a informação do ficheiro dos participantes para memória
     *
     * @param nomeFich - nome do ficheiro que contem a informação a guardar
     * @param participantes - matriz de String's para guardar a informação do
     * ficheiro
     * @param nElem - número de elementos já existente na matriz
     * @return o número final de elementos inseridos na matriz
     * @throws FileNotFoundException
     */
    public static int carregarParticipantes(String nomeFich, String[][] participantes, int nElem) throws FileNotFoundException {

        Scanner fInput = new Scanner(new File(nomeFich));

        int nElemInicial = nElem;

        while (fInput.hasNext() && nElem < Configuracoes.MAX_PARTICIPANTES) {

            String linha = fInput.nextLine();

            if ((linha.trim()).length() > 0) {

                nElem = guardarDadosParticipantes(linha, participantes, nElem);
            }
        }

        fInput.close();

        //Verifica se são adicionados 3 elementos de cada vez à matriz de participantes, se não forem 3 não adiciona e mantém o nº de elementos
        if (nElem - nElemInicial != 3) {

            nElem = nElemInicial;
        }

        return nElem;
    }

    /**
     * Acede à informação de uma linha do ficheiro e guarda-a na estrutura de
     * dados se ainda não existir linha com aquele mail no 1º elemento da matriz
     *
     * @param linha - String com o conteúdo de uma linha do ficheiro
     * @param participantes - matriz de String's com a informação lida no
     * ficheiro
     * @param nElem - número de elementos existentes na matriz
     * @return - o novo número de elementos da matriz
     */
    private static int guardarDadosParticipantes(String linha, String[][] participantes, int nElem) {

        String[] temp = linha.split(SEPARADOR_DADOS_FICHEIRO);

        if (temp.length == Configuracoes.N_CAMPOS_INFO) {

            String mail = temp[0].trim();

            int pos = procurarElemento(mail, participantes, nElem);

            if (pos == - 1) {

                for (int coluna = 0; coluna < Configuracoes.N_CAMPOS_INFO; coluna++) {

                    participantes[nElem][coluna] = temp[coluna].trim();

                }
                nElem++;
            }

        }
        return nElem;
    }

    /**
     * Método que faz a pesquisa da matriz pelo primeiro elemento da linha
     *
     * @param mail - elemento a pesquisar
     * @param participantes - matriz de String's com a informação de cada equipa
     * @param nElem - número de elementos da matriz
     * @return -1 no caso de não existir nenhuma linha com esse mail ou número
     * da linha cujo o primeiro elemento corresponde ao mail
     */
    private static int procurarElemento(String mail, String[][] participantes, int nElem) {

        for (int linha = 0; linha < nElem; linha++) {

            if (participantes[linha][0].equals(mail)) {

                return linha;
            }
        }
        return -1;
    }

    /**
     * Método que faz a leitura dos pontos obtidos pelos particicpantes em cada
     * jogo
     *
     * @param participantes - matriz que contem todos os participantes
     * @param jogos - matriz de jogos que se realizaram no Evento
     * @param idJogo - idJogo a gravar
     * @param pontos - pontos obtidos por cada participante
     * @param nParticipantes - número total de participantes
     * @param nomeFicheiro - nome do ficheiro a ler informação
     * @return número de participantes que não participou no jogo
     * @throws FileNotFoundException
     */
    public static int carregarResultadosJogos(String[][] participantes, String[] jogos, String idJogo, int[][] pontos, int nParticipantes, String nomeFicheiro) throws FileNotFoundException {

        Scanner fInput = new Scanner(new File(nomeFicheiro));

        int index = procuraIndexIdJogo(idJogo, jogos);

        int cont = 0;

        String[] temp = jogos[index].split("-");

        int maxPontos = Integer.parseInt(temp[2]);

        while (fInput.hasNext()) {

            String linha = fInput.nextLine();

            String[] aux = linha.split(";");

            String mail = aux[0].trim();

            for (int i = 0; i < Configuracoes.N_JOGOS; i++) {

                int pos = procurarElemento(mail, participantes, nParticipantes);

                if ((linha.trim()).length() > 0) {

                    if (pos != -1) {

                        int pts = Integer.parseInt(aux[1].trim());

                        if (pts <= maxPontos) {

                            pontos[i][index] = pts;

                        } else if (pts > maxPontos) {

                            pontos[i][index] = 0;
                        }
                    }
                } else if (linha.trim().length() == 0) {

                    pontos[i][index] = 0;

                    cont++;
                }
            }
        }

        return cont;
    }

    /**
     * Método que permite obter o ID do Jogo que o utilizador introduz na
     * leitura do ficheiro de texto
     *
     * @param nomeFich - nome do ficheiro que contem a informação das pontuações
     * relativas aos participante
     * @return Id do Jogo a pontuar
     */
    public static String guardaIdJogo(String nomeFich) {

        String[] separador = nomeFich.split("_");

        String aux = separador[1];

        String idJogo = aux.substring(aux.indexOf("_") + 1, aux.lastIndexOf("."));

        return idJogo;

    }

    /**
     * Método que retorna a posição em que se encontra o id do jogo que se
     * encontra no vetor jogos
     *
     * @param idJogo - String que contém o id do jogo a que o ficheiro de
     * pontuações se refere
     * @param jogos - Vetor que contém todos os jogos que estão a decorrer num
     * determinado Evento
     * @return index no caso de existir o Id do jogo no vetor jogos ou -1 caso
     * não exista
     */
    private static int procuraIndexIdJogo(String idJogo, String[] jogos) {

        int index;

        String idJogoFich = jogos[1].substring(0, 3);

        for (int i = 0; i < Configuracoes.N_JOGOS; i++) {

            if (idJogo.trim().equalsIgnoreCase(jogos[i].substring(0, 3))) {

                index = i;

                return index;
            }
        }
        return -1;
    }

    /**
     * Método que guarda toda a informação existente em memória num ficheiro
     * backup.txt
     *
     * @param participantes - matriz de participantes
     * @param pontos - matriz de pontos
     * @param jogos - vetor de jogos
     * @param nElem - número de elementos que estão registados num evento
     * @throws IOException
     */
    public static void guardaInfo(String[][] participantes, int[][] pontos, String[] jogos, double[][] premios, int nElem) throws IOException {

        String nomeFich = "backup.txt";

        Formatter fOut = new Formatter(new File(nomeFich));

        for (int linha = 0; linha < nElem; linha++) {
            for (int coluna = 0; coluna < Configuracoes.N_CAMPOS_INFO; coluna++) {
                
                fOut.format("%20s", participantes[linha][coluna]);
            }

            for (int j = 0; j < Configuracoes.N_JOGOS; j++) {

                fOut.format("%20d", pontos[linha][j]);

            }

//            for (int j = 0; j < Configuracoes.N_JOGOS; j++) {
//
//                fOut.format("%2f", premios[linha][j]);
//
//            }
            fOut.format("%n");
        }

        fOut.close();
    }
}
