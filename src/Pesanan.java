import java.util.ArrayList;

public class Pesanan {
    private ArrayList<DetailPesanan> daftarPesanan;
    private Diskon diskon;

    public Pesanan() {
        this.daftarPesanan = new ArrayList<>();
    }

    public ArrayList<DetailPesanan> getDaftarPesanan() {
        return new ArrayList<>(daftarPesanan);
    }

    public void setDaftarPesanan(ArrayList<DetailPesanan> daftarPesanan) {
        if (daftarPesanan == null) {
            throw new IllegalArgumentException("Daftar pesanan tidak boleh null.");
        }

        this.daftarPesanan = new ArrayList<>(daftarPesanan);
    }

    public void tambahPesanan(MenuItem menuItem, int jumlah) {
        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item tidak boleh null.");
        }

        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah pesanan harus lebih dari 0.");
        }

        // Mencari apakah menu sudah ada dalam daftar pesanan
        for (DetailPesanan detail : daftarPesanan) {
            if (detail.getMenuItem() == menuItem) {
                detail.setJumlah(detail.getJumlah() + jumlah);
                return;
            }
        }

        // Jika menu belum ada, buat detail pesanan baru
        daftarPesanan.add(new DetailPesanan(menuItem, jumlah));
    }

    public double hitungTotal() {
        double total = 0;

        for (DetailPesanan detail : daftarPesanan) {
            total += detail.hitungSubtotal();
        }

        return total;
    }

    public void tampilkanPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        System.out.println("\n======================== DETAIL PESANAN ========================");

        System.out.printf("%-20s %15s %8s %18s%n", "Nama Menu", "Harga", "Jumlah", "Subtotal");

        System.out.println("---------------------------------------------------------------");
        for (DetailPesanan detail : daftarPesanan) {
            System.out.printf(
                    "%-20s %15.2f %8d %18.2f%n",
                    detail.getMenuItem().getNama(),
                    detail.getMenuItem().getHarga(),
                    detail.getJumlah(),
                    detail.hitungSubtotal());
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf(
                "%-45s %18.2f%n",
                "TOTAL PESANAN",
                hitungTotal());
        System.out.println("===============================================================");
    }

    public Diskon getDiskon() {
        return diskon;
    }

    public void setDiskon(Diskon diskon) {
        this.diskon = diskon;
    }

    public double hitungNilaiDiskon() {
        if (diskon == null) {
            return 0;
        }

        return hitungTotal() * diskon.getDiskon() / 100;
    }

    public double hitungTotalBayar() {
        return hitungTotal() - hitungNilaiDiskon();
    }

    public String buatStruk() {
        if (daftarPesanan.isEmpty()) {
            return "Belum ada pesanan.";
        }

        StringBuilder struk = new StringBuilder();

        struk.append("========================================================\n");
        struk.append("                   RESTORAN MAKANAN                     \n");
        struk.append("                    STRUK PESANAN                       \n");
        struk.append("========================================================\n");

        struk.append(String.format("%-20s %12s %6s %14s%n", "Nama Menu", "Harga", "Jumlah", "Subtotal"));

        struk.append("-------------------------------------------------------- \n");

        for (DetailPesanan detail : daftarPesanan) {
            struk.append(String.format(
                    "%-20s %12.2f %6d %14.2f%n",
                    detail.getMenuItem().getNama(),
                    detail.getMenuItem().getHarga(),
                    detail.getJumlah(),
                    detail.hitungSubtotal()));
        }

        struk.append("-------------------------------------------------------- \n");

        struk.append(String.format(
                "%-40s %14.2f%n",
                "Subtotal",
                hitungTotal()));

        if (diskon != null) {
            struk.append(String.format(
                    "Diskon: %s (%.2f%%)%n",
                    diskon.getNama(),
                    diskon.getDiskon()));

            struk.append(String.format(
                    "%-40s %14.2f%n",
                    "Nilai Diskon",
                    -hitungNilaiDiskon()));
        } else {
            struk.append("Diskon: Tidak ada\n");
        }

        struk.append("-------------------------------------------------------- \n");

        struk.append(String.format(
                "%-40s %14.2f%n",
                "TOTAL PEMBAYARAN",
                hitungTotalBayar()));

        struk.append("========================================================\n");
        struk.append("           Terima kasih atas kunjungan Anda!            \n");
        struk.append("              Selamat menikmati hidangan.               \n");
        struk.append("========================================================\n");

        return struk.toString();
    }

    public void tampilkanStruk() {
        System.out.println(buatStruk());
    }
}