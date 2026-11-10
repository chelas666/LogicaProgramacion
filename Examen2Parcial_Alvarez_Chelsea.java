import java.util.ArrayList;
import java.util.Scanner;

public class Examen2Parcial_Alvarez_Chelsea {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //productos y precios
        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18, 12, 25, 15};
        ArrayList<String> clientes = new ArrayList<>();
        int[] ventas = new int[4];

        // contadores
        double totalRecaudado = 0;

        int numeroDeClientes;
        do {
            System.out.print("¿Cuántos clientes se atendieron? ");
            numeroDeClientes = sc.nextInt();
            if (numeroDeClientes <= 0) {
                System.out.println("Debe ser un número mayor que cero.");
            }
        } while (numeroDeClientes <= 0);

        for (int i = 1; i <= numeroDeClientes; i++) {
            System.out.print("\nNombre del cliente " + i + ": ");
            String nombre = sc.next();
            clientes.add(nombre);

            // registro de compras
            double totalCliente = 0;
            String otro;

            do {
                // catálogo de productos
                System.out.println("1 Chocolate $18");
                System.out.println("2 Paleta $12");
                System.out.println("3 Gomitas $25");
                System.out.println("4 Galletas $15");

                // código de producto
                int codigo;
                do {
                    System.out.print("Código del producto (1-4): ");
                    codigo = sc.nextInt();
                    if (codigo < 1 || codigo > 4) {
                        System.out.println("Código inválido.");
                    }
                } while (codigo < 1 || codigo > 4);

                // cantidad
                int cantidad;
                do {
                    System.out.print("Cantidad: ");
                    cantidad = sc.nextInt();
                    if (cantidad <= 0) {
                        System.out.println("Debe ser mayor que cero.");
                    }
                } while (cantidad <= 0);

                int indice = 0;
                switch (codigo) {
                    case 1:
                        indice = 0;
                        break;
                    case 2:
                        indice = 1;
                        break;
                    case 3:
                        indice = 2;
                        break;
                    case 4:
                        indice = 3;
                        break;
                }

                totalCliente += cantidad * precios[indice];
                ventas[indice] += cantidad;

                System.out.print("¿Agregar otro producto? (si/no): ");
                otro = sc.next();

            } while (otro.equals("si") || otro.equals("SI"));

            // Descuento del 10% si compra $100 o más
            double descuento = 0;
            if (totalCliente >= 100) {
                descuento = totalCliente * 0.10;
            }

            System.out.println("Total de " + nombre + ": $" + (totalCliente - descuento));

            totalRecaudado += totalCliente - descuento;
        } 

        // Productos vendidos
        System.out.println("\nVentas por producto");
        for (int p = 0; p < 4; p++) {
            System.out.println(productos[p] + " | Precio: $" + precios[p]
                    + " | Vendidas: " + ventas[p]
                    + " | Importe bruto: $" + (ventas[p] * precios[p]));
        }

        // Reporte final
        System.out.println("\nReporte final:");
        System.out.println("Clientes atendidos: " + clientes.size());
        System.out.println("Lista de clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("- " + clientes.get(i));
        }

        System.out.println("Unidades vendidas por producto:");
        for (int p = 0; p < 4; p++) {
            System.out.println(productos[p] + ": " + ventas[p]);
        }

        System.out.println("Total recaudado (con descuentos): $" + totalRecaudado);
        System.out.println("Promedio por cliente: $" + (totalRecaudado / clientes.size()));

        sc.close();
    }
}
