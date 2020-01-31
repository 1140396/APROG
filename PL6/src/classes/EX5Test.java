package classes;

/**
 *
 * @author bruno
 */
public class EX5Test {

    public static void main(String[] args) {

        digitos(965);
        System.out.println(digitos(965));
        comprarDig(95, 969);
    }

    private static int comprarDig(int a, int b) {

        int cont = 0;

        int expA = digitos(a);

        int expB = digitos(b);

        int auxDigitos;

        double auxA;

        int auxB;

        if (digitos(a) >= digitos(b)) {

            auxDigitos = digitos(a);
        } else {

            auxDigitos = digitos(b);
        }

        while (auxDigitos > 0) {

            auxA = (int) (a / Math.pow(10, auxDigitos - 1));

            a = (int) (a % Math.pow(10, auxDigitos));

            System.out.println(auxA);

            auxB = (int) (b / Math.pow(10, auxDigitos - 1));

            auxDigitos--;
        }
        return 0;
    }

    private static int digitos(int n) {

        int aux;

        int contDig = 0;

        while (n > 0) {

            aux = n % 10;

            n /= 10;

            contDig++;
        }

        return contDig;
    }
}
