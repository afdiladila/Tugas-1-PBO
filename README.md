Studi Kasus Analisis dan Implementasi Sistem Berbasis Objek
Program Pendaftaran Magang Mahasiswa

Disusun oleh:

Nama : Afdila Dwiyani

NPM : 250215001

Kelas : TRPL 1A

Bagian 1 – Analisis Sistem
1. Identifikasi minimal 3 class utama yang terdapat pada sistem tersebut!

* Perusahaan: Sebagai Class entitas yang menyimpan informasi mengenai instansi atau tempat tujuan magang.
* Mahasiswa: Sebagai parent Class(Induk). Menyimpan data identitas dasar pengguna yang melakukan pendaftaran.
* Magang: Sebagai Class detail program. Mengelola spesifikasi kontrak magang dan status persetujuan.
* FormulirMagang: Sebagai Subclass(Class Turunan) dari Mahasiswa. Class ini berfungsi sebagai “perekat” yang menggabungkan semua data.
* Main: Sebagai Class penggerak (Driver Class) yang berisi logika interaksi pengguna dan penyimpanan data sementara.

2. Tentukan atribut setiap class!

   a. Class Mahasiswa (Induk)
   - nim: Menyimpan nomor induk mahasiswa sebagai identitas unik.
   - nama: Menyimpan nama lengkap mahasiswa.
   - jurusan: Menyimpan bidang studi atau program studi mahasiswa.

   b. Class Perusahaan (Entity)
   - id: Kode unik atau identitas dari perusahaan.
   - nama: Nama resmi perusahaan tujuan.
   - alamat: Lokasi atau alamat kantor perusahaan.

   c. Class Magang (Detail Program)
    - idMagang: Kode referensi untuk posisi magang.
    - posisi: Nama posisi atau divisi yang dilamar.
    - durasi: Jangka waktu pelaksanaan magang (dalam hitungan bulan).
    - status: Status pendaftaran (misal: Menunggu, Diterima, atau Ditolak).

    d. Class FormulirMagang (Subclass)
    -	perusahaanTujuan: Sebuah variabel referensi yang menampung objek dari class Perusahaan.
    -	detailMagang: Sebuah variabel referensi yang menampung objek dari class Magang.
    -	(Atribut Warisan): Secara otomatis memiliki akses ke atribut nim, nama, dan jurusan milik class Mahasiswa.

3.	Tentukan method/perilaku dari setiap class!
   
    a.	Class Mahasiswa
    *	tampilkanData(): Berfungsi untuk mencetak data statis mahasiswa berupa NIM, Nama, dan Jurusan ke konsol.
  	
    b.	Class Perusahaan
    *	tampilkanData(): Berfungsi untuk menampilkan informasi detail perusahaan yang mencakup ID, Nama Perusahaan, dan Alamat kantor.
  	
    c.	Class Magang
    *	ubahStatusPendaftaran(statusNew): Method ini menerima parameter string untuk memperbarui kondisi pendaftaran (misalnya dari "Menunggu" menjadi "Diterima").
    *	tampilkanInfo(): Berfungsi untuk menampilkan detail kontrak magang seperti ID magang, posisi yang dilamar, durasi, dan status saat ini.
  	
    d.	SubClass FormulirMagang
    *	tampilkanBuktiPendaftaran(): Method utama yang memicu pemanggilan method tampilkanData() dari parent (Mahasiswa) serta memanggil method dari objek Perusahaan dan Magang untuk menghasilkan satu laporan utuh (Kartu Pendaftaran).

Bagian 2 – Implementasi PBO

Dalam sistem ini, diterapkan beberapa prinsip utama Pemrograman Berorientasi Objek:

* Encapsulation (Pembungkusan): Mengamankan data dengan menggunakan akses modifier private pada atribut dan menyediakan method Getter dan Setter untuk akses data.
* Inheritance (Pewarisan): Menggunakan keyword extends di mana FormulirPendaftaran mewarisi atribut dan method dari class Mahasiswa.
* Composition (Komposisi): Menghubungkan objek Perusahaan dan Magang ke dalam class FormulirPendaftaran sebagai satu kesatuan data pendaftaran.

Bagian 3 – Analisis Keunggulan PBO

Dibandingkan dengan pendekatan prosedural, struktur ini memiliki keunggulan:

* Modularitas: Perubahan pada struktur data Perusahaan tidak akan mengganggu logika pada data Mahasiswa karena masing-masing berada dalam class yang berbeda.
* Reusability: Class Mahasiswa dapat digunakan kembali untuk sistem lain di masa depan tanpa harus menulis ulang kodenya.
* Keamanan Data: Penggunaan akses private memungkinkan adanya validasi (misal: durasi minimal 1 bulan) melalui setter, yang sulit dikontrol ketat pada pendekatan prosedural.

Bagian 4 – Refleksi
1. Bagian yang paling sulit dalam mengerjakan tugas ini.

   Jawab:
   Bagian tersulit adalah mengintegrasikan hubungan antar class (Inheritance dan Composition) agar data dari objek Mahasiswa, Perusahaan, dan Magang dapat tersimpan dan  ditampilkan secara sinkron dalam satu objek FormulirPendaftaran, terutama saat melakukan pembaruan status berdasarkan NIM di dalam ArrayList.

2. Hal baru yang Anda pelajari tentang konsep PBO.
   
   Jawab: 
   Pada konsep "Warisan" (Inheritance) Saya baru paham fungsinya extends. Saya tidak perlu mengetik ulang variabel NIM atau Nama di dalam FormulirPendaftaran karena sudah "warisan" dari Mahasiswa. Ternyata sebuah Class (seperti FormulirPendaftaran) bisa menyimpan objek utuh dari Class lain (Perusahaan dan Magang). Ini sangat memudahkan karena data jadi terkelompok rapi sesuai fungsinya, persis seperti di dunia nyata di mana sebuah formulir fisik memang berisi informasi dari pihak yang berbeda-beda.

3. Jika sistem ini dikembangkan lebih lanjut, fitur apa yang akan ditambahkan?
   
   Jawab: 
   Validasi Input: Menambahkan pengecekan agar durasi magang tidak bernilai negatif dan NIM harus angka.
Penyimpanan Permanen (Database/File): Menambahkan fitur simpan ke file .txt atau database agar data tidak hilang saat program ditutup.
Fitur Login: Memisahkan hak akses antara Mahasiswa (hanya bisa daftar) dan Admin (bisa update status).
