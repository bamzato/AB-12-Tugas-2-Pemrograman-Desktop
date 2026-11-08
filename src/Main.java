public class Main {
    public static void main(String[] args) {

        // =========================================
        // DATA MENU
        // =========================================

        Makanan nasiGoreng = new Makanan(
            "Nasi Goreng", 25000, "Makanan Berat"
        );

        Minuman esTeh = new Minuman(
            "Es Teh", 5000, "Minuman Dingin"
        );

        Diskon diskon15 = new Diskon(
            "Diskon Akhir Pekan", 15
        );

        Diskon diskon0 = new Diskon(
            "Diskon Member", 0
        );

        // =========================================
        // SKENARIO 1: TANPA DISKON
        // =========================================

        System.out.println("\n=== SKENARIO 1: TANPA DISKON ===");

        Pesanan pesanan1 = new Pesanan();

        pesanan1.tambahPesanan(nasiGoreng, 2);
        pesanan1.tambahPesanan(esTeh, 2);

        System.out.println("Subtotal: Rp " + pesanan1.hitungTotal());
        System.out.println("Diskon: Rp " + pesanan1.hitungNilaiDiskon());
        System.out.println("Total Bayar: Rp " + pesanan1.hitungTotalBayar());


        // =========================================
        // SKENARIO 2: DENGAN DISKON 15%
        // =========================================

        System.out.println("\n=== SKENARIO 2: DISKON 15% ===");

        Pesanan pesanan2 = new Pesanan();

        pesanan2.tambahPesanan(nasiGoreng, 2);
        pesanan2.tambahPesanan(esTeh, 2);
        pesanan2.setDiskon(diskon15);

        System.out.println("Subtotal: Rp " + pesanan2.hitungTotal());
        System.out.println("Diskon: Rp " + pesanan2.hitungNilaiDiskon());
        System.out.println("Total Bayar: Rp " + pesanan2.hitungTotalBayar());


        // =========================================
        // SKENARIO 3: DISKON 0%
        // =========================================

        System.out.println("\n=== SKENARIO 3: DISKON 0% ===");

        Pesanan pesanan3 = new Pesanan();

        pesanan3.tambahPesanan(nasiGoreng, 2);
        pesanan3.tambahPesanan(esTeh, 2);
        pesanan3.setDiskon(diskon0);

        System.out.println("Subtotal: Rp " + pesanan3.hitungTotal());
        System.out.println("Diskon: Rp " + pesanan3.hitungNilaiDiskon());
        System.out.println("Total Bayar: Rp " + pesanan3.hitungTotalBayar());


        // =========================================
        // SKENARIO 4: PESANAN KOSONG
        // =========================================

        System.out.println("\n=== SKENARIO 4: PESANAN KOSONG ===");

        Pesanan pesanan4 = new Pesanan();

        System.out.println("Subtotal: Rp " + pesanan4.hitungTotal());
        System.out.println("Diskon: Rp " + pesanan4.hitungNilaiDiskon());
        System.out.println("Total Bayar: Rp " + pesanan4.hitungTotalBayar());
    }
}