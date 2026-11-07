public abstract class MenuItem {
    // 1. Atribut
    private String nama;
    private double harga;
    private String kategori;

    // 2. Constructor
    public MenuItem(String nama, double harga, String kategori) {
        this.setNama(nama);
        this.setHarga(harga);
        this.setKategori(kategori);
    }

    // 3. Getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    // 4. Setter
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama menu tidak boleh kosong.");
        }

        this.nama = nama;
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException(
                    "Harga menu tidak boleh negatif.");
        }

        this.harga = harga;
    }

    public void setKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Kategori menu tidak boleh kosong.");
        }

        this.kategori = kategori;
    }

    // 5. Abstract method
    public abstract void tampilMenu();
}
