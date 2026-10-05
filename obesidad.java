import java.util.Scanner;

public class obesidad {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("cual es tu peso?");
            float peso = scanner.nextFloat();

            System.out.println("cual es tu altura?");
            float altura = scanner.nextFloat();

            float IMC = peso / (altura * altura);

            System.out.println("Tu IMC ES " + IMC);

            int grado = 0;

            if (IMC < 18.5) {
                System.out.println("tienes bajo peso");
            }

            if (IMC >= 18.5 && IMC < 25) {
                System.out.println("tu peso es normal");
            }

            if (IMC >= 25 && IMC < 30) {
                System.out.println("Tienes sobrepeso");
            }

            if (IMC >= 30 && IMC < 35) {
                System.out.println("tienes obesidad de clase 1");
                grado = 1;
            }

            if (IMC >= 35 && IMC < 40) {
                System.out.println("tienes obesidad de clase 2");
                grado = 2;
            }

            if (IMC >= 40) {
                System.out.println("tienes obesidad de clase 3");
                grado = 3;
            }

            switch (grado) {
                case 1:
                    System.out.println("Acción 1: Iniciar un plan de déficit calórico guiado por un nutriólogo.");
                    System.out.println("Acción 2: Realizar un chequeo médico general (glucosa y perfil lipídico).");
                    break;
                case 2:
                    System.out.println("Acción 1: Asistir a consulta multidisciplinaria (médico y especialista en nutrición).");
                    System.out.println("Acción 2: Iniciar rutina de ejercicio de bajo impacto articular.");
                    break;
                case 3:
                    System.out.println("Acción 1: Solicitar valoración médica prioritaria para evaluar comorbilidades.");
                    System.out.println("Acción 2: Evaluar protocolo de bariatría o tratamientos médicos especializados.");
                    break;
                default:
                    System.out.println("Estas sano");
                    break;
            }

            System.out.println("¿Deseas calcular otro IMC? (1 = Sí, 0 = No)");
            opcion = scanner.nextInt();

        } while (opcion == 1);

        System.out.println("Programa terminado.");

        scanner.close(); 
    }
}