Studi Kasus Analisis dan Implementasi Sistem Pemrograman Berbasis Objek

Program Pendaftaran Magang Mahasiswa

Disusun oleh:

Nama : Afdila Dwiyani

NPM : 250215001

Kelas : TRPL 1A

---

## Analisis Sistem

### Latar Belakang

Sistem pendaftaran magang mahasiswa ini dirancang untuk mengelola proses pendaftaran magang secara terstruktur menggunakan pendekatan Pemrograman Berbasis Objek (PBO). Sistem ini merepresentasikan entitas-entitas nyata dalam dunia magang ke dalam bentuk class-class yang saling berhubungan, sehingga data dapat dikelola dengan lebih terorganisir dan mudah dikembangkan.

### Identifikasi Class

Berdasarkan analisis kebutuhan sistem, teridentifikasi 4 class utama yang menjadi fondasi sistem:

| No | Class | Deskripsi |
|----|-------|-----------|
| 1 | **Mahasiswa** | Kelas ini berfungsi sebagai representasi subjek atau pelaku pendaftaran. Fokus utamanya adalah menyimpan identitas personal yang melekat pada mahasiswa seperti NIM, nama, dan jurusan. Tanpa kelas ini, sistem tidak akan mengetahui siapa yang sedang mengajukan lamaran magang. |
| 2 | **Perusahaan** | Kelas ini merepresentasikan objek tujuan atau penyedia lowongan magang. Perusahaan dipisahkan menjadi kelas tersendiri agar data lokasi dan nama perusahaan tidak perlu ditulis berulang-ulang secara manual dalam bentuk string biasa, melainkan dikelola sebagai objek yang terstruktur. |
| 3 | **Magang** | Kelas ini mendefinisikan detail aktivitas yang dilamar. Berbeda dengan Mahasiswa (siapa) dan Perusahaan (di mana), kelas Magang menjawab pertanyaan "apa" dan "bagaimana" yaitu posisi apa yang dilamar, berapa lama durasi magang, dan bagaimana status pendaftaran saat ini. |
| 4 | **FormulirPendaftaran** | Kelas ini berfungsi sebagai penghubung atau linker. Dalam dunia nyata, kelas ini ibarat selembar kertas formulir yang sudah diisi lengkap. Kelas ini mengagregasikan atau menyatukan objek Mahasiswa, Perusahaan, dan Magang menjadi satu kesatuan data pendaftaran yang valid. |

### Spesifikasi Atribut dan Method

#### a. Class Mahasiswa

**Atribut:**
- **NIM** : Menjadi identitas unik setiap mahasiswa. NIM digunakan sebagai pembeda antar mahasiswa yang mendaftar.
- **Nama** : Diperlukan untuk mengetahui identitas siapa yang mendaftar magang.
- **Jurusan** : Menyatakan bidang studi mahasiswa. Atribut ini penting untuk mencocokkan posisi magang yang dilamar agar sesuai dengan kompetensi mahasiswa.

**Method:**
- **Constructor** : Berfungsi untuk menginisialisasi objek Mahasiswa saat pertama kali dibuat, mengisi nilai awal NIM, nama, dan jurusan.
- **Getter (getNim, getNama, getJurusan)** : Digunakan untuk mengakses data dari luar kelas, karena atribut dibuat bersifat private.
- **Setter (setNama, setJurusan)** : Digunakan untuk mengubah data jika diperlukan di kemudian hari, misalnya ada perubahan nama atau perpindahan jurusan.

#### b. Class Perusahaan

**Atribut:**
- **ID Perusahaan** : Identitas unik untuk setiap perusahaan tempat magang. Digunakan untuk membedakan satu perusahaan dengan perusahaan lainnya.
- **Nama Perusahaan** : Penting untuk mengetahui perusahaan tujuan magang yang dipilih mahasiswa.
- **Alamat Perusahaan** : Diperlukan untuk keperluan administrasi dan surat-menyurat, serta kemungkinan magang dilakukan di lokasi kantor perusahaan.

**Method:**
- **Constructor** : Menginisialisasi objek Perusahaan dengan nilai ID, nama, dan alamat.
- **Getter dan Setter** : Disediakan untuk mengakses dan mengubah data perusahaan dengan prinsip enkapsulasi yang sama seperti pada class Mahasiswa.

#### c. Class Magang

**Atribut:**
- **ID Magang** : Identitas unik setiap lowongan atau program magang yang tersedia.
- **Posisi** : Menyatakan posisi yang dilamar, misalnya "Frontend Developer", "Network Engineer", atau "UI/UX Designer".
- **Durasi** : Menggunakan tipe integer karena berisi angka (lama magang dalam bulan) dan perlu dioperasikan secara matematis, misalnya untuk perhitungan atau validasi minimal dan maksimal durasi magang.
- **Status** : Menyimpan status pendaftaran yang terdiri dari tiga kemungkinan: "Menunggu Review", "Diterima", atau "Ditolak". Dipilih tipe String karena nilainya bersifat kualitatif atau teks dan tidak perlu dihitung.

**Method:**
- **Getter dan Setter** : Digunakan untuk mengakses dan mengubah nilai atribut seperti posisi dan durasi.
- **Method setStatus** : Method khusus yang disediakan untuk mengupdate status pendaftaran oleh admin. Method ini memberikan kontrol agar hanya pihak yang berwenang yang dapat mengubah status.

#### d. Class FormulirPendaftaran

**Atribut:**
- **mahasiswa** : Menyimpan objek data mahasiswa yang berisi NIM, nama, dan jurusan.
- **perusahaan** : Menyimpan objek data perusahaan yang berisi ID, nama, dan alamat.
- **magang** : Menyimpan objek detail magang yang berisi ID, posisi, durasi, dan status.

**Method:**
- **Constructor** : Menginisialisasi objek FormulirPendaftaran dengan menerima data mahasiswa, perusahaan, dan magang sebagai parameter.
- **tampilkanBuktiPendaftaran** : Menampilkan semua data pendaftaran secara lengkap sebagai bukti bahwa pendaftaran telah tercatat.
- **getNim** : Mengembalikan NIM mahasiswa yang terdaftar, berguna untuk memudahkan pencarian data pendaftaran.
- **getDetailMagang** : Mengembalikan objek magang yang terkait, berguna untuk keperluan update status pendaftaran.

### Diagram Class

#### Buat class diagram sederhana berdasarkan analisis sistem yang telah dibuat. Ketentuan:
  - Minimal 3 class
  - Menunjukkan hubungan antar class

![Studi Kasus Analisis dan Implementasi Sistem Pemrograman Berbasis Objek](https://github.com/user-attachments/assets/ca0b7345-560d-4fa0-98ee-49e099b582c2)


### Hubungan Antar Class

#### a. Inheritance (Pewarisan)

Hubungan inheritance terjadi antara Mahasiswa sebagai parent class dengan FormulirPendaftaran sebagai child class. FormulirPendaftaran mewarisi semua atribut dan method dari Mahasiswa. Keputusan ini diambil karena secara konsep, formulir pendaftaran adalah representasi dari mahasiswa yang mendaftar atau dengan kata lain FormulirPendaftaran adalah Mahasiswa (IS-A relationship). Dengan hubungan ini, NIM dan Nama mahasiswa otomatis tersedia dalam formulir tanpa perlu dideklarasikan ulang.

**Alasan Penggunaan:** Pewarisan dipilih karena FormulirPendaftaran memang memiliki semua karakteristik yang dimiliki oleh Mahasiswa. Setiap formulir pasti mewakili satu mahasiswa tertentu, sehingga hubungan IS-A lebih tepat dibandingkan sekedar memiliki (HAS-A).

#### b. Agregasi

Hubungan agregasi terjalin antara FormulirPendaftaran dengan Perusahaan. FormulirPendaftaran memiliki objek Perusahaan di dalamnya, namun objek Perusahaan dapat berdiri sendiri secara independen. Hubungan ini bersifat agregasi karena siklus hidup kedua objek tidak sepenuhnya terikat.

**Alasan Penggunaan:** Agregasi dipilih karena meskipun FormulirPendaftaran membutuhkan data Perusahaan, Perusahaan tetap ada meskipun pendaftaran tertentu dihapus. Jika seorang mahasiswa membatalkan pendaftaran, data perusahaan tersebut tidak ikut terhapus dari sistem karena perusahaan masih mungkin memiliki pendaftar lain atau lowongan magang lainnya.

#### c. Komposisi

Hubungan ini terjadi antara subclass FormulirPendaftaran dengan class Magang. Detail Magang (posisi dan status) adalah bagian dari isi formulir. Jika FormulirPendaftaran dihapus, maka data Magang tersebut ikut hilang karena status pendaftaran tidak punya arti tanpa formulirnya.

**Alasan Penggunaan:** Komposisi dipilih karena data Magang tidak memiliki makna tanpa formulir pendaftaran. Status pendaftaran seperti "Menunggu Review", "Diterima", atau "Ditolak" hanya relevan dalam konteks formulir tertentu. Jika FormulirPendaftaran dihapus, maka data Magang yang terkait juga ikut dihapus karena tidak memiliki keberadaan yang berarti secara mandiri.

---

## Penjelasan Konsep PBO

### 1. Class dan Object

**Class** adalah cetak biru atau template yang mendefinisikan atribut dan method. Dalam program ini terdapat 5 class: Mahasiswa, Perusahaan, Magang, FormulirPendaftaran, dan Main. Setiap class memiliki tanggung jawab yang spesifik sesuai dengan entitas yang direpresentasikannya.

**Object** adalah instance nyata dari class yang dibuat menggunakan keyword new. Object diciptakan di method main saat pengguna mengisi formulir pendaftaran. Object-object seperti Mahasiswa, Perusahaan, Magang, dan FormulirPendaftaran kemudian disimpan ke dalam ArrayList untuk dikelola lebih lanjut.

Penerapan konsep class dan object dalam sistem ini memungkinkan representasi data yang natural karena setiap entitas di dunia nyata (mahasiswa, perusahaan, program magang) dapat dimodelkan sebagai object dengan atribut dan perilaku masing-masing.

### 2. Enkapsulasi

Enkapsulasi diterapkan dengan membuat semua atribut bersifat private sehingga tidak bisa diakses langsung dari luar class. Prinsip ini dikenal sebagai data hiding atau penyembunyian data.

Untuk mengakses data dari luar class, disediakan method getter yang bersifat public. Getter mengembalikan nilai atribut yang diminta. Untuk mengubah data, disediakan method setter yang bersifat public. Setter memungkinkan dilakukannya validasi sebelum data benar-benar diubah.

Keuntungan penerapan enkapsulasi dalam sistem ini adalah:
- **Keamanan data**: Atribut tidak dapat diubah secara sembarangan oleh kode di luar class
- **Integritas data**: Perubahan hanya dapat dilakukan melalui method yang terkontrol, sehingga dapat ditambahkan validasi
- **Kemudahan pemeliharaan**: Perubahan struktur internal class tidak mempengaruhi class lain yang menggunakannya, selama method getter dan setter tetap dipertahankan

Contoh penerapan enkapsulasi terlihat pada class Magang di mana method setStatus memungkinkan admin untuk mengubah status pendaftaran dengan tetap menjaga bahwa hanya nilai yang valid yang dapat dimasukkan.

### 3. Inheritance (Pewarisan)

Inheritance adalah konsep di mana suatu class dapat mewarisi atribut dan method dari class lain. Dalam sistem ini, hubungan inheritance diterapkan antara Mahasiswa (parent class) dan FormulirPendaftaran (child class).

Dengan hubungan ini, FormulirPendaftaran secara otomatis memiliki atribut NIM, Nama, dan Jurusan yang didefinisikan di class Mahasiswa, tanpa perlu mendeklarasikannya ulang. Child class juga dapat menambahkan atribut dan method baru yang spesifik untuk dirinya sendiri, seperti atribut perusahaan dan magang serta method tampilkanBuktiPendaftaran.

Keuntungan penggunaan inheritance dalam sistem ini adalah:
- **Reusability**: Kode tidak perlu ditulis berulang-ulang
- **Hierarki yang jelas**: Hubungan antar class mencerminkan hubungan konseptual di dunia nyata
- **Kemudahan pengembangan**: Perubahan pada parent class akan secara otomatis diwarisi oleh semua child class


### Keunggulan Pendekatan PBO dibandingkan Prosedural

Pendekatan Pemrograman Berbasis Objek lebih unggul dibandingkan pendekatan prosedural pada sistem ini karena beberapa alasan:

| Aspek | PBO | Prosedural |
|-------|-----|------------|
| **Modularitas** | Kode terbagi dalam class dengan tanggung jawab masing-masing, sehingga setiap bagian memiliki fokus yang jelas | Semua kode menyatu dalam satu blok panjang yang sulit dilacak |
| **Reusability** | Class dapat dipakai ulang di berbagai bagian program tanpa modifikasi | Fungsi dan struktur data sulit digunakan kembali tanpa duplikasi kode |
| **Pengembangan** | Menambah fitur baru cukup dengan menambahkan class baru tanpa mengganggu class yang sudah ada | Perubahan satu bagian berpotensi menimbulkan efek samping pada bagian lain |
| **Keamanan** | Enkapsulasi melindungi data dari akses dan modifikasi yang tidak sah | Data global mudah diakses dan diubah dari berbagai bagian program |
| **Pemeliharaan** | Struktur yang terorganisir memudahkan pelacakan bug dan perbaikan | Sulit dipelihara karena kode yang saling terkait dan rawan error saat sistem berkembang |

---

## Refleksi

### 1. Bagian yang Paling Sulit

Bagian yang paling sulit dalam mengerjakan tugas ini adalah menentukan hubungan antar class yang tepat, terutama antara FormulirPendaftaran dengan Mahasiswa.

Jawab :

Bagian yang paling sulit adalah menentukan hubungan antar class yang tepat, terutama antara FormulirPendaftaran dengan Mahasiswa. Awalnya saya menggunakan komposisi (HAS-A) dengan menjadikan Mahasiswa sebagai atribut, namun kemudian diubah menjadi pewarisan (IS-A) dengan extends Mahasiswa. Keputusan ini mempengaruhi struktur kode secara keseluruhan. Selain itu, validasi input menggunakan regex untuk memastikan NIM hanya berisi angka juga cukup menantang karena harus dipastikan tidak error saat user memasukkan input yang salah.

### 2. Hal Baru yang Dipelajari tentang Konsep PBO

Jawab :

Dari tugas ini, terdapat beberapa hal baru yang dipelajari tentang konsep Pemrograman Berbasis Objek:

Dari tugas ini, saya mempelajari bahwa pewarisan (inheritance) dan komposisi (composition) adalah dua konsep yang berbeda namun dapat digunakan bersama dalam satu program. Saya juga belajar pentingnya enkapsulasi untuk melindungi data dan bagaimana getter/setter menjadi jembatan akses data yang aman.

### 3. Fitur Pengembangan ke Depan

Jika sistem ini dikembangkan lebih lanjut, beberapa fitur akan ditambahkan untuk meningkatkan fungsionalitas dan pengalaman pengguna:

Jawab :

**Autentikasi Pengguna:**
Sistem akan dilengkapi dengan mekanisme autentikasi untuk membedakan akses antara mahasiswa dan admin. Mahasiswa hanya dapat mengakses fitur pendaftaran dan melihat status pendaftarannya sendiri, sementara admin memiliki hak khusus untuk mengelola seluruh data pendaftaran, termasuk mengubah status pendaftaran. Autentikasi dapat diimplementasikan dengan login menggunakan NIM untuk mahasiswa dan username khusus untuk admin.

**Pencarian dan Filter Data:**
Fitur pencarian akan memudahkan pengguna untuk menemukan pendaftaran tertentu berdasarkan berbagai kriteria seperti nama mahasiswa, jurusan, posisi yang dilamar, atau status pendaftaran. Filter data akan membantu admin dalam mengelola pendaftaran, misalnya menampilkan semua pendaftaran yang masih berstatus "Menunggu Review" untuk diproses lebih lanjut.

