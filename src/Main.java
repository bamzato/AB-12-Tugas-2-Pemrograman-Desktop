import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int jumlah = 0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.print("Masukkan jumlah pesanan: ");
                jumlah = input.nextInt();

                if (jumlah <= 0) {
                    System.out.println("Jumlah pesanan harus lebih dari 0!");
                } else {
                    inputValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                input.next();
            }
        }

        System.out.println("Jumlah pesanan: " + jumlah);
        System.out.println("Program selesai.");
        input.close();
    }
}
