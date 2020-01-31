package classes;

import java.util.Calendar;

/**
 *
 * @author bruno
 */
public class Utilitarios {

    //número de elementos max. que cada equipa pode ter
    private static final int ELEMENTOS_POR_EQUIPA = 3;

    /**
     * Método que faz a conversão da nata no formato dd/mm/aaaa em aaaammdd
     *
     * @param data no formato dd/mm/aaaa
     * @return data no formato aaaammdd
     */
    public static String converterddmmaaaaToaaaammdd(String data) {

        String[] aux = data.trim().split("/");

        String dia = aux[0].length() < 2 ? "0" + aux[0] : aux[0];

        String mes = aux[1].length() < 2 ? "0" + aux[1] : aux[1];

        return aux[2] + mes + dia;
    }

    /**
     * Método que calcula a data de nascimento de um participante
     *
     * @param anoMesDia data de nascimento no formato aaaammdd
     * @return idade
     */
    public static int calcularIdade(String anoMesDia) {

        int ano = Integer.parseInt(anoMesDia.substring(0, 4));

        int mes = Integer.parseInt(anoMesDia.substring(4, 6));

        int dia = Integer.parseInt(anoMesDia.substring(6, 8));

        Calendar hoje = Calendar.getInstance();

        int diaH = hoje.get(Calendar.DAY_OF_MONTH);

        int mesH = hoje.get(Calendar.MONTH) + 1;

        int anoH = hoje.get(Calendar.YEAR);

        if (mesH > mes || mesH == mes && diaH >= dia) {

            return anoH - ano;
        }

        return anoH - ano - 1;
    }

    /**
     * Método que remove uma equipa e suas pontuações da estrutura de dados
     *
     * @param participantes
     * @param pontos
     * @param nElem
     * @param equipaRemover
     * @return novo número de elementos
     */
    public static int removeEquipa(String[][] participantes, int[][] pontos, double[][] premios, int nElem, String equipaRemover) {

        int pos = ServicoParticipantes.verificaIfEquipaExist(participantes, nElem, equipaRemover);

        int cont = 0;

        while (cont != ELEMENTOS_POR_EQUIPA) {

            for (int linha = pos; linha < nElem - 1; linha++) {

                participantes[linha] = participantes[linha + 1];

                pontos[linha] = pontos[linha + 1];

                premios[linha] = premios[linha + 1];
            }

            cont++;

            nElem--;

        }

        return nElem;
    }
}
