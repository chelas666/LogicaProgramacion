import java.util.Scanner;

public class vtavivero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        String[] productos = {"Cactus", "Suculenta", "Maceta", "Tierra", "Fertilizante"};
        double[] precios = {45.5, 35.5, 60.0, 80.0, 95.0};

        double[][] montos = new double[6][5];

        System.out.println(" VENTAS SEMANALES DEL VIVERO ");
        
        // 1. Capturar unidades y calcular montos
        for (int d = 0; d < dias.length; d++) {
            System.out.println("\n" + dias[d] + ":");
            for (int p = 0; p < productos.length; p++) {
                System.out.print("Dime la cantidad de " + productos[p] + " vendida: ");
                int unidades = sc.nextInt();
                
                montos[d][p] = unidades * precios[p];
            }
        }

        System.out.println("\n========================================");
        System.out.println("REPORTE DE VENTAS POR DÍA:");
        
        for (int d = 0; d < dias.length; d++) {
            System.out.print(dias[d] + ": ");
            double totalDia = 0;
            for (int p = 0; p < productos.length; p++) {
                System.out.print(montos[d][p] + " ");
                totalDia += montos[d][p];
            }
            System.out.println(" | Total día: " + totalDia);
        }

        System.out.println("\n========================================");
        System.out.println("REPORTE DE VENTAS POR PRODUCTO:");
        
        double totalGeneralSemana = 0;
        for (int p = 0; p < productos.length; p++) {
            System.out.print(productos + ": ");
            double totalProducto = 0;
            for (int d = 0; d < dias.length; d++) {
                System.out.print(montos[d][p] + " ");
                totalProducto += montos[d][p];
            }
            System.out.println("\n   -> Total vendido de " + productos[p] + ": " + totalProducto + "\n");
            totalGeneralSemana += totalProducto;
        }

        System.out.println("----------------------------------------");
        System.out.println("TOTAL GENERAL DE LA SEMANA: " + totalGeneralSemana);

        sc.close();
    }
}