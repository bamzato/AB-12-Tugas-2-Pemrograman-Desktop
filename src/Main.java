public class Main {
    public static void main(String[] args) {

        MenuItem nasiGoreng = new Makanan(
                "Nasi Goreng", 25000, "Makanan Berat");

        MenuItem esTeh = new Minuman(
                "Es Teh", 5000, "Dingin");

        Pesanan pesananKosong = new Pesanan();
        pesananKosong.tampilkanPesanan();
    }
}