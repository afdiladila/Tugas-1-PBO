public class Magang {
    private String idMagang, posisi, status;
    private int durasi;

    public Magang(String idMagang, String posisi, int durasi, String status) {
        this.idMagang = idMagang;
        this.posisi = posisi;
        this.durasi = durasi;
        this.status = status;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void tampilkanInfo() {
        System.out.println("ID Magang       : " + idMagang);
        System.out.println("Posisi Dilamar  : " + posisi);
        System.out.println("Durasi          : " + durasi + " bulan");
        System.out.println("Status Reg      : " + status);
    }
}