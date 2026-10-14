
import java.util.Scanner;

public class ciclosanidados {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalDias = 2;
        int totalSabores = 3;

        String[] sabores = {"Fresa", "Coco", "Limon"};
        double[] precios = {15, 12, 18};

        int totalPaletas = 0;
        double totalDinero = 0;

        for (int dia = 1; dia <= totalDias; dia++) {
            int paletasDia = 0;
            double dineroDia = 0;

            System.out.println("\nDia " + dia);

            for (int i = 0; i < totalSabores; i++) {
                System.out.print("¿Cuantas paletas de "
                        + sabores[i] + " se vendieron? ");

                int cantidad = sc.nextInt();

                paletasDia += cantidad;
                dineroDia += cantidad * precios[i];
            }

            System.out.println("Total de paletas del dia: "
                    + paletasDia);

            System.out.println("Dinero total del dia: $"
                    + dineroDia);

            totalPaletas += paletasDia;
            totalDinero += dineroDia;
        }

        System.out.println("\nTotal de paletas vendidas: "
                + totalPaletas);

        System.out.println("Dinero total de los 2 dias: $"
                + totalDinero);

        sc.close();
    }
}



    

