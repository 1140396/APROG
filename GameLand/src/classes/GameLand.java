package classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class GameLand {

    static Scanner in = new Scanner(System.in);

    static Formatter out = new Formatter(System.out);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] jogos = new String[Configuracoes.N_JOGOS];

        String[][] participantes = new String[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_CAMPOS_INFO];

        int nParticipantes = 0;

        String[][] pontuacoes = new String[3][2];

        int[][] pontos = new int[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_JOGOS];

        //int[][] pontosGenerica = {{100, 90, 40}, {0, 200, 0}, {50, 100, 30}};
        double[][] premios = new double[Configuracoes.MAX_PARTICIPANTES][Configuracoes.N_JOGOS];

        boolean mostraListagem = false;

        int op;

        do {

            op = menu();

            switch (op) {

                case 1:

                    try {

                        System.out.println("Qual a data do Evento(AAAAMMDD)");

                        String nomeFich = in.nextLine().trim() + ".txt";

                        if (ServicosFicheiros.carregarJogosDoEvento(nomeFich, jogos)) {

                            mostraListagem = true;

                            System.out.println("Jogos carregados com sucesso");
                        }

                    } catch (FileNotFoundException e) {

                        System.out.println("O ficheiro não existe em sistema!");
                    }

                    break;

                case 2:

                    if (mostraListagem == true) {

                        ServicosListagem.visualizarInfoJogos(jogos);
                    } else {

                        System.out.println("Não foram carregados em memória nenhuns jogos do Evento");
                    }

                    break;

                case 3:

                    try {

                        int verificaNovosElem = nParticipantes;

                        System.out.println("Qual o nome da equipa que quer carregar em memória?");

                        String fichEquipa = in.nextLine().trim() + ".txt";

                        nParticipantes = ServicosFicheiros.carregarParticipantes(fichEquipa, participantes, nParticipantes);

                        if (verificaNovosElem != nParticipantes) {

                            System.out.println("Equipa carregada com sucesso!");

                        } else {

                            System.out.println("O ficheiro possui dados inválidos");
                        }

                    } catch (FileNotFoundException e) {

                        System.out.println("O ficheiro da equipa não existe em sistema!");
                    }

                    break;

                case 4:

                    ServicosListagem.listagemPaginada(participantes, nParticipantes);

                    break;

                case 5:

                    char valor;

                    do {

                        valor = menuParticipante();

                        switch (valor) {

                            case '1':

                                System.out.println("Introduza qual o email a alterar");

                                String antigoMail = in.nextLine().trim();

                                int valMail = ServicoParticipantes.alterarEmail(participantes, nParticipantes, antigoMail);

                                if (valMail == 1) {

                                    System.out.println("Operação realizada com sucesso");
                                } else {

                                    System.out.println("Operação não foi realizada");
                                }

                                break;

                            case '2':

                                System.out.println("Qual o mail do participante quer quer alterar o nome?");

                                String mailNome = in.nextLine();

                                int valData = ServicoParticipantes.alterarNome(mailNome, participantes, nParticipantes);

                                if (valData == 1) {

                                    System.out.println("Operação realizada com sucesso!");
                                } else {

                                    System.out.println("A operação não foi realizada");
                                }

                                break;

                            case '3':

                                System.out.println("Introduza o mail do participante que quer alterar a data");

                                String mailData = in.nextLine();

                                int valNome = ServicoParticipantes.alteraData(mailData, nParticipantes, participantes);

                                if (valNome == 1) {

                                    System.out.println("Operação realizada com sucesso!");
                                } else {

                                    System.out.println("A operação não foi realizada");
                                }

                                break;

                            case '4':

                                System.out.println("Introduza o mail do participante que quer alterar a equipa");

                                break;
                        }
                    } while (valor != '0');

                    break;

                case 6:

                    try {

                        System.out.println("Introduza o nome do ficheiro de pontuações que quer ler");

                      String nomeFich = in.nextLine() + ".txt";

                        String idJogo = ServicosFicheiros.guardaIdJogo(nomeFich);

                        ServicosFicheiros.carregarResultadosJogos(participantes, jogos, idJogo, pontos, nParticipantes, nomeFich);

                        //ServicosListagem.listarMatriz(pontos, nParticipantes);
                    } catch (FileNotFoundException e) {

                        System.out.println("Erro na leitura de ficheiro");
                    }
                    break;

                case 7:

                    try {

                        ServicosFicheiros.guardaInfo(participantes, pontos, jogos, premios, nParticipantes);

                    } catch (IOException e) {

                        System.out.println("Não foi possível guardar a informação em memória");
                    }

                    System.out.println("Ficheiro Backup criado com sucesso!");

                    break;

                case 8:

                    break;

                case 9:

                    System.out.println("Introduza o nome da equipa que quer remover");

                    String removeEquipa = in.nextLine().trim();

                    if ((ServicoParticipantes.verificaIfEquipaExist(participantes, nParticipantes, removeEquipa) != -1)) {

                        nParticipantes = Utilitarios.removeEquipa(participantes, pontos, premios, nParticipantes, removeEquipa);

                        System.out.println("Equipa removida com sucesso!");

                    } else {

                        System.out.println("A equipa não foi encontrada");

                    }

                    break;

                case 0:

                    System.out.println("Já fez todas as gravações necessárias? Confirma terminar (s/n)?");

                    char resp = in.next().trim().toLowerCase().charAt(0);

                    if (resp != 's') {

                        op = 1;
                    }

                    break;

                default:

                    System.out.println("A opção é inválida");
            }

        } while (op != 0);
    }

    /**
     * Método que mostra a representação textual do menu da aplicação
     *
     * @return op valor char positivo que representa a ação que o utilizador
     * quer realizar no programa
     */
    private static int menu() {

        String txt = "---- MENU ----"
                + "\n1 - Ler Informação dos Jogos a realizar no Evento"
                + "\n2 - Visualizar informação sobre jogos que compõem o Evento"
                + "\n3 - Ler ficheiro de participantes de uma equipa"
                + "\n4 - Visualizar perticipantes já inscritos"
                + "\n5 - Alterar participante"
                + "\n6 - Ler ficheiro de resultados de um jogo"
                + "\n7 - Guardar todas as informações relativas aos participantes e pontos "
                + "num ficheiro backup"
                + "\n8 - Calcular os prémios dos participantes obtidos no evento"
                + "\n9 - Remover de memória toda a informação de uma equipa"
                + "\n10 - Visualizar no ecrã para uma determinada equipa, os prémios auferidos pelos"
                + "seus elementos, ordenados alfabeticamente"
                + "\n11 - Visualizar a pontuação média obtida pelos participantes nesse jogo,"
                + "a percentagem de jogadores que não participou ou desistiu e o valor total de prémios atribuídos nesse jogo"
                + "\n12 -  "
                + "\n0 - Terminar";

        System.out.printf("%n%s%n", txt);

        System.out.println("---- ESCOLHA UMA OPÇÃO ----");

        int op = in.nextInt();
        in.nextLine();

        return op;
    }

    /**
     * Método que cria o menu para fazer a alteração em qualquer campo de
     * memória de um jogador
     *
     * @return op valor char positivo que representa a ação que o utilizador
     * quer realizar no programa
     */
    private static char menuParticipante() {

        String texto = "ATUALIZAR INFORMAÇÃO DE PARTICIPANTE"
                + "\n1 - Email"
                + "\n2 - Nome"
                + "\n3 - Data de nascimento"
                + "\n0 - Terminar"
                + "\nQual a sua opção?";

        System.out.printf("%n%s%n", texto);

        char op = in.next().charAt(0);
        in.nextLine();

        return op;
    }
}
