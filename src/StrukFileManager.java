import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StrukFileManager {

    public void simpanStruk(Pesanan pesanan, String namaFile) {
        if (pesanan == null) {
            throw new IllegalArgumentException("Pesanan tidak boleh null.");
        }

        if (namaFile == null || namaFile.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama file tidak boleh kosong.");
        }

        File direktori = new File("data/receipts");

        if (!direktori.exists()) {
            direktori.mkdirs();
        }

        File file = new File(direktori, namaFile);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(pesanan.buatStruk());
            System.out.println("Struk berhasil disimpan: " + file.getPath());
        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk: " + e.getMessage());
        }
    }

    public void bacaStruk(String namaFile) {
        File file = new File("data/receipts", namaFile);

        if (!file.exists()) {
            System.out.println("File struk tidak ditemukan.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;

            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }

        } catch (IOException e) {
            System.out.println("Gagal membaca struk: " + e.getMessage());
        }
    }
}