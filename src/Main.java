import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<FormulirPendaftaran> listPendaftaran = new ArrayList<>();
        int menu = 0;

        do {
            System.out.println("\n=== SISTEM PENDAFTARAN MAGANG ONLINE ===");
            System.out.println("1. Isi Form Pendaftaran Baru");
            System.out.println("2. Lihat Semua Status Pendaftaran");
            System.out.println("3. Update Status Pendaftaran (Admin)");
            System.out.println("4. Batalkan Pendaftaran");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");

            if (!sc.hasNextInt()) {
                System.out.println("Input harus angka!");
                sc.next(); continue;
            }
            menu = sc.nextInt(); sc.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.println("\n====================================");
                    System.out.println("       INPUT DATA MAHASISWA         ");
                    System.out.println("====================================");
                    
                    String nim;
                    while (true) {
                        System.out.print("Masukkan NIM  : ");
                        nim = sc.nextLine();
                        // Validasi menggunakan Regex: \\d+ artinya hanya boleh angka 0-9
                        if (nim.matches("\\d+")) {
                            break; // Keluar dari loop jika input benar
                        } else {
                            System.out.println(">> Error: NIM harus berupa angka! Tidak boleh huruf atau simbol.");
                        }
                    }
                    System.out.print("Masukkan Nama     : "); String nama = sc.nextLine();
                    System.out.print("Masukkan Jurusan  : "); String jurusan = sc.nextLine();
                    
                    System.out.println("\n====================================");
                    System.out.println("       INPUT DATA PERUSAHAAN        ");
                    System.out.println("====================================");
                    System.out.print("ID Perusahaan     : "); String idP = sc.nextLine();
                    System.out.print("Nama Perusahaan   : "); String namaP = sc.nextLine();
                    System.out.print("Alamat Perusahaan : "); String alamatP = sc.nextLine();

                    System.out.println("\n====================================");
                    System.out.println("       INPUT DETAIL MAGANG          ");
                    System.out.println("====================================");
                    System.out.print("ID Magang     : "); String idMg = sc.nextLine();
                    System.out.print("Posisi        : "); String posisi = sc.nextLine();
                    System.out.print("Durasi (bulan): "); int durasi = sc.nextInt();
                    sc.nextLine(); 

                    Mahasiswa m = new Mahasiswa(nim, nama, jurusan);
                    Perusahaan p = new Perusahaan(idP, namaP, alamatP);
                    Magang mg = new Magang(idMg, posisi, durasi, "Menunggu Review");
                    
                    listPendaftaran.add(new FormulirPendaftaran(m, p, mg));
                    System.out.println("\n>> Berhasil Disimpan!");
                    break;

                case 2:
                    if (listPendaftaran.isEmpty()) System.out.println("Belum ada data.");
                    else for (FormulirPendaftaran f : listPendaftaran) f.tampilkanBuktiPendaftaran();
                    break;

                case 3:
                    System.out.print("NIM Mahasiswa: ");
                    String cariNim = sc.nextLine();
                    boolean ditemukan = false;
                    for (FormulirPendaftaran f : listPendaftaran) {
                        // Karena menggunakan Inheritance, f.getNim() bisa langsung dipanggil
                        if (f.getNim().equals(cariNim)) {
                            System.out.print("Status Baru (Diterima/Ditolak): ");
                            f.getDetailMagang().setStatus(sc.nextLine());
                            System.out.println(">> Status diperbarui!");
                            ditemukan = true; break;
                        }
                    }
                    if (!ditemukan) System.out.println("Data tidak ditemukan.");
                    break;

                case 4:
                    System.out.print("NIM yang dibatalkan: ");
                    String hapusNim = sc.nextLine();
                    boolean dihapus = listPendaftaran.removeIf(f -> f.getNim().equals(hapusNim));
                    if (dihapus) System.out.println(">> Berhasil dihapus.");
                    else System.out.println(">> Data tidak ditemukan.");
                    break;
            }
        } while (menu != 5);
        sc.close();
    }
}