import java.util.Scanner;
public class MainSPBU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListAntrian antrian = new LinkedListAntrian();
        QueueTransaksi riwayat = new QueueTransaksi(100);

        int pilih;
        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String plat = sc.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = sc.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = sc.nextLine();
                    Kendaraan k = new Kendaraan(plat, tipe, merk);
                    antrian.tambahAntrian(k);
                    System.out.println(">> Kendaraan masuk ke dalam antrian.");
                    break;
                case 2:
                    System.out.println("-- Antrian Kendaraan --");
                    System.out.println("Antrian Kendaraan:");
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrian.hitungAntrian());
                    break;
                case 4:
                    if (antrian.isEmpty()) {
                        System.out.println(">> Antrian kosong.");
                        break;
                    }
                    Kendaraan dilayani = antrian.layaniKendaraan();
                    System.out.println("Petugas melayani " + dilayani.platNomor);
                    System.out.print("Masukkan Jenis BBM: ");
                    String jenisBBM = sc.nextLine();
                    System.out.print("Masukkan Harga per liter: ");
                    double harga = Double.parseDouble(sc.nextLine());
                    System.out.print("Masukkan Jumlah liter: ");
                    double liter = Double.parseDouble(sc.nextLine());
                    BBM bbm = new BBM(jenisBBM, harga);
                    TransaksiPengisian tr = new TransaksiPengisian(dilayani, bbm, liter);
                    riwayat.enqueue(tr);
                    System.out.println(">> Transaksi berhasil dicatat.");
                    break;
                case 5:
                    riwayat.tampilkanTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println(">> Pilihan tidak valid.");
            }
        } while (pilih != 0);
    }
}