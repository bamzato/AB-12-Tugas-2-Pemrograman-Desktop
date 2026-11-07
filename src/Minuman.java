
public class Minuman extends MenuItem {
    // 1. Atribut khusus minuman
    private String jenisMinuman;

    // 2. Constructor
    public Minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "Minuman");
        this.setJenisMinuman(jenisMinuman);
    }

    // 3. Getter
    public String getJenisMinuman() {
        return jenisMinuman;
    }

    // 4. Setter
    public void setJenisMinuman(String jenisMinuman) {
        if (jenisMinuman == null || jenisMinuman.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Jenis minuman tidak boleh kosong.");
        }

        this.jenisMinuman = jenisMinuman;
    }

    // 5. Method overriding
    @Override
    public void tampilMenu() {
        System.out.println("Nama           : " + this.getNama());
        System.out.println("Harga          : Rp " + this.getHarga());
        System.out.println("Kategori       : " + this.getKategori());
        System.out.println("Jenis Minuman  : " + this.getJenisMinuman());
    }
}
