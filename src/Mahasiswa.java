public class Mahasiswa {
    private String nim, nama, jurusan;

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getJurusan() { return jurusan; }

    public void tampilkanData() {
        System.out.println("NIM             : " + nim);
        System.out.println("Nama Mahasiswa  : " + nama);
        System.out.println("Jurusan         : " + jurusan);
    }
}