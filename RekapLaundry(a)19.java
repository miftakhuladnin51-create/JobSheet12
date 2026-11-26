import java.util.Scanner;
 
class RekapLaundry19 {
    static Scanner sc = new Scanner(System.in);
 
    static void inputData(int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < data.length; i++) {
            System.out.println("Layanan " + layanan[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.print("  Berat cucian hari " + hari[j] + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
    }
 
    static void tampilTabel(int[][] data, String[] layanan, int[] harga, String[] hari) {
        System.out.printf("%-15s%-12s", "Layanan", "Harga/kg");
        for (String h : hari) {
            System.out.printf("%-10s", h);
        }
        System.out.println();
 
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-15s%-12d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-10d", data[i][j]);
            }
            System.out.println();
        }
    }
 
    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }
 
    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan total cucian tertinggi: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }
 
    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = 0;
 
        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > totalMax) {
                totalMax = totalHari;
                idxMax = j;
            }
        }
        return idxMax;
    }
 
    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalPendapatan = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            totalPendapatan += pendapatan;
            System.out.printf("Pendapatan %-14s: Rp%,d%n", layanan[i], pendapatan);
        }
        System.out.printf("Total pendapatan            : Rp%,d%n", totalPendapatan);
    }
 
    public static void main(String[] args) {
        String[] layanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
        int[] harga = {6000, 8000, 5000, 12000};
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        int[][] data = new int[layanan.length][hari.length];
 
        inputData(data, layanan, hari);
 
        System.out.println("\n===== REKAP CUCIAN (kg) =====");
        tampilTabel(data, layanan, harga, hari);
 
        System.out.println();
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }
 
        System.out.println();
        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: " + hari[hariTersibuk(data)]);
 
        System.out.println("\n===== PENDAPATAN =====");
        tampilPendapatan(data, layanan, harga);
    }
}
