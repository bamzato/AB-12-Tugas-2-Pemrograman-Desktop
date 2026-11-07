
public class Makanan extends MenuItem {
    // 1. Atribut khusus makanan
    private String jenisMakanan;

    // 2. Constructor
    public Makanan(String nama, double harga, String jenisMakanan) {
        super(nama, harga, "Makanan");
        this.setJenisMakanan(jenisMakanan);
    }

    // 3. Getter
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    // 4. Setter
    public void setJenisMakanan(String jenisMakanan) {
        if (jenisMakanan == null || jenisMakanan.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Jenis makanan tidak boleh kosong.");
        }

        this.jenisMakanan = jenisMakanan;
    }

    // 5. Method overriding
    @Override
    public void tampilMenu() {
        System.out.println("Nama           : " + this.getNama());
        System.out.println("Harga          : Rp " + this.getHarga());
        System.out.println("Kategori       : " + this.getKategori());
        System.out.println("Jenis Makanan  : " + this.getJenisMakanan());
    }
}
