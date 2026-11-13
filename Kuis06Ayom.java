import java.util.Scanner;

public class Kuis06Ayom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Jumlah pelanggan hari ini: ");
        int n = sc.nextInt();
        int totalBerat = 0, jumlahTarifTambahan = 0, totalBiaya = 0, biayaTertinggi = 0 , jumlahPelanggan = 0;
        int nim2 = 41;
        int kapasitas = (nim2 % 10) + 10; 

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Berat cucian pelanggan ke-" + i + " (kg): ");
            int arusMasuk = sc.nextInt();
            
            if (arusMasuk < 1 || arusMasuk > 20) {
                System.out.println("Input tidak valid, ulangi.");
                i--;
                continue;
            }

            int berat = arusMasuk;

            // Tarif: sampai 3 kg Rp 15000 (flat), lebih dari 3 kg ditambah Rp 4000 per kg kelebihannya
            int biaya;
            if (berat <= 3) {
                biaya = 15000;
            } else {
                biaya = 15000 + (berat - 3) * 4000;
                jumlahTarifTambahan++; 
            }
            
            totalBiaya += biaya;
            totalBerat += berat;
            jumlahPelanggan++;
            
            if (biaya > biayaTertinggi) {
                biayaTertinggi = biaya;
            }
            
            System.out.println("  Biaya: Rp " + biaya);
            if (totalBerat >= kapasitas) {
                System.out.println("Kapasitas total cucian (" + kapasitas + " kg) telah tercapai. Pendaftaran ditutup.");
                break;
            }
        }

        double rataBerat = (jumlahPelanggan > 0) ? (double) totalBerat / jumlahPelanggan : 0;

        System.out.println("=== REKAP HARIAN ===");
        System.out.println("Total pemasukan : Rp " + totalBiaya);
        System.out.println("Rata-rata berat : " + rataBerat + " kg");
        System.out.println("Biaya tertinggi : Rp " + biayaTertinggi);
        System.out.println("Jumlah pelanggan kena tarif tambahan : " + jumlahTarifTambahan);
    }
}