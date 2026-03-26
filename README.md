# Tugas-1-PBO

Studi Kasus: Analisis dan Implementasi Sistem Berbasis Objek

Program Pendaftaran Magang Mahasiswa

Identitas Penyusun

Nama : Afdila Dwiyani

NPM : 250215001

Kelas : TRPL 1A

Institusi: JURUSAN KOMPUTER DAN BISNIS, PRODI TEKNOLOGI REKAYASA PERANGKAT LUNAK - POLITEKNIK NEGERI CILACAP

Tahun : 2026

Bagian 1 – Analisis Sistem

Identifikasi Class Utama

No

Class

Deskripsi

1

Perusahaan

Sebagai Class entitas yang menyimpan informasi mengenai instansi atau tempat tujuan magang.

2

Mahasiswa

Sebagai Parent Class (Induk). Menyimpan data identitas dasar pengguna yang melakukan pendaftaran.

3

Magang

Sebagai Class detail program. Mengelola spesifikasi kontrak magang dan status persetujuan.

4

FormulirMagang

Sebagai Subclass (Class Turunan) dari Mahasiswa. Berfungsi sebagai “perekat” yang menggabungkan semua data.

5

Main

Sebagai Class penggerak (Driver Class) yang berisi logika interaksi pengguna dan penyimpanan data sementara.

Atribut Setiap Class

Class Mahasiswa (Induk)

nim: Identitas unik mahasiswa (angka).

nama: Nama lengkap mahasiswa.

jurusan: Bidang studi mahasiswa.

Class Perusahaan (Entity)

id: Kode unik perusahaan.

nama: Nama resmi perusahaan.

alamat: Lokasi kantor perusahaan.

Class Magang (Detail Program)

idMagang: Kode referensi posisi magang.

posisi: Jabatan yang dilamar.

durasi: Jangka waktu magang (bulan).

status: Status pendaftaran (Menunggu/Diterima/Ditolak).

Bagian 2 – Implementasi PBO

Dalam sistem ini, diterapkan beberapa prinsip utama Pemrograman Berorientasi Objek:

Encapsulation (Pembungkusan): Mengamankan data dengan akses private dan menyediakan Getter/Setter.

Inheritance (Pewarisan): FormulirPendaftaran mewarisi sifat dari Mahasiswa.

Composition (Komposisi): Menghubungkan objek Perusahaan dan Magang ke dalam satu kesatuan formulir.

Bagian 3 – Analisis Keunggulan PBO

Dibandingkan dengan pendekatan prosedural, struktur ini memiliki keunggulan:

Modularitas: Perubahan pada data Perusahaan tidak akan mengganggu logika data Mahasiswa.

Reusability: Class Mahasiswa dapat digunakan kembali untuk sistem lain (misal: sistem perpustakaan).

Keamanan: Validasi input (seperti NIM harus angka atau durasi minimal 1 bulan) dapat dikontrol ketat melalui method Setter.

Bagian 4 – Refleksi

1. Bagian yang paling sulit dalam mengerjakan tugas ini?
Bagian tersulit adalah mengintegrasikan hubungan antar class (Inheritance dan Composition) agar data dari objek Mahasiswa, Perusahaan, dan Magang dapat tersimpan dan ditampilkan secara sinkron dalam satu objek FormulirPendaftaran, terutama saat melakukan pembaruan status berdasarkan NIM di dalam ArrayList.

2. Hal baru yang dipelajari tentang konsep PBO?

Paham fungsi extends pada Inheritance. Tidak perlu mengetik ulang variabel NIM atau Nama karena sudah "warisan" dari Mahasiswa.

Paham bahwa sebuah Class bisa menyimpan objek utuh dari Class lain (Composition). Ini memudahkan pengelompokan data sesuai fungsinya di dunia nyata.

3. Fitur yang akan ditambahkan jika dikembangkan lebih lanjut?

Validasi Input: Pengecekan agar durasi tidak negatif dan NIM harus angka (Sudah diimplementasikan).

Penyimpanan Permanen: Fitur simpan ke file .txt atau database agar data tidak hilang.

Fitur Login: Memisahkan hak akses antara Mahasiswa dan Admin.
