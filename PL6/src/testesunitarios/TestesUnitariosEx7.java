package testesunitarios;

import classes.Ex7;

/**
 *
 * @author bruno
 */
public class TestesUnitariosEx7 {
    
    public static void main(String[] args) {

        //Teste válido
        System.out.print("Teste verifica se 17 é número octal");
        System.out.println(" ... " + testeVerificarOctal(17));

        //Teste falso
        System.out.print("Teste verificar se 18 é número octal");
        System.out.println(" ... " + testeVerificarOctal(18));

        //Teste válido conversorOctal
        System.out.print("Teste conversor de base octal para decimal do número 12");
        System.out.println(" ... " + testeConversorOctal(12));
    }

    //Testa a classe VerificarOctal 
    private static String testeVerificarOctal(int n) {
        
        if (Ex7.verificarOctal(n) == true) {
            
            return "Sucesso!";
            
        }
        return "Falhou!";
        
    }

    //Testar verificador de número octal
    private static String testeConversorOctal(int n) {
        
        if (Ex7.corversorOctal(n) == 10) {
            
            return "Sucesso!";
        }
        
        return "Falhou!";
    }
}
