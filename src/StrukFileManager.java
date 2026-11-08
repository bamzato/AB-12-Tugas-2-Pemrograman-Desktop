import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

    private File[] ambilDaftarStruk() {
        File direktori = new File("data/receipts");

        if (!direktori.exists() || !direktori.isDirectory()) {
            return new File[0];
        }

        File[] daftarFile = direktori.listFiles(
                (dir, nama) -> nama.toLowerCase().endsWith(".txt"));

        return daftarFile != null ? daftarFile : new File[0];
    }

    public void tampilkanDaftarStruk() {
        File[] daftarFile = ambilDaftarStruk();

        if (daftarFile.length == 0) {
            System.out.println("Belum ada struk yang tersimpan.");
            return;
        }

        System.out.println("\n========== STRUK TERSIMPAN ==========");

        for (int i = 0; i < daftarFile.length; i++) {
            System.out.printf("%d. %s%n", i + 1, daftarFile[i].getName());
        }

        System.out.println("=====================================");
    }

    public void pilihStruk(Scanner input) {
        File[] daftarFile = ambilDaftarStruk();

        if (daftarFile.length == 0) {
            System.out.println("Belum ada struk yang tersimpan.");
            return;
        }

        tampilkanDaftarStruk();
        System.out.print("Pilih nomor struk yang ingin dilihat: ");
        try {
            int pilihan = Integer.parseInt(input.nextLine());

            if (pilihan < 1 || pilihan > daftarFile.length) {
                System.out.println("Nomor struk tidak valid.");
                return;
            }

            String namaFile = daftarFile[pilihan - 1].getName();

            System.out.println("\n========== DETAIL STRUK ==========");
            bacaStruk(namaFile);
        } catch (NumberFormatException e) {
            System.out.println("Pilihan harus berupa angka.");
        }
    }
}