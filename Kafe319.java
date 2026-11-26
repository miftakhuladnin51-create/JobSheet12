import java.util.Scanner;

public class Kafe319 {

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15.000");
        System.out.println("2. Cappuccino - Rp 20.000");
        System.out.println("3. Latte - Rp 22.000");
        System.out.println("4. Teh Tarik - Rp 12.000");
        System.out.println("5. Roti Bakar - Rp 10.000");
        System.out.println("6. Mie Goreng - Rp 18.000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan");
    }

    public static int hitungTotalHarga17(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {
            15000, 20000, 22000, 12000, 10000, 18000
        };

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Menu("Andi", true, 15);

        System.out.print("Masukkan nomor menu: ");
        int pilihanMenu = input.nextInt();

        System.out.print("Masukkan jumlah item: ");
        int banyakItem = input.nextInt();

        int totalBayar = hitungTotalHarga17(
            pilihanMenu, banyakItem
        );

        System.out.println("Total harga: Rp " + totalBayar);

        input.close();
    }
}