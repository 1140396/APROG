package classes;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Ex2 {

    public static void main(String[] args) {

        String disciplina, positivas;

        int nPositivas = 0;

        int cont = 0;

        String alunos = JOptionPane.showInputDialog(null, "Quantos alunos tem a turma?");

        int nAlunos = Integer.parseInt(alunos);

        String disciplinas = JOptionPane.showInputDialog(null, "Quantas disciplinas vai avaliar?");

        int nDisciplinas = Integer.parseInt(disciplinas);

        while (nDisciplinas != cont) {

            disciplina = JOptionPane.showInputDialog(null, "Qual a disciplina a avaliar?");

            positivas = JOptionPane.showInputDialog(null, "Quantas positivas houve na turma?");

            nPositivas = Integer.parseInt(positivas);

            String imprimir = imprimir(nAlunos, nPositivas, disciplina);

            JOptionPane.showMessageDialog(null, imprimir);

            cont++;
        }

    }

    private static String imprimir(int nAlunos, int contP, String disciplina) {

        String auxP = "";

        String auxN = "";

        int contN = Math.abs(nAlunos - contP);

        for (int i = 0; i < contP; i++) {

            auxP += "*";
        }

        for (int i = 0; i < contN; i++) {

            auxN += "*";

        }

        String aux = "Disciplina: " + disciplina + "\n- Positivas: " + auxP + "\n- Negativas: " + auxN;

        return aux;
    }
}
