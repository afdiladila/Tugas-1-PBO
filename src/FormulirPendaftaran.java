public class FormulirPendaftaran extends Mahasiswa {
    private Perusahaan perusahaanTujuan;
    private Magang detailMagang;

    public FormulirPendaftaran(Mahasiswa m, Perusahaan p, Magang mg) {
        super(m.getNim(), m.getNama(), m.getJurusan());
        this.perusahaanTujuan = p;
        this.detailMagang = mg;
    }

    public Magang getDetailMagang() { return detailMagang; }

    public void tampilkanBuktiPendaftaran() {
        System.out.println("\n------------------------------------");
        System.out.println("      KARTU PENDAFTARAN MAGANG      ");
        System.out.println("------------------------------------");
        super.tampilkanData(); // Memanggil data dari class Mahasiswa
        perusahaanTujuan.tampilkanData();
        detailMagang.tampilkanInfo();
        System.out.println("------------------------------------");
    }
}