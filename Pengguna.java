import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pengguna implements InterfaceOperasiKeuangan{
    protected double saldo = 0;
    protected double pemasukan[];
    protected int tanggal[];
    protected int bulan[];
    protected String catatan[];
    protected int i = 0;
    private int Maxtanggal = 0;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Pengguna() {
        this.pemasukan = new double[100];
        this.tanggal = new int[100];
        this.bulan = new int[100];
        this.catatan = new String[100];
    }

    @Override
    public double Pemsukan(double saldo) {
        System.out.println("Masukkan Nominal Pemasukan anda : ");
        try {
            pemasukan[i] = Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Harap inputkan pemasukan anda dengan benar");
        }
        
        do {
            System.out.println("Masukkan Bulan pemasukan");
            try {
                bulan[i] = Integer.parseInt(reader.readLine());
                if (bulan[i] > 12) {
                    System.out.println("Masukkan Bulan yang benar");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Harap inputkan data yang benar");
            }
        } while (bulan[i] <= 0 || bulan[i] > 12);

        do {
            System.out.println("Masukan tanggal pemasukan");
            try {
                tanggal[i] = Integer.parseInt(reader.readLine());
                switch (bulan[i]) {
                    case 1 : //Januari
                    Maxtanggal = 31;
                    break;
                    case 2 : //Febuari
                    Maxtanggal = 28;
                    break;
                    case 3 : //Maret
                    Maxtanggal = 31;
                    break;
                    case 4 : //April
                    Maxtanggal = 30;
                    break;
                    case 5 : //Mei
                    Maxtanggal = 31;
                    break;
                    case 6 : //Juni
                    Maxtanggal = 30;
                    break;
                    case 7 : //Juli
                    Maxtanggal = 31;
                    break;
                    case 8 : //Agustus
                    Maxtanggal = 31;
                    break;
                    case 9 : //September
                    Maxtanggal = 30;
                    break;
                    case 10 : //Oktober
                    Maxtanggal = 31;
                    break;
                    case 11 : //November
                    Maxtanggal = 30;
                    break;
                    case 12 : //Desember
                    Maxtanggal = 31;
                    break;
                    default:
                    System.out.println("Bulan tidak valid");
                } 
                if (tanggal[i] < 0 || tanggal[i] > Maxtanggal) {
                    System.out.println("Masukkan tanggal yang benar (1-" + Maxtanggal + ")");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Harap inputkan data yang benar");
                continue;
            }
        } while (tanggal[i] > Maxtanggal && tanggal[i] > 0);

        System.out.println("Catatan : ");
        try {
            catatan[i] = reader.readLine();
        } catch (IOException e) {
            System.out.println("Harap masukan Catatan");
        }
        saldo = saldo + pemasukan[i];
        i++;
        return saldo;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo=saldo;
    }
}