public class Perusahaan {
    private String id, nama, alamat;

    public Perusahaan(String id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() { return nama; }

    public void tampilkanData() {
        System.out.println("Nama Perusahaan : " + nama);
        System.out.println("ID Perusahaan   : " + id);
        System.out.println("Alamat          : " + alamat);
    }
}