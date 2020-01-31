package TestesUnitarios;

import classes.Utilitarios;

/**
 *
 * @author bruno
 */
public class TesteUtilitarios {

    public static void main(String[] args) {

        System.out.println("---- TESTE CLASSE converterddmmaaaaToaaaammdd ----\n");

        String dataSucesso = "22/08/1995";

        System.out.print("Teste para data = " + dataSucesso);

        System.out.println(testeconverterddmmaaaaToaaaammdd(dataSucesso));

        String dataFalha = "22/8/1994";

        System.out.print("Teste para data = " + dataFalha);

        System.out.println(testeconverterddmmaaaaToaaaammdd(dataFalha));

        String dataInvertida = "1995/12/08";

        System.out.print("Teste para data = " + dataInvertida);

        System.out.println(testeconverterddmmaaaaToaaaammdd(dataInvertida));

        System.out.println("\n---- TESTE CLASSE CalcularIdade ----\n");

        String anoMesDiaSucesso = "19950828";

        System.out.print("Teste para anoMesDia = " + anoMesDiaSucesso);

        System.out.println(testeCalculaIdade(anoMesDiaSucesso));

        String anoMesDiaFalha = "19970720";

        System.out.print("Teste para anoMesDia = " + anoMesDiaFalha);

        System.out.println(testeCalculaIdade(anoMesDiaFalha));
    }

    /**
     * Método que testa o método converterddmmaaaaToaaaammdd da classe
     * Utilitarios
     *
     * @param data - String recebida como parâmetro
     * @return
     */
    private static String testeconverterddmmaaaaToaaaammdd(String data) {

        if (Utilitarios.converterddmmaaaaToaaaammdd(data).equals("19950822")) {

            return " ......... SUCESSO";

        } else {

            return " ......... FALHOU";
        }
    }

    /**
     * Método que testa o método calcular idade da classe Utilitarios
     *
     * @param anoMesDia - String que contem anoMesDia
     * @return
     */
    private static String testeCalculaIdade(String anoMesDia) {

        if (Utilitarios.calcularIdade(anoMesDia) == 23) {

            return " ......... SUCESSO";
        } else {

            return " ......... FALHOU";
        }

    }
}
