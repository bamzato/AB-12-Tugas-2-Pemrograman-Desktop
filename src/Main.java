import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        MenuFileManager menuFileManager = new MenuFileManager("data/menu.txt");
        menuFileManager.muatMenu(menu);

        boolean aplikasiBerjalan = true;
        while (aplikasiBerjalan) {
            System.out.println("\n====================================");
            System.out.println("          RESTORAN MAKANAN");
            System.out.println("====================================");
            System.out.println("1. Tampilkan Menu Restoran");
            System.out.println("2. Tambah Menu Baru");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Buat Pesanan");
            System.out.println("5. Lihat Struk Tersimpan");
            System.out.println("6. Keluar");
            System.out.println("====================================");

            try {
                System.out.print("Pilih menu (1-5): ");
                int pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {
                    case 1:
                        System.out.println("\n========== DAFTAR MENU RESTORAN ==========");
                        menu.tampilkanMenu();
                        break;

                    case 2: {
                        int pilihanTambah = tampilkanSubmenuTambahMenu(input);

                        switch (pilihanTambah) {
                            case 1:
                                tambahMakanan(input, menu, menuFileManager);
                                break;

                            case 2:
                                tambahMinuman(input, menu, menuFileManager);
                                break;

                            case 3:
                                tambahDiskon(input, menu, menuFileManager);
                                break;

                            case 4:
                                System.out.println("Kembali ke menu utama.");
                                break;

                            default:
                                System.out.println("Pilihan submenu tidak valid.");
                        }

                        break;
                    }

                    case 3:
                        hapusMenu(input, menu, menuFileManager);
                        break;

                    case 4:
                        System.out.println("Fitur buat pesanan belum tersedia.");
                        break;

                    case 5:
                        System.out.println("Fitur lihat struk belum tersedia.");
                        break;

                    case 6:
                        aplikasiBerjalan = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi Restoran Makanan.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih angka 1-6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }

        input.close();
    }

    private static int tampilkanSubmenuTambahMenu(Scanner input) {
        System.out.println("\n====================================");
        System.out.println("           TAMBAH MENU BARU");
        System.out.println("====================================");
        System.out.println("1. Tambah Makanan");
        System.out.println("2. Tambah Minuman");
        System.out.println("3. Tambah Diskon");
        System.out.println("4. Kembali");
        System.out.println("====================================");

        System.out.print("Pilih jenis menu: ");

        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka.");
            return 0;
        }
    }

    private static void tambahMakanan(Scanner input, Menu menu, MenuFileManager menuFileManager) {
        try {
            System.out.println("\n========== TAMBAH MAKANAN ==========");

            System.out.print("Nama makanan: ");
            String nama = input.nextLine();

            System.out.print("Harga makanan: ");
            double harga = Double.parseDouble(input.nextLine());

            System.out.print("Jenis makanan: ");
            String jenisMakanan = input.nextLine();

            Makanan makanan = new Makanan(nama, harga, jenisMakanan);

            menu.tambahMenu(makanan);
            menuFileManager.simpanMenu(menu);

            System.out.println("Makanan berhasil ditambahkan.");
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka.");
        } catch (IllegalArgumentException e) {
            System.out.println("Data makanan tidak valid: " + e.getMessage());
        }
    }

    private static void tambahMinuman(Scanner input, Menu menu, MenuFileManager menuFileManager) {

        try {
            System.out.println("\n========== TAMBAH MINUMAN ==========");

            System.out.print("Nama minuman: ");
            String nama = input.nextLine();

            System.out.print("Harga minuman: ");
            double harga = Double.parseDouble(input.nextLine());

            System.out.print("Jenis minuman: ");
            String jenisMinuman = input.nextLine();

            Minuman minuman = new Minuman(nama, harga, jenisMinuman);

            menu.tambahMenu(minuman);
            menuFileManager.simpanMenu(menu);

            System.out.println("Minuman berhasil ditambahkan.");
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka.");
        } catch (IllegalArgumentException e) {
            System.out.println("Data minuman tidak valid: " + e.getMessage());
        }
    }

    private static void tambahDiskon(Scanner input, Menu menu, MenuFileManager menuFileManager) {

        try {
            System.out.println("\n========== TAMBAH DISKON ==========");

            System.out.print("Nama diskon: ");
            String nama = input.nextLine();

            System.out.print("Persentase diskon (%): ");
            double persentase = Double.parseDouble(input.nextLine());

            Diskon diskon = new Diskon(nama, persentase);

            menu.tambahMenu(diskon);
            menuFileManager.simpanMenu(menu);

            System.out.println("Diskon berhasil ditambahkan.");

        } catch (NumberFormatException e) {
            System.out.println("Persentase diskon harus berupa angka.");

        } catch (IllegalArgumentException e) {
            System.out.println("Data diskon tidak valid: " + e.getMessage());
        }
    }

    private static void hapusMenu(Scanner input, Menu menu, MenuFileManager menuFileManager) {
        try {
            System.out.println("\n========== HAPUS MENU ==========");

            if (menu.getDaftarMenu().isEmpty()) {
                System.out.println("Daftar menu masih kosong.");
                return;
            }

            menu.tampilkanMenu();
            System.out.print("Pilih nomor menu yang akan dihapus: ");
            int pilihan = Integer.parseInt(input.nextLine());

            menu.hapusMenu(pilihan - 1);

            menuFileManager.simpanMenu(menu);

            System.out.println("Menu berhasil dihapus.");

        } catch (NumberFormatException e) {
            System.out.println("Pilihan harus berupa angka.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nomor menu tidak ditemukan.");
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
