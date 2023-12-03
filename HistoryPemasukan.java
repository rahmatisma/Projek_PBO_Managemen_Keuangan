import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HistoryPemasukan extends Pengguna {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void RiwayatPemasukan() {
        System.out.println("\n==========Riwayat Pemasukan==========\n");

        if (super.i == 0) {
            System.out.println("Tidak ada riwayat pemasukan.");
        } else {
            for (int p = 0; p < super.i; p++) {
                System.out.println(p + 1 + " Pemasukan : Rp." + pemasukan[p]);
                System.out.println("  Bulan : " + bulan[p]);
                System.out.println("  Tanggal : " + tanggal[p]);
                System.out.println("  Catatan : " + catatan[p] + "\n");
            }
        }
    }
}
