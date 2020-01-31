package testesunitarios;

import classes.Ex9;

/**
 *
 * @author bruno
 */
public class TesteUnitariosEx9 {
    
    public static void main(String[] args) {
        
        System.out.print("Teste classe Fibonacci");
        System.out.println(" ... " + testeFibonacci(7));
        
    }
    
    private static String testeFibonacci(int n) {
        
        if (Ex9.fibonacci(n) == 13) {
            
            return "Sucesso!";
        }
        return "Falhou!";
    }
}
