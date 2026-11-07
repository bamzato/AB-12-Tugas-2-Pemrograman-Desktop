
public class Diskon extends MenuItem {
    // 1. Atribut khusus diskon
    private double diskon;

    // 2. Constructor
    public Diskon(String nama, double diskon) {
        super(nama, 0, "Diskon");
        this.setDiskon(diskon);
    }

    // 3. Getter
    public double getDiskon() {
        return diskon;
    }

    // 4. Setter
    public void setDiskon(double diskon) {
        if (diskon < 0 || diskon > 100) {
            throw new IllegalArgumentException(
                    "Persentase diskon harus antara 0 sampai 100.");
        }

        this.diskon = diskon;
    }

    // 5. Method overriding
    @Override
    public void tampilMenu() {
        System.out.println("Nama           : " + this.getNama());
        System.out.println("Kategori       : " + this.getKategori());
        System.out.println("Diskon         : " + this.getDiskon() + "%");
    }
}
