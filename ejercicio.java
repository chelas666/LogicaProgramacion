import java.util.Scanner;

public class ejercicio {
    public static void main(String[] args) {
        Scanner consola = new Scanner (System.in);

int[] numeros = new int[10];

for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa el numero " + (i + 1) + ": ");
            numeros[i] = consola.nextInt();
        }

int mayor = numeros[0];
int menor = numeros[0];
int posMayor = 0;
int posMenor = 0;
for (int i = 1; i < numeros.length; i++) {
    if (numeros[i] > mayor) {
        mayor = numeros[i]; 
        posMayor = i;
    } else if (numeros[i] < menor) {
        menor = numeros[i];
        posMenor = i;
    }
}
System.out.println("el numero mayor es" +mayor); 
System.out.println("el numero mayor se encuentra en" +posMayor);

System.out.println("el numero menor es" +menor);
System.out.println("el numero mayor se encuentra en" +posMenor); 

consola.close();
}
}