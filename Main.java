import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del vendedor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el área de trabajo: ");
        String area = scanner.nextLine();

        System.out.print("Ingrese el monto vendido: ");
        double monto = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de comisión: ");
        double comision = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de cumplimiento de meta: ");
        double cumplimiento = scanner.nextDouble();

        Vendedor vendedor1 = new Vendedor(nombre, area, monto, comision, cumplimiento);

        System.out.println("\nGenerando resultados...");
        vendedor1.mostrarReporte();

        scanner.close();




    }

}