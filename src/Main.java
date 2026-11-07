public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        // Menambahkan item menu
        menu.tambahMenu(new Makanan("Nasi Goreng", 25000, "Makanan Berat"));
        menu.tambahMenu(new Minuman("Es Teh", 5000, "Dingin"));
        menu.tambahMenu(new Diskon("Diskon Weekend", 15));

        // Menampilkan seluruh menu
        System.out.println("=== DAFTAR MENU RESTORAN ===");
        menu.tampilkanMenu();

        // Menghapus menu berdasarkan indeks
        System.out.println("\n=== SETELAH MENGHAPUS MENU ===");
        menu.hapusMenu(1);
        menu.tampilkanMenu();
    }
}