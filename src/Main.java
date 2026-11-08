import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean aplikasiBerjalan = true;

        while (aplikasiBerjalan) {
            System.out.println("\n====================================");
            System.out.println("          RESTORAN MAKANAN");
            System.out.println("====================================");
            System.out.println("1. Tampilkan Menu Restoran");
            System.out.println("2. Tambah Menu Baru");
            System.out.println("3. Buat Pesanan");
            System.out.println("4. Lihat Struk Tersimpan");
            System.out.println("5. Keluar");
            System.out.println("====================================");

            try {
                System.out.print("Pilih menu (1-5): ");
                int pilihan = input.nextInt();

                switch (pilihan) {
                    case 1:
                        System.out.println("Fitur tampilkan menu belum tersedia.");
                        break;

                    case 2:
                        System.out.println("Fitur tambah menu belum tersedia.");
                        break;

                    case 3:
                        System.out.println("Fitur buat pesanan belum tersedia.");
                        break;

                    case 4:
                        System.out.println("Fitur lihat struk belum tersedia.");
                        break;

                    case 5:
                        aplikasiBerjalan = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi Restoran Makanan.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih angka 1-5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                input.nextLine();
            }
        }

        input.close();
    }
}
