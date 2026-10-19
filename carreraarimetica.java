import java.util.Scanner;
import java.util.Random;
import java.util.Locale;
 
public class carreraarimetica {
    
public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
 
        sc.useLocale(Locale.US);
 
        float entrada, salida;
        int mes;
 
        System.out.println("CARRERA ARITMETICA");
 
        System.out.print("Dato de entrada: ");
        entrada = sc.nextFloat();
 
        System.out.print("Mes en el que naciste (1-12): ");
        mes = sc.nextInt();
 
        if (mes < 1 || mes > 12) {
            System.out.println("No se vale");
            sc.close();
            return;
        }
 
        // PROMEDIO DE 5 NUMEROS ENTEROS ALEATORIOS
        int suma = 0;
 
        System.out.println("PROMEDIO");
 
        for (int i = 1; i <= 5; i++) {
            int numero = random.nextInt(100) + 1;
            System.out.println("Numero " + i + ": " + numero);
            suma += numero;
        }
 
        float promedio = suma / 5.0f;
        salida = entrada + promedio;
 
        System.out.println("Promedio: " + promedio);
        System.out.println("Salida: " + salida);
 
        // RESIDUO ENTRE 7
        System.out.println("\nETAPA 2: RESIDUO DE ENTRADA % 7");
 
        entrada = salida;
        float residuo = entrada % 7;
        salida = entrada + residuo;
 
        System.out.println("Residuo: " + residuo);
        System.out.println("Salida: " + salida);
 
        // AUMENTAR 12 POR CIENTO
        System.out.println("\nETAPA 3: PORCENTAJE DEL 12%");
 
        entrada = salida;
        salida = (float) (entrada + (entrada * 0.12));
 
        System.out.println("Aumento: " + (entrada * 0.12));
        System.out.println("Salida: " + salida);
 
        // SUMA DE N VALORES ENTEROS
        System.out.println("\nETAPA 4: SUMA N VALORES ENTEROS");
 
        entrada = salida;
 
        System.out.print("Cuantos numeros enteros deseas sumar? ");
        int n = sc.nextInt();
 
        if (n <= 0) {
            System.out.println("N debe ser mayor que cero.");
            sc.close();
            return;
        }
 
        int sumaN = 0;
 
        for (int i = 1; i <= n; i++) {
            System.out.print("Introduce el numero " + i + ": ");
            sumaN += sc.nextInt();
        }
 
        salida = entrada + sumaN;
 
        System.out.println("Suma de los numeros: " + sumaN);
        System.out.println("Salida: " + salida);
 
        // DIVISION ENTRE 1 Y 9
        System.out.println("\nDIVISION ENTRE 1 Y 9");
 
        entrada = salida;
 
        System.out.print("Introduce el divisor: ");
        int divisor = sc.nextInt();
 
        if (divisor < 1 || divisor > 9) {
            System.out.println("El divisor debe estar entre 1 y 9.");
            sc.close();
            return;
        }
 
        salida = entrada / divisor;
 
        System.out.println("Salida final: " + salida);
 
        // MESES PARES Y NONES
        System.out.println("\n=== RESULTADO SEGUN TU MES ===");
 
        switch (mes) {
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                System.out.println("Mes par: " + mes);
                System.out.printf(
                    Locale.US,
                    "Salida como entero: %.0f%n",
                    salida
                );
                break;
 
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                System.out.println("Mes non: " + mes);
                System.out.printf(
                    Locale.US,
                    "Salida con 4 decimales: %.4f%n",
                    salida
                );
                break;
        }
 
        sc.close();
    }
}

