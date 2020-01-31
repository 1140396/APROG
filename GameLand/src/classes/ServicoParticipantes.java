package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bruno
 */
public class ServicoParticipantes {

    private static final Scanner in = new Scanner(System.in);

    /**
     * Método que faz a alteração do e-mail de um participante já existente em
     * memória
     *
     * @param participantes - Matriz dos participantes carregados em memória
     * @param nElem - número de elementos que existe na matriz de participantes
     * @param mailAlterar - e-mail introduzido pelo utilizador para fazer
     * alteração
     * @return 1 no caso de ser bem sucedida a alteração do e-mail ou -1 no caso
     * de não respeitar alguma das condições de validação do e-mail
     */
    public static int alterarEmail(String[][] participantes, int nElem, String mailAlterar) {

        String novoMail;

        int flag = - 1;

        int pos = verificaIfMailExist(mailAlterar, participantes, nElem);

        if (pos != -1) {

            do {

                System.out.println("Qual o novo mail a introduzir?");

                novoMail = in.nextLine().trim().toLowerCase();

            } while (validaNovoMail(novoMail) == -1 || novoMail.isEmpty());
        } else {

            return flag;
        }

        int addNovoMail = verificaIfMailExist(mailAlterar, participantes, nElem);

        if (addNovoMail != -1) {

            participantes[addNovoMail][0] = novoMail;

            flag = 1;

            System.out.println("Novo mail adicionado com sucesso");
        } else {

            System.out.println("O mail não foi adicionada à memória do sistema, já existente");
        }
        return flag;
    }

    /**
     * Método que verifica se o novo e-mail introduzido já existe em memória
     *
     * @param mail - novo mail introduzido pelo utilizador
     * @param participantes - Matriz de todos os participantes carregado em
     * memória
     * @param nElem - número de elementos existentes em memória
     * @return linha caso não exista nenhum mail igual ou -1 se já existir em
     * memório o e-mail introduzido
     */
    private static int verificaIfMailExist(String mail, String[][] participantes, int nElem) {

        for (int linha = 0; linha < nElem; linha++) {

            if (participantes[linha][0].equalsIgnoreCase(mail)) {

                return linha;
            }
        }
        return -1;
    }

    /**
     * Método que permite fazer a validar o novo mail introduzido pelo
     * utilizador
     *
     * @param novoMail - String que corresponde ao novo mail a alterar em
     * memória
     * @return true no caso do mail respeitar a syntaxe ou false caso não
     * respeite
     */
    private static int validaNovoMail(String novoMail) {

        int flag = -1;

        if (novoMail != null && novoMail.length() > 0) {

            String exp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(novoMail);
            if (matcher.matches()) {

                System.out.println("O e-mail " + novoMail + " é válido.");

                flag = 1;

                return flag;
            }
        }
        System.out.println("O e-mail " + novoMail + " é inválido. Para ser válido tem de ter @ e . (ponto))");

        return flag;
    }

    /**
     * Método que permite fazer a alteração do nome de um determinado
     * participante
     *
     * @param mail - Mail do participante que vai ser alterado no nome
     * @param participantes - Matriz de dados dos participantes guardados em
     * memória
     * @param nParticipantes - número de participantes guardados em memória
     * @return
     */
    public static int alterarNome(String mail, String[][] participantes, int nParticipantes) {

        int pos = verificaIfMailExist(mail, participantes, nParticipantes);

        int flag = -1;

        String novoNome = "";

        if (pos != -1) {

            flag = 1;

            do {

                System.out.println("Introduza o novo nome do participante");

                novoNome = in.nextLine();

            } while (novoNome.isEmpty());
        } else {

            System.out.println("Nome não encontrado na lista de participantes inscritos");

            return flag;
        }

        participantes[pos][1] = novoNome;

        return flag;
    }

    /**
     * Método que permite fazer a alteração da data de um determinado
     * participante guardado em memória no caso de ele existir
     *
     * @param mail - mail do participante a alterar
     * @param nParticipantes - número de elementos que se encontram na matriz
     * participantes
     * @param participantes - Matriz que contém toda a informação relativa aos
     * participantes
     * @return -1 no caso de não ser possível fazer a alteração da data ou 1 no
     * caso da data ser alterada
     */
    public static int alteraData(String mail, int nParticipantes, String[][] participantes) {

        int pos = verificaIfMailExist(mail, participantes, nParticipantes);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int flag = -1;

        if (pos != -1) {

            System.out.println("Qual a nova data a introduzir? (dd/mm/aaaa)");

            String novaData = in.nextLine();

            try {

                Date data = sdf.parse(novaData);
                flag = 1;
                participantes[pos][2] = novaData;

                return flag;

            } catch (ParseException e) {

                System.out.println("A data introduzida é inválida");
            }

        } else {

            System.out.println("O mail introduzido não está registado em memória");
        }

        return flag;
    }

    /**
     * Método que verifica se a equipa foi carregada em memória
     *
     * @param participantes - matriz de participantes
     * @param nElem - número de elementos existentes em memória
     * @param nomeEquipa - nome da equipa a remover da estrutura de dados
     * @return i no caso da equipa existir ou -1 se não estiver registada na
     * estrutura de dados
     */
    public static int verificaIfEquipaExist(String[][] participantes, int nElem, String nomeEquipa) {

        int flag = -1;

        for (int i = 0; i < nElem; i++) {

            if (participantes[i][3].equals(nomeEquipa)) {

                return i;
            }
        }

        return flag;
    }
}
