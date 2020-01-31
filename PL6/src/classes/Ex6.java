package classes;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Ex6 {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        String op;

        double raio = 0;

        double altura;

        System.out.println("Qual a figura geométrica que quer calcular a Área?(esfera, cilindro,cone)");
        op = ler.nextLine();

        while (!op.equalsIgnoreCase("FIM")) {

            if (op.equalsIgnoreCase("esfera") || op.equalsIgnoreCase("cilindro") || op.equalsIgnoreCase("cone")) {

                System.out.println("Qual o raio da figura?");
                raio = ler.nextDouble();
            }
            if (op.equalsIgnoreCase("cilindro")) {

                System.out.println("Qual a altura do cilindro?");
                altura = ler.nextDouble();

                double volumeCilindro = calcularVolumeCilindro(raio, altura);

                System.out.printf("O Volume do Cilindro é de: %.2f m³", volumeCilindro);
                System.out.println("");

            } else if (op.equalsIgnoreCase("esfera")) {

                double volumeEsfera = calcularVolumeEsfera(raio);

                System.out.printf("O volume da Esfera é de %.2f m³", volumeEsfera);
                System.out.println("");
            } else if (op.equalsIgnoreCase("cone")) {

                System.out.println("Qual a altura do Cone?");
                altura = ler.nextDouble();

                double volumeCone = calcularVolumeCone(raio, altura);

                System.out.printf("O volume do Cone é de %.2f m³", volumeCone);
                System.out.println("");
            }

            System.out.println("Qual a figura geométrica que quer calcular a Área?(esfera, cilindro,cone)");
            op = ler.next();
        }
    }

    /**
     * Cálcula o volume do cilindro
     *
     * @param raio número decimal não negativo
     * @param altura número decimal não negativo
     * @return valor do volume do Cilindro
     */
    public static double calcularVolumeCilindro(double raio, double altura) {

        double calcVolume;

        calcVolume = (Math.PI) * (Math.pow(raio, 2) * altura);

        return calcVolume;
    }

    /**
     * Cálcula o volume de uma esfera
     *
     * @param raio número decimal não negativo
     * @return valor do volume da Esfera
     */
    public static double calcularVolumeEsfera(double raio) {

        double calcVolume;

        calcVolume = ((4 / 3) * (Math.PI * Math.pow(raio, 3)));

        return calcVolume;
    }

    /**
     * Cálcula o volume de um Cone
     *
     * @param raio número decimal não negativo
     * @param altura número decimal não negativo
     * @return valor do volume do Cone
     */
    public static double calcularVolumeCone(double raio, double altura) {

        double calcVolume;

        calcVolume = ((Math.PI) * (Math.pow(raio, 2)) * (altura)) / 3;

        return calcVolume;
    }
}
