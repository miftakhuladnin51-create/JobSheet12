import java.util.Scanner;
 
public class TabungKerucut19 {
    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }
 
    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }
 
    static double luasPermukaanTabung(double r, double t) {
        return 2 * luasLingkaran(r) + 2 * Math.PI * r * t;
    }
 
    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
 
        do {
            System.out.println("\n===== MENU PERHITUNGAN =====");
            System.out.println("1. Luas lingkaran");
            System.out.println("2. Volume tabung");
            System.out.println("3. Luas permukaan tabung");
            System.out.println("4. Volume kerucut");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
 
            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan jari-jari (r): ");
                double r = sc.nextDouble();
                double t = 0;
 
                if (pilihan != 1) {
                    System.out.print("Masukkan tinggi (t): ");
                    t = sc.nextDouble();
                }
 
                switch (pilihan) {
                    case 1:
                        System.out.printf("Luas lingkaran = %.2f%n", luasLingkaran(r));
                        break;
                    case 2:
                        System.out.printf("Volume tabung = %.2f%n", volumeTabung(r, t));
                        break;
                    case 3:
                        System.out.printf("Luas permukaan tabung = %.2f%n", luasPermukaanTabung(r, t));
                        break;
                    case 4:
                        System.out.printf("Volume kerucut = %.2f%n", volumeKerucut(r, t));
                        break;
                }
            } else if (pilihan != 0) {
                System.out.println("Menu tidak tersedia");
            }
        } while (pilihan != 0);
 
        System.out.println("Program selesai.");
        sc.close();
    }
}

