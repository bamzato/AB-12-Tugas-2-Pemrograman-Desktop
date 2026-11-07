public class DetailPesanan {
    // 1. Atribut
    private MenuItem menuItem;
    private int jumlah;

    // 2. Constructor
    public DetailPesanan(MenuItem menuItem, int jumlah) {
        setMenuItem(menuItem);
        setJumlah(jumlah);
    }

    // 3. Getter
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getJumlah() {
        return jumlah;
    }

    // 4. Setter
    public void setMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item tidak boleh null.");
        }

        this.menuItem = menuItem;
    }

    public void setJumlah(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah pesanan harus lebih dari 0.");
        }

        this.jumlah = jumlah;
    }

    // 5. Menghitung subtotal
    public double hitungSubtotal() {
        return menuItem.getHarga() * jumlah;
    }
}