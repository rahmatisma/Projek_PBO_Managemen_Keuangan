import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Transaksi extends HistoryPemasukan {
    protected double pengeluaran[];
    private String catatanT[];
    private int bulanT[];
    private int tanggalT[];
    private int q=0;
    private int Maxtanggal = 0;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Transaksi() {
        this.pengeluaran = new double[100];
        this.catatanT = new String[100];
        this.bulanT = new int[100];
        this.tanggalT = new int[100];
    }

    public double Pengeluaran(double saldo) {
        System.out.println("Masukkan Nominal Pengeluaran anda : ");
        try {
            pengeluaran[q] = Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Harap inputkan pengeluaran anda dengan benar");
        }

        System.out.println("Catatan : ");
        try {
            catatanT[q] = reader.readLine();
        } catch (IOException e) {
            System.out.println("Harap masukkan Catatan");
        }

        do {
            System.out.println("Masukkan Bulan Pengeluaran");
            try {
                bulanT[q] = Integer.parseInt(reader.readLine());
                if (bulanT[q] > 12) {
                    System.out.println("Masukkan Bulan yang benar");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Harap inputkan data yang benar");
                q--;
            }
        } while (bulanT[i] <= 0 || bulanT[i] > 12);

        do {
            System.out.println("Masukan tanggal Pengeluaran");
            try {
                tanggalT[q] = Integer.parseInt(reader.readLine());
                switch (bulanT[q]) {
                    case 1: //Januari
                        Maxtanggal = 31;
                        break;
                    case 2: //Febuari
                        Maxtanggal = 28;
                        break;
                    case 3: //Maret
                        Maxtanggal = 31;
                        break;
                    case 4: //April
                        Maxtanggal = 30;
                        break;
                    case 5: //Mei
                        Maxtanggal = 31;
                        break;
                    case 6: //Juni
                        Maxtanggal = 30;
                        break;
                    case 7: //Juli
                        Maxtanggal = 31;
                        break;
                    case 8: //Agustus
                        Maxtanggal = 31;
                        break;
                    case 9: //September
                        Maxtanggal = 30;
                        break;
                    case 10: //Oktober
                        Maxtanggal = 31;
                        break;
                    case 11: //November
                        Maxtanggal = 30;
                        break;
                    case 12: //Desember
                        Maxtanggal = 31;
                        break;
                    default:
                        System.out.println("Bulan tidak valid");
                }
                if (tanggalT[q] < 0 || tanggalT[q] > Maxtanggal) {
                    System.out.println("Masukkan tanggal yang benar (1-" + Maxtanggal + ")");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Harap inputkan data yang benar");
                q--;
            }
            saldo = saldo - pengeluaran[q];
            q++;
        } while (tanggalT[q] > Maxtanggal && tanggalT[q] > 0);
        return saldo;
    }

    public void RiwayatPengeluaran() {
        int p;
        System.out.println("\n==========Riwayat Pengeluaran==========\n");
        for (p=0 ; p<=q-1 ; p++) {
            System.out.println(p+1 + " Pengeluaran : Rp." + pengeluaran[p]);
            System.out.println("  Catatan : " + catatanT[p]);
            System.out.println("  Bulan : " + bulanT[p]);
            System.out.println("  Tanggal : " + tanggalT[p] + "\n");
        }
    }

}