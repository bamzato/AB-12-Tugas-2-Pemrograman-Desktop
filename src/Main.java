public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        MenuFileManager fileManager = new MenuFileManager("data/menu.txt");

        // 1. Memuat menu dari file
        fileManager.muatMenu(menu);

        // 2. Menambahkan menu baru
        // menu.tambahMenu(new Makanan("Ayam Bakar", 30000, "Makanan Berat"));

        // menu.tambahMenu(new Minuman("Es Jeruk", 7000, "Minuman Dingin"));

        // 3. Menampilkan seluruh menu
        // System.out.println("DAFTAR MENU TERBARU");
        menu.tampilkanMenu();

        // 4. Menyimpan menu ke file
        // fileManager.simpanMenu(menu);

        // 5. Menampilkan jumlah menu
        System.out.println("\nTotal item menu: " + menu.getDaftarMenu().size());
    }
}