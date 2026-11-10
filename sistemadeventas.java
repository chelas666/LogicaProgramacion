
    public static void main(String[] args) {

        // ===== 1. INICIALIZACIÓN =====
        String[] productos = {"Chocolate", "Paleta", "Gomitas", "Galletas"};
        double[] precios = {18, 12, 25, 15};
        int[] unidadesVendidas = new int[4];          // sección 4
        ArrayList<String> clientes = new ArrayList<>();

        double totalBruto = 0;
        double totalRecaudado = 0;
        double totalDescuentos = 0;

        // ===== 2. REGISTRO DE CLIENTES =====
        int numClientes = leerEntero("¿Cuántos clientes se atenderán hoy? ", 1,
                "Error: debe ser un número entero mayor que cero.");

        for (int i = 1; i <= numClientes; i++) {
            System.out.print("\nNombre del cliente " + i + ": ");
            String nombre = sc.nextLine().trim();
            while (nombre.isEmpty()) {
                System.out.print("El nombre no puede estar vacío. Intenta de nuevo: ");
                nombre = sc.nextLine().trim();
            }
            clientes.add(nombre);

            // ===== 3. REGISTRO DE COMPRAS (ciclo anidado) =====
            double totalCliente = 0;
            String otro;

            do {
                System.out.println("\n--- Catálogo ---");
                for (int p = 0; p < productos.length; p++) {
                    System.out.println((p + 1) + ". " + productos[p] + " - $" + (int) precios[p]);
                }

                int codigo;
                do {
                    codigo = leerEntero("Código del producto (1-4): ", Integer.MIN_VALUE,
                            "Error: ingresa un número entero.");
                    if (codigo < 1 || codigo > 4) {
                        System.out.println("Código inválido. Debe estar entre 1 y 4.");
                    }
                } while (codigo < 1 || codigo > 4);

                int cantidad = leerEntero("Cantidad: ", 1,
                        "Error: la cantidad debe ser un entero mayor que cero.");

                // switch para identificar el producto
                int indice;
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
                    default:
                        indice = -1;
                        break;
                }

                double importe = cantidad * precios[indice];
                totalCliente += importe;
                unidadesVendidas[indice] += cantidad;

                System.out.println("Agregado: " + cantidad + " x " + productos[indice]
                        + " = $" + importe);

                do {
                    System.out.print("¿Desea agregar otro producto? (s/n): ");
                    otro = sc.nextLine().trim().toLowerCase();
                } while (!otro.equals("s") && !otro.equals("n"));

            } while (otro.equals("s"));

            // Descuento por cliente
            double descuento = 0;
            if (totalCliente >= MONTO_PARA_DESCUENTO) {
                descuento = totalCliente * PORCENTAJE_DESCUENTO;
            }
            double totalAPagar = totalCliente - descuento;

            System.out.println("\nSubtotal de " + nombre + ": $" + totalCliente);
            System.out.println("Descuento: $" + descuento);
            System.out.println("Total a pagar: $" + totalAPagar);

            totalBruto += totalCliente;
            totalDescuentos += descuento;
            totalRecaudado += totalAPagar;
        }

        // ===== 4. TABLA DE PRODUCTOS VENDIDOS =====
        System.out.println("\n==================== VENTAS POR PRODUCTO ====================");
        System.out.printf("%-12s %10s %10s %14s%n", "Producto", "Precio", "Unidades", "Importe bruto");
        for (int p = 0; p < productos.length; p++) {
            double importeBruto = unidadesVendidas[p] * precios[p];
            System.out.printf("%-12s %10.2f %10d %14.2f%n",
                    productos[p], precios[p], unidadesVendidas[p], importeBruto);
        }

        // ===== 5. REPORTE FINAL =====
        System.out.println("\n====================== REPORTE FINAL ======================");
        System.out.println("Total de clientes atendidos: " + clientes.size());

        System.out.println("\nClientes atendidos:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + clientes.get(i));
        }

        System.out.println("\nCantidad vendida por producto:");
        for (int p = 0; p < productos.length; p++) {
            System.out.println("  " + productos[p] + ": " + unidadesVendidas[p]);
        }

        System.out.printf("%nVenta bruta:                     $%.2f%n", totalBruto);
        System.out.printf("Descuentos aplicados:            $%.2f%n", totalDescuentos);
        System.out.printf("Total recaudado (con descuento): $%.2f%n", totalRecaudado);
        System.out.printf("Promedio de venta por cliente:   $%.2f%n", totalRecaudado / clientes.size());

        sc.close();
    }
}