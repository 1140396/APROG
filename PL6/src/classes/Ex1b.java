package classes;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class Ex1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int cont = 0;

        String pal = JOptionPane.showInputDialog(null, "Palindrome", "Digite uma palavra", JOptionPane.INFORMATION_MESSAGE);

        while (palindrome(pal) == false) {

            pal = JOptionPane.showInputDialog("Palindrome", "Digite uma palavra");

            palindrome(pal);

            cont++;
        }

        JOptionPane.showMessageDialog(null, "Número de tantativas " + cont, "Palindrome", JOptionPane.WARNING_MESSAGE);
    }

    private static boolean palindrome(String pal) {

        boolean resposta = true;
        pal = pal.toLowerCase();
        int tamanho = pal.length();

        for (int i = 0; i < tamanho / 2; i++) {

            if (pal.charAt(i) != pal.charAt(tamanho - 1 - i)) {

                resposta = false;

                break;
            }
        }
        return resposta;
    }

}
