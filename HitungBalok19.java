import java.util.Scanner;

public class HitungBalok19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan panjang: ");
        int p = input.nextInt();
        System.out.print("Masukkan lebar: ");
        int l = input.nextInt();
        System.out.print("Masukkan tinggi: ");
        int t = input.nextInt();

        int luas = p * l;
        System.out.println("Luas persegi panjang adalah " + luas);

        int volume = (p * l) * t;
        System.out.println("Volume balok adalah " + volume);

        input.close();
    }
}

