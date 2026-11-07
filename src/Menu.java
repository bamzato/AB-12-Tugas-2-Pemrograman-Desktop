import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> daftarMenu;

    public Menu() {
        this.daftarMenu = new ArrayList<>();
    }

    public ArrayList<MenuItem> getDaftarMenu() {
        return new ArrayList<>(daftarMenu);
    }

    public void setDaftarMenu(ArrayList<MenuItem> daftarMenu) {
        if (daftarMenu == null) {
            throw new IllegalArgumentException(
                    "Daftar menu tidak boleh null.");
        }

        this.daftarMenu = new ArrayList<>(daftarMenu);
    }

    public void tambahMenu(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "Item menu tidak boleh null.");
        }

        daftarMenu.add(item);
    }

    public void hapusMenu(int indeks) {
        if (indeks < 0 || indeks >= daftarMenu.size()) {
            throw new IndexOutOfBoundsException(
                    "Indeks menu tidak ditemukan.");
        }

        daftarMenu.remove(indeks);
    }

    public void tampilkanMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Daftar menu masih kosong.");
            return;
        }

        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.println("\nMenu ke-" + (i + 1));
            daftarMenu.get(i).tampilMenu();
            System.out.println("-------------------------");
        }
    }
}