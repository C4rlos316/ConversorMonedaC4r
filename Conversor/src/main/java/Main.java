import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CurrencyConverter converter = new CurrencyConverter();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Selecciona una opción:");
            System.out.println("1- Dólar a Peso Argentino");
            System.out.println("2- Peso Argentino a Dólar");
            System.out.println("3- Real Brasileño a Dólar");
            System.out.println("4- Dólar a Real Brasileño");
            System.out.println("5- Dólar a Peso Colombiano");
            System.out.println("6- Peso Colombiano a Dólar");
            System.out.println("7- Salir");

            int option = scanner.nextInt();
            if (option == 7) {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.print("Ingresa la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            try {
                double result = convertCurrency(option, amount);
                System.out.println("Resultado: " + result);
            } catch (IOException e) {
                System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double convertCurrency(int option, double amount) throws IOException {
        switch (option) {
            case 1:
                return converter.convert("USD", "ARS", amount);
            case 2:
                return converter.convert("ARS", "USD", amount);
            case 3:
                return converter.convert("BRL", "USD", amount);
            case 4:
                return converter.convert("USD", "BRL", amount);
            case 5:
                return converter.convert("USD", "COP", amount);
            case 6:
                return converter.convert("COP", "USD", amount);
            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }
}
