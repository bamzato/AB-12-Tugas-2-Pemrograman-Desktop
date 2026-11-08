
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MenuFileManager {
    private String namaFile;

    public MenuFileManager(String namaFile) {
        this.namaFile = namaFile;
    }

    public void bacaFileMenu() {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file menu: " + e.getMessage());
        }
    }

    public void muatMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Objek Menu tidak boleh null.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] data = baris.split("\\|");

                String jenis = data[0];
                String nama = data[1];

                if (jenis.equalsIgnoreCase("MAKANAN")) {
                    double harga = Double.parseDouble(data[2]);
                    String jenisMakanan = data[3];

                    menu.tambahMenu(new Makanan(nama, harga, jenisMakanan));
                } else if (jenis.equalsIgnoreCase("MINUMAN")) {
                    double harga = Double.parseDouble(data[2]);
                    String jenisMinuman = data[3];

                    menu.tambahMenu(new Minuman(nama, harga, jenisMinuman));
                } else if (jenis.equalsIgnoreCase("DISKON")) {
                    double diskon = Double.parseDouble(data[2]);
                    menu.tambahMenu(new Diskon(nama, diskon));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file menu: " + e.getMessage());
        }
    }

    public void simpanMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Objek Menu tidak boleh null.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (MenuItem item : menu.getDaftarMenu()) {
                if (item instanceof Makanan) {
                    Makanan makanan = (Makanan) item;
                    writer.write("MAKANAN|" + makanan.getNama() + "|" + makanan.getHarga() + "|"
                            + makanan.getJenisMakanan());
                } else if (item instanceof Minuman) {
                    Minuman minuman = (Minuman) item;
                    writer.write("MINUMAN|" + minuman.getNama() + "|" + minuman.getHarga() + "|"
                            + minuman.getJenisMinuman());
                } else if (item instanceof Diskon) {
                    Diskon diskon = (Diskon) item;
                    writer.write("DISKON|" + diskon.getNama() + "|" + diskon.getDiskon());
                }
                writer.newLine();
            }
            System.out.println("Data menu berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file menu: " + e.getMessage());
        }
    }
}
