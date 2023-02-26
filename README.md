# Basic Java Project
 dibuat untuk memenuhi Tugas Akhir Perkuliahan Praktikum Dasar Pemrograman Semester 1
- Tema Aplikasi     : Perbankan
- Dosen Pengampu    : Bu Mungki Astiningrum
- Try On Replit.co  : https://replit.com/@zm-ibrahim/SeOnejava#Main.java
# :book: Fitur 
## Autentikasi :key:
  - Verifikasi Rekening (Login)
  - Verifikasi Pin (Login)
 ## Admin Mode :pencil:
  - Admin Menu
  - Edit Data Nasabah 
  - Lihat Data Nasabah 
  - Hapus Data Nasabah  
  - Input Data Nasabah Baru 
  - Log Out Admin Kembali Ke Fungsi Verifikasi Rekening
  - Matikan Program (Data Kembali Ke Awal)
 ## Atm Mode (User)
### Essensial
  - Cek Kode Bank & Rekening (Transfer)
  - Konfirmasi Aksi 
  - Ganti Pin 
  - Menu Input
  - Lihat Data Nasabah
  - Jenis Tabungan (Giro & Tabungan)
  - Cek Saldo 
### Transaksi
  - Setor Tabungan
  - Tarik Tunai (Tabungan Atau Giro)
  - Transfer Ke Tabungan Sesama Bank
  - Transfer Ke Tabungan Antar Bank
  - Transfer Ke Rekening Giro
  - Konfirmasi Transfer
  - Keterangan Transfer
  - Simpan Riwayat Transaksi Nasabah
  - Pengurangan Dan Penambahan Saldo Nasabah & Giro
  - Cetak Bukti Transfer, Tarik Tunai, & Setor Tunai
  - Lihat Riwayat Transaksi Nasabah
### Limiter Tarik Tunai (Fitur Level Kartu)
  - Silver
  - Gold
  - Platinum
  
# :memo: Usage
## Login
  Masukkan data yang sudah ada pada bagian awal kode (Data Nasabah)
  - Masukan Rekening
  - Masukan Pin
### Admin
  Login menggunakan data Admin yang ada dibagian awal kode (Setelah data Nasabah)
  Setelah sukses autentifikasi, anda akan masuk ke menu dan selesai. lakukan bagian admin.<br/>
  Login menggunakan data Admin yang ada dibagian awal kode (Setelah data Nasabah)<br>
  ```
  logAdmin = {{"1212001212"},{"121212"}};
  angka pertama adalah rek, kemudian password
  ```

  <br>Setelah sukses autentifikasi, anda akan masuk ke menu admin dan dapat melakukan bagian admin.<br/>
  :warning: Penambahan Data : Hal ini masih terbatas pada jumlah yang ditentukan sesuai besar array 
### User
  Data Nasabah Secara default adalah user (Terdapat dibagian awal kode)
  Setelah sukses autentifikasi, anda akan masuk ke menu biasa.
  Data Nasabah Secara default adalah user (Terdapat dibagian awal kode)<br>

  ```
  rekening {"8179876788", "8921231099", "8888888888", "1234567890","","","",""},
pin {"997654", "876356", "888888", "123456","","","",""},
  
  pasangkan data sesuai indeks array.
  ```
  <br>Setelah sukses autentifikasi, anda akan masuk ke menu biasa.

## Data2 Lain
  Terdapat data seperti Kode Bank, Rekening Bank Lain, Giro, Saldo, dan lain2 Ini juga bisa dilihat diawal kode
# :gear: How It Works
## Cakupan Materi
  - Java Dasar
  - Fungsi pada Java
  - Algoritma
  - Pemilihan (If, Else-if, Nested-If)
  - Perulangan (Loop, Nested-Loop)
  - Concat String
  - Input
  - Print
  - Local & Global range untuk fungsi dan variable
### Program tetap berjalan setelah user keluar untuk tetap menyimpan data <br>dengan mengulang program ke fungsi verifikasi rekening karena program belum menggunakan database
