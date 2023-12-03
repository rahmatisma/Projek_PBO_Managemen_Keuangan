import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Opsion {
    int pilihan;

    public void Pilih() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Transaksi transaksi = new Transaksi();
        HistoryPemasukan pemasukan = new HistoryPemasukan();
        int pilihan = 6;
        double saldo = pemasukan.getSaldo();

        do {
            System.out.println("\n<==========Aplikasi Catatan Keuangan==========>\n");
            System.out.println("1. Cek Saldo Anda");
            System.out.println("2. Pemasukan Anda");
            System.out.println("3. Riwayat Pemasukan");
            System.out.println("4. Menambah Transaksi");
            System.out.println("5. Riwayat Transaksi");
            System.out.println("6. Keluar");

            System.out.print("Masukan Pilihan : ");
            try {
                pilihan = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Harap inputkan nilai dari 1-6");
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\nSaldo Anda Adalah : " + saldo + "\n");
                    break;
                case 2:
                    saldo = pemasukan.Pemasukan(saldo);
                    break;
                case 3:
                    pemasukan.RiwayatPemasukan();
                    break;
                case 4:
                    saldo = transaksi.Pengeluaran(saldo);
                    break;
                case 5:
                    transaksi.RiwayatPengeluaran();
                    break;
                case 6:
                    System.out.println("Terimakasih Telah Menggunakan Aplikasi ini");
                    break;
                default:
                    System.out.println("Pilihan tidak Valid");
            }
        } while (pilihan != 6);
    }
}