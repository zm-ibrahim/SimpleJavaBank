/* 
|================================|
 POLITEKNIK NEGERI MALANG
 TEMA : APLIKASI PERBANKAN SEDERHANA 
 NAMA : ZAKY MUHAMMAD IBRAHIM 
 KELAS: 1E
 ABSEN: 30 
 NIM  : 2141720131 
|================================|
*/

import java.util.Scanner;

public class Main{
	static int rek, addNasabah=3;

	/* PUSAT DATA */
	//DATA NASABAH
	static String[][] dataNasabah = {
		//0 - Nama
		{"Achmad Iffad", "Muhammad Zakariyya", "Refki Joeta Kanada", "Ambon Buana Manise","","","",""}, 
		//1 - jeniskelamin
		{"L","L","L","L","","","",""},
		//2 - Tanggal Lahir
		{"12-09-1999", "13-10-1998", "20-09-2000", "23-07-1996","","","",""},
		//3 - email
		{"ahfaloom@email.com", "zakariymm@email.com", "rejoeta@email.com", "ambonmanise@email.com","","","",""},
		//4 - jenisKartu
		{"silver", "silver", "gold", "silver","","","",""},
		//5 - rekening
		{"8179876788", "8921231099", "8888888888", "1234567890","","","",""},
		//6 - pin
		{"997654", "876356", "888888", "123456","","","",""},
		//7 - Kode Bank
		{"001","001","001","001","001","001","001","001"},
		//8 - Riwayat
		{"","","","","","","",""}
	};
		
	//Saldo
	static int [] saldoNasabah = {200000, 50000, 200000, 1000000, 0, 0 };

	//Data Giro (DUMMY)
	static String[] giro = {"0909090909","999999999"};//Nomor Giro
	static int[] saldoGiro ={2500000,9000000};//Saldo Giro
		
	//NASABAH BANK LAIN (DUMMY)
	static String[][] dataNasLain = {
	{"Udin", "Jainuri", "Zaenab"}, //0 - Nama
	{"Bank iTU","Bank iTU", "Bank Eta"}, //1 - Nama Bank
	{"3131112345", "1234560987", "0987654321"}, //2 - No Rek
	{"","",""}
	};

	//Saldo Bank Nasabah Bank lain	
	static int[] saldoNasLain = {0,0,0};

	//KODE BANK
	static String[] numbBank = {"001", "002", "003"}; 
		
	//ADMIN
	static String[][] logAdmin = {{"1212001212"},{"121212"}};
		
	//LEVEL KARTU
	static String[] kartu = {"silver", "gold", "platinum"};
	
	//* RUNNING !! *//--------------------//
	//PUBLIC
	public static void main(String[] args){
		//YEY JALAN
		authRek();
	}
	//------------------------------------//
	
	/*CORE MAIN*/

	//JARAK
   	static void clrscr(){
    	//Berikan Space
    	System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

  	//FUNGSI VERIFIKASI REKENING
	static void authRek(){
		Scanner sc = new Scanner(System.in);
		String rekening,cek,cek2;
		char pil;
		clrscr();
		System.out.println("<|====================[Auth]====================|>");
		System.out.println(" |                                              |");
		System.out.println(" |                  [BANK iNi]                  |");
		System.out.println(" |                                              |");
		System.out.println("<|====================[Auth]====================|>");
		System.out.print("   Masukkan Nomor Rekening >> ");
		rekening = sc.nextLine();

		for(int i=0;i<dataNasabah[0].length;i++){
			cek = dataNasabah[5][i];
			cek2 = logAdmin[0][0];
			if (rekening.equals(cek)){
				rek=i;
				break;	
			} else if(rekening.equals(cek2)){
				rek=-1;
				break;
			} else {
				rek=-2;
			}
		} if (rek!=-2){
			authPin();
		} else {
			clrscr();
			System.out.println("<!>=====[ Rekening Tidak Ditemukan ]=====<!>");
			System.out.println("Ulangi ? (Y/N)");
			pil = sc.next().charAt(0);
			if(pil=='y'||pil=='Y'){
				authRek();
			} else {
				akhir();
			}
		}
	}
	
	
	//FUNGSI VERIFIKASI PIN
	static void authPin(){
		Scanner sc = new Scanner(System.in);
		String pin;
		int cek=3;
		if(rek!=-1){
			for(int i=0;i<3;i++){
				System.out.print("   Masukkan PIN >>");
				pin = sc.nextLine();
				if(pin.equals(dataNasabah[6][rek])){
					menuUtama();
					break;
				}else{
					System.out.println("<!>=== [PIN anda Salah] ===<!>");
					cek=-1;
				}
			}
		} else {
			for(int i=0;i<3;i++){
				System.out.print("   Masukkan PIN >>");
				pin = sc.nextLine();
				if(pin.equals(logAdmin[1][0])){
					menuAdmin();
					break;
				}else{
					System.out.println("<!>=== [PIN anda Salah] ===<!>");
					cek=-1;
				}
			}
		}		
		akhir();

	}

	//Ganti PIN
	static void gantiPIN(){
		Scanner sc = new Scanner(System.in);
		char a, b;
		String pin;
		clrscr();
		System.out.println("===============BANK iNi===============");
		System.out.print("  Ganti PIN ? (Y/N) >>");
		a = sc.next().charAt(0);
		if (a=='y'||a=='Y'){
			System.out.print("  Masukkan PIN Lama >>");
			pin = sc.next();
			if (pin.equals(dataNasabah[6][rek])){
				System.out.print("  Masukkan PIN Baru (6-digit) >>");
				dataNasabah[6][rek] = sc.next();
				System.out.println("\n  PIN Berhasil Diganti !");
				System.out.println("  PIN Anda Adalah : "+dataNasabah[6][rek]);
				System.out.println("===============BANK iNi===============");
				cekAksi();
			} else {
				System.out.println("<!>=== [PIN anda Salah] ===<!>");
				System.out.print(" Ulangi ? (Y/N) >>");
				b = sc.next().charAt(0);
				if(b=='y'||b=='Y'){
					gantiPIN();
				} else {
					cekAksi();
				}
			}
		} else {
			cekAksi();
		}

	}
	
	
	//FUNGSI UTAMA
	static void menuUtama(){
		Scanner sc = new Scanner(System.in);
		char pil,pil2;
		char tunai='a';
		clrscr();
		//PUBLIC INTERAKTIF
		System.out.println("===============BANK iNi===============");
		System.out.println(" a> 500000			e> Tarik Jumlah Lain ");
		System.out.println(" b> 300000			f> Setor Tunai ");
		System.out.println(" c> 200000			g> Cek Saldo ");
		System.out.println(" d> 100000			h> Transfer ");
		System.out.println(" i> Lihat Data			j> Mutasi ");
		System.out.println(" k> Ganti PIN ");
		System.out.println("===============BANK iNi===============");
		System.out.print("Pilih Menu >> ");
		pil=sc.next().charAt(0);
		if (pil=='a'){
			modTunai(rek,tunai,pil);
		} else if (pil=='b'){
			modTunai(rek,tunai,pil);
		} else if (pil=='c'){
			modTunai(rek,tunai,pil);
		} else if (pil=='d'){
			modTunai(rek,tunai,pil);
		} else if (pil=='e'){
			jenisTabungan(rek,pil);
		} else if (pil=='f'){
			modTunai(rek,tunai,pil);
		} else if (pil=='g'){
			cekSaldo(rek);
		} else if (pil=='h'){
			jenisTabungan(rek,pil);
		} else if (pil=='i'){
			lihatData(rek);
		} else if (pil=='j'){
			modMutasi(rek);
		} else if (pil=='k'){
			gantiPIN();
		} else {
			clrscr();
			System.out.println("<!>=== [Menu Tidak Ditemukan!] ===<!>");
			System.out.print("Batalkan Transaksi ? (Y/N)");
			pil2 = sc.next().charAt(0);
			if (pil2=='y'||pil2=='Y'){
				akhir();
			} else {
				menuUtama();
			}
		}

	}

	//FUNGSI JENIS TABUNGAN
	static void jenisTabungan(int b, char a){
		Scanner sc = new Scanner(System.in);
		char pil, tr;
		clrscr();
		System.out.println("<|============ Pilih Jenis Rekening ============|>\n");
		System.out.println("  a> Tabungan     b> Giro\n");
		System.out.println("<|============ Pilih Jenis Rekening ============|>\n");
		System.out.print("Pilih >> ");
		pil = sc.next().charAt(0);
		if (pil=='a'){
			if(a=='e'||a=='f'){
				modTunai(b,pil,a);
			} else {
				modTransfer(b,pil);
			}
		} else if (pil=='b'){
			if(a=='e'||a=='f'){
				modTunai(b,pil,a);
			} else {
				modTransfer(b,pil);
			}
		} else {
			clrscr();
			System.out.println("<!> ===== Menu Tidak Ditemukan! ===== <!>");
			System.out.println("Ingin Mengakhiri Transaksi ? (Y/N)");
			tr = sc.next().charAt(0);
			if (tr=='y'||tr=='Y'){
				akhir();
			} else{
				jenisTabungan(b,a);
			}
		}

	}

	//KALAU MENG-AKHIRI
	static void akhir(){
		clrscr();
		System.out.print("<| =============== [ Bank iNi ] =============== |>\n");
		System.out.print("    Terimakasih Telah Menggunakan [Bank iNi]      \n");
		System.out.print("<| =============== [ Bank iNi ] =============== |>");
		authRek();
	}

	//KONFIRMASI AKSI
	static void cekAksi(){
		Scanner sc = new Scanner(System.in);
		char tr;
		System.out.print(" Ingin Melakukan Transaksi Lain ? (Y/N) >>");
		tr = sc.next().charAt(0);
		if(tr=='Y'||tr=='y'){
			menuUtama();
		}else{
			akhir();
		}
	}

	/* CORE ATM */

	//SIMPAN RIWAYAT + BUKTI SETOR TUNAI
	static void setorTunai(int b, int nomine){
		String h,h2,h3;
		Scanner sc = new Scanner(System.in);
		h = String.format("  %s + %s =", saldoNasabah[b], nomine);
		saldoNasabah[b] += nomine;
		h2 = String.format(" %s (Setor Tunai)\n", saldoNasabah[b]);
		h3 = h.concat(h2);
		dataNasabah[8][b]= dataNasabah[8][b].concat(h3);

		clrscr();
		System.out.println("Transaksi Berhasil\n");
		//BUKTI SETOR TUNAI
		System.out.println("<| =========== [BANK iNi] =========== |>\n");
		System.out.println(" Setor Tunai\n");
		System.out.println(" Status : BERHASIL");
		System.out.println(" Atas Nama : \t"+dataNasabah[0][b]);
		System.out.println(" No. Rekening : \t"+dataNasabah[5][b]);
		System.out.println("\n Jumlah :\t"+nomine);
		System.out.println(" Saldo Akhir: \t"+saldoNasabah[b]);
		System.out.println("\n Terimakasih Telah Menggunakan [Bank iNi]\n");
		System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
		cekAksi();
	}

	//SIMPAN RIWAYAT + BUKTI TARIK TUNAI
	static void tarikTunai(int b, int nomine){
		String h,h2,h3;
		Scanner sc = new Scanner(System.in);
		h = String.format("  %s - %s =", saldoNasabah[b], nomine);
		saldoNasabah[b] -= nomine;
		h2 = String.format(" %s (Tarik Tunai)\n", saldoNasabah[b]);
		h3 = h.concat(h2);
		dataNasabah[8][b]= dataNasabah[8][b].concat(h3);

		clrscr();
		System.out.println("Transaksi Berhasil\n");
		//BUKTI TARIK TUNAI
		System.out.println("<| =========== [BANK iNi] =========== |>\n");
		System.out.println(" Tarik Tunai\n");
		System.out.println(" Status : BERHASIL");
		System.out.println(" Atas Nama : \t"+dataNasabah[0][b]);
		System.out.println(" No. Rekening : \t"+dataNasabah[5][b]);
		System.out.println("\n Jumlah :\t"+nomine);
		System.out.println(" Saldo Akhir: \t"+saldoNasabah[b]);
		System.out.println("\n Terimakasih Telah Menggunakan [Bank iNi]\n");
		System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
		cekAksi();
	}


	//PROSES SALDO TUNAI
	static void prosesTunai(int b, int nomine){
		Scanner sc = new Scanner(System.in);
		char tr;
		if(saldoNasabah[b]<=nomine){
			System.out.println("<!>  == [Saldo Anda Tidak Mencukupi] == <!>");
			System.out.print(" Ingin Melakukan Transaksi Lain ? (Y/N) >>");
			tr = sc.next().charAt(0);
			if(tr=='Y'||tr=='y'){
				menuUtama();
			}else{
				akhir();
			}
		}else{
			tarikTunai(b,nomine);
		}
	}

	//FUNGSI TARIK/SETOR TUNAI
	static void modTunai (int b,char pilih,char a){
		Scanner sc = new Scanner(System.in);
		int proses;
		int nomine, cek=0;
		String gr, cek2;
		String kartu = dataNasabah[4][b];
		char tr;
		
		//Tabungan
		if (pilih=='a'){
			if (a=='e'){
			System.out.print("Masukkan Nominal >> ");
			nomine = sc.nextInt();
				if(saldoNasabah[b]<=nomine){
					System.out.println("<!> ==== [Saldo Anda Tidak Mencukupi] ==== <!>");
					cekAksi();
				}else{
					//LIMIT TARIK TUNAI VIA LEVEL KARTU
					if (kartu.equals("silver")){
						if(nomine>1000000){
							System.out.println("<!>==== Jumlah Melebihi Limit! ====<!>");
							modTunai(b,pilih,a);
						} else {
							tarikTunai(b,nomine);

						}
					} else if (kartu.equals("gold")){
						if(nomine>5000000){
							System.out.println("<!>==== Jumlah Melebihi Limit! ====<!>");
							modTunai(b,pilih,a);
						} else {
							tarikTunai(b,nomine);


						}
					} else {
						tarikTunai(b,nomine);
					}
					
				}
			}else if (a=='f'){
				System.out.print("Masukkan Nominal >> ");
				nomine = sc.nextInt();
				setorTunai(b,nomine);
			
			}else if (a=='a'){
				nomine=500000;
				prosesTunai(b,nomine);
			}else if (a=='b'){
				nomine=300000;
				prosesTunai(b,nomine);
			}else if (a=='c'){
				nomine=200000;
				prosesTunai(b,nomine);
			}else if (a=='d'){
				nomine=100000;
				prosesTunai(b,nomine);
			}else {
				System.out.println("<!> ==== [Menu Tidak Dapat Ditemukan!] ==== <!>");
				cekAksi();
			}

		//GIRO
		} else { 
			//Masukkan Nomor Giro Tujuan
			clrscr();
			System.out.println("========== [Bank iNi] =========>\n");
			System.out.print(" Masukkan Nomor Giro >> ");
			gr = sc.nextLine();

			//Jumlah Nominal
			System.out.print(" Masukkan Jumlah Nominal >> ");
			nomine = sc.nextInt();

			//Cek Giro
			for(int i=0;i<giro.length;i++){
				cek2=giro[i];
				if(gr.equals(cek2)){
					cek=i;
					break;
				} else {
					cek=-2;
				}
			}

			if(cek==-2) {
					System.out.println("<!> == Rekening Tidak Ditemukan! == <!>");
					cekAksi();
			} else {
			//Pengurangan Saldo Giro
			saldoGiro[cek]-=nomine;
			clrscr();
			System.out.println("Transaksi Berhasil\n");
			//BUKTI TARIK TUNAI
			System.out.println("<| =========== [BANK iNi] =========== |>\n");
			System.out.println("\n Tarik Tunai via Giro\n");
			System.out.println(" Status : BERHASIL\n");
			System.out.println(" Giro : \t"+gr);
			System.out.println(" Jumlah :\t"+nomine);
			System.out.println("\n Sisa Saldo: "+saldoGiro[cek]);
			System.out.println("\n Terimakasih Telah Menggunakan [Bank iNi]\n");
			System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
			cekAksi();
			}
		}
	}

	
	//FUNGSI TRANSFER
	static void modTransfer (int b, char a){
		Scanner sc = new Scanner(System.in);
		char tr;
		int nomine,cek=0;
		String kodebank;
		String cek2,keterangan, gr,rekening, namabank, nama, nama2, proses;
		String h,h2,h3;

		if(a=='b'){
			System.out.println("======== [BANK iNi] =======>");
			//Masukkan Nomor Giro Tujuan
			System.out.print(" Masukkan Nomor Giro : ");
			gr = sc.nextLine();

			//Cek Giro
			for(int i=0;i<giro.length;i++){
				cek2=giro[i];
				if(gr.equals(cek2)){
					cek=i;
					break;
				} else{
					cek=-2;
				}
			}

			if(cek==-2){
				System.out.println("<!> == Rekening Tidak Ditemukan! == <!>");
				cekAksi();
			} else {
				//Jumlah Nominal
				System.out.print(" Masukkan Jumlah Nominal : ");
				nomine = sc.nextInt();

				//Konfirmasi Transfer
				clrscr();
				System.out.println("=====Konfirmasi Transfer=====");
				System.out.println(" Giro : \t"+gr);
				System.out.println(" Jumlah :\t"+nomine);
				System.out.println("=====Konfirmasi Transfer=====");
				System.out.println(" Lanjutkan ? (Y/N)");
				tr = sc.next().charAt(0);
				if(tr=='Y'||tr=='y'){
					//Pengurangan & Cek Saldo Pengirim + ModSaldo
					if (saldoNasabah[b]<=nomine){
						System.out.println("<!> ==== Saldo Tidak Mencukupi ==== <!>");
						cekAksi();
					} else {
						h = String.format("  %s - %s =", saldoNasabah[b], nomine);
						saldoNasabah[b] -= nomine;
						h2 = String.format(" %s , Transfer Ke Giro %s \n", saldoNasabah[b], gr);
						h3 = h.concat(h2);
						dataNasabah[8][b]= dataNasabah[8][b].concat(h3);
						
						saldoGiro[cek]+=nomine;

						//BUKTI TF GIRO
						clrscr(); 
						System.out.println("<| =========== [BANK iNi] =========== |>\n");
						System.out.println(" Transfer Tabungan ke Giro\n");
						System.out.println(" Status : BERHASIL");
						System.out.println(" Pengirim : \t"+dataNasabah[0][b]);
						System.out.println(" Dari Rekening : \t"+dataNasabah[5][b]+"\n");
						System.out.println(" Ke Rekening (Giro) : \t"+gr);
						System.out.println(" Jumlah : \t"+nomine);
						System.out.println("\n Terimakasih Telah Menggunakan [Bank iNi]\n");
						System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
						cekAksi();
						
					}	
				}else{
					cekAksi();
				}
			}

		} else if (a=='a') {
			//Rekening Tujuan
			clrscr();
			System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
			System.out.println("<========== [List Kode Bank] ==========>");
			System.out.println("\n\tBank iNi: 001\n\tBank iTU: 002\n\tBank Eta: 003\n");
			System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
			System.out.print("  Masukkan Kode Bank :>> ");
			kodebank = sc.next();
			if (kodebank.equals(numbBank[0])){
				namabank="Bank iNi";
			} else if (kodebank.equals(numbBank[1])){
				namabank="Bank iTU";
			} else if (kodebank.equals(numbBank[2])){
				namabank="Bank Eta";
			} else {
				namabank="Error";
				System.out.println("<!> === [Kode Bank Tidak Ditemukan!] === <!>");
				cekAksi();
			}

			//Masukkan Rekening
			System.out.print(" Masukkan Nomor Rekening Tujuan >> ");
			rekening = sc.next();

			//Cek Rekening
			if(kodebank.equals(numbBank[0])){
				for(int i=0;i<dataNasabah[5].length;i++){
					proses=dataNasabah[5][i];
					if(rekening.equals(proses)){
						cek=i;
						break;
					} else{
						cek=-2;
					}
				}
			}else if (kodebank.equals(numbBank[1])||kodebank.equals(numbBank[2])){
				for (int i=0;i<dataNasLain[2].length;i++){
					proses=dataNasLain[2][i];
					if(rekening.equals(proses)){
						cek=i;
						break;
					} else {
						cek=-2;
					}
				}
			} else {
				cek=-2;
			}

			if(cek==-2) {
				System.out.println("<!> == [Nomor Rekening Tidak Ditemukan!] == <!>");
				cekAksi();
			} else {
				//Nominal Transfer
				System.out.print(" Masukkan Jumlah Transfer >> ");
				nomine = sc.nextInt();


				//Ambil Nama Rekening Tujuan
				if(kodebank.equals(numbBank[0])){
					nama=dataNasabah[0][cek];
				}else {
					nama=dataNasLain[0][cek];
				}
				
				//Konfirmasi Transfer
				clrscr();
				System.out.println("=====Konfirmasi Transfer=====");
				System.out.println(" Bank : \t"+namabank);
				System.out.println(" Atas Nama : \t"+nama);
				System.out.println(" Jumlah :\t"+nomine);
				System.out.println("=====Konfirmasi Transfer=====");
				System.out.print(" Lanjutkan ? (Y/N)");
				tr = sc.next().charAt(0);
				if(tr=='Y'||tr=='y'){
					//Keterangan Transfer
					System.out.print("Keterangan : ");
					keterangan = sc.next()+sc.nextLine();

					//Pengurangan & Cek Saldo Pengirim
					if (saldoNasabah[b]<=nomine){
						System.out.println("<!> === Saldo Tidak Mencukupi === <!>");
						cekAksi();
					} else {
						h = String.format("  %s - %s =", saldoNasabah[b], nomine);
						saldoNasabah[b] -= nomine;
						h2 = String.format(" %s (Transfer ke : %s, %s, %s ) Ket : %s\n", saldoNasabah[b], namabank, nama, dataNasabah[5][cek], keterangan );
						h3 = h.concat(h2);
						dataNasabah[8][b]= dataNasabah[8][b].concat(h3);

						if(kodebank.equals(numbBank[0])){
							h = String.format("  %s + %s =", saldoNasabah[cek], nomine);
							saldoNasabah[cek] += nomine;
							h2 = String.format(" %s (Transfer oleh : %s, %s ) Ket : %s\n", saldoNasabah[cek], dataNasabah[0][b], dataNasabah[5][b], keterangan);
							h3 = h.concat(h2);
							dataNasabah[8][cek]= dataNasabah[8][cek].concat(h3);
						} else {
							h = String.format("  %s + %s =", saldoNasLain[cek], nomine);
							saldoNasLain[cek] += nomine;
							h2 = String.format(" %s \n", saldoNasLain[cek]);
							h3 = h.concat(h2);
							dataNasLain[3][cek]= dataNasLain[3][cek].concat(h3);
						}
						
				
						//BUKTI TF
						clrscr();
						System.out.println("<|======= [BANK iNi] =======|>\n");
						System.out.println(" Transfer Antar Bank\n");
						System.out.println(" Status : BERHASIL\n");
						System.out.println(" Pengirim :\t"+dataNasabah[0][b]);
						System.out.println(" Dari Rekening :\t"+dataNasabah[5][b]+"\n");
						System.out.println(" Ke Rekening :\t"+rekening);
						System.out.println(" Bank Penerima :\t"+namabank);
						System.out.println(" Penerima : \t"+nama);
						System.out.println("\n Jumlah :\t"+nomine);
						System.out.println(" Keterangan: \t"+keterangan);
						System.out.println("\n Terimakasih Telah Menggunakan [Bank iNi]\n");
						System.out.println("\n<| =========== [BANK iNi] =========== |>\n");
						cekAksi();
					}
					
				}else{
					cekAksi();	
				}
			}
		}
	}
	
	//FUNGSI CEK SALDO
	static void cekSaldo(int a){
		clrscr();
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		System.out.println(" Rekening : "+dataNasabah[5][a]);
		System.out.println(" Atas Nama : "+dataNasabah[0][a]);
		System.out.println("\n Saldo Anda Sebesar : "+saldoNasabah[a]);
		System.out.println("\n<| ======= [BANK iNi] =======|>\n");
		cekAksi();
	}

	//FUNGSI LIHAT DATA NASABAH
	static void lihatData(int b){
		clrscr();
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		System.out.println("      Lihat Data Nasabah\n");
		for(int i=0;i<6;i++){
			if(i==0){
				System.out.print(" Nama : ");
			} else if (i==1){
				System.out.print(" Jenis Kelamin : ");
			} else if (i==2){
				System.out.print(" Tanggal Lahir : ");
			} else if (i==3){
				System.out.print(" Email : ");
			} else if (i==4){
				System.out.print(" Level : ");
			} else {
				System.out.print(" NO REK : ");
			}
			System.out.println(dataNasabah[i][b]);
		}
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		cekAksi();
	}


	//FUNGSI RIWAYAT TRANSAKSI
	static void modMutasi(int b){
		clrscr();
		System.out.println("<| ======= [BANK iNi] =======|>");
		System.out.println("         Lihat Riwayat\n");	
		System.out.println(" Saldo Awal  Mutasi  Saldo Akhir   Keterangan Mutasi");
		System.out.println(dataNasabah[8][b]);
		System.out.println("<| ======= [BANK iNi] =======|>");
		cekAksi();
	}
	
	//* CORE ADMIN *//

	//EXIT MENU
	static void keluarAdmin(){
		Scanner sc = new Scanner(System.in);
		String pil;
		System.out.print(" < TEKAN APA SAJA UNTUK KEMBALI KE MENU >");
		pil = sc.nextLine();
		if (pil.equals("y")){
			menuAdmin();
		} else{
			menuAdmin();
		}


	}

	//MENU ADMIN
	static void menuAdmin(){
		Scanner sc = new Scanner(System.in);
		char pil;
		clrscr();
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		System.out.println("           ADMIN MODE\n");
		System.out.println("a> Lihat Data    b> Data Baru");
		System.out.println("c> Hapus Data    d> Edit Data");
		System.out.println("e> LOG OUT       f> SHUTDOWN");
		System.out.println("           ADMIN MODE\n");
		System.out.println("<| ======= [BANK iNi] =======|>\n");

		System.out.print("Pilih Menu >> ");
		pil = sc.next().charAt(0);
		if (pil=='a'){
			adminLihat();
		} else if (pil=='b'){
			adminBaru();
		} else if (pil=='c') {
			adminHapus();
		} else if (pil=='d') {
			adminEdit();
		} else if (pil=='e') {
			authRek();
		} else if (pil=='f') {
			System.exit(0);
		} else {
			System.out.println("<!> == Menu Tidak Ditemukan! == <!>");
			menuAdmin();
		}
	}
	
	//FUNGSI LIHAT DATA NASABAH (ADMIN)
	static void adminLihat(){
		clrscr();
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		for(int i=0;i<6;i++){
			for(int j=0;j<dataNasabah[i].length;j++){
				System.out.println("  "+dataNasabah[i][j]);
			}
		}
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		keluarAdmin();
		
		
	}

	//FUNGSI NASABAH BARU
	static void adminBaru(){
		Scanner sc = new Scanner(System.in);
		int saldo;
		clrscr();
		addNasabah+=1;
		System.out.println("<| ======= [BANK iNi] =======|>\n");
		System.out.println("\n       Tambah Nasabah Baru\n");
		for(int i=0;i<7;i++){
				if(i==0){
					System.out.print(" Masukkan Nama :");
				} else if(i==1){
					System.out.print(" Jenis Kelamin (L/P) :");
				} else if(i==2){
					System.out.print(" Tanggal Lahir (dd-mm-tttt): ");
				} else if(i==3){
					System.out.print(" Masukkan Email :");
				} else if(i==4){
					System.out.print(" Jenis Kartu :");
				} else if(i==5){
					System.out.print(" Masukkan Rekening (10 digit) :");
				} else {
					System.out.print(" Masukkan PIN (6 digit):");
				}
				dataNasabah[i][addNasabah] = sc.nextLine();
				
			}
		System.out.print(" Masukkan Saldo Untuk Rekening " +dataNasabah[5][addNasabah]+" : ");
		saldo = sc.nextInt();
		saldoNasabah[addNasabah] = saldo;
		clrscr();
		System.out.println("<| ========== [BANK iNi] ==========|>\n");
		System.out.println("\n===NASABAH BARU SUKSES DITAMBAHKAN===\n");
		System.out.println(" Nama : "+dataNasabah[0][addNasabah]);
		System.out.println(" Rekening : "+dataNasabah[5][addNasabah]);
		System.out.println(" Jenis Kartu : "+dataNasabah[4][addNasabah]);
		System.out.println(" Saldo : "+saldoNasabah[addNasabah]);
		System.out.println("\n===NASABAH BARU SUKSES DITAMBAHKAN===\n");
		System.out.println("<| ========== [BANK iNi] ==========|>\n");
		keluarAdmin();
		

	}
		

	//FUNGSI HAPUS DATA NASABAH
	static void adminHapus(){
		String rekening,cek;
		int cek2=0;
		char pil;
		Scanner sc = new Scanner(System.in);
		clrscr();
		System.out.println("<| ========== [BANK iNi] ==========|>\n");
		System.out.println("\n         Hapus Data Nasabah\n");
		System.out.print(" Masukkan Rekening >>");
		rekening = sc.nextLine();
		for(int i=0;i<dataNasabah[0].length;i++){
				cek=dataNasabah[5][i];
				if(rekening.equals(cek)){
					cek2=i;
					break;
				} else {
					cek2=-2;
				}
			}
		if (cek2==-2){
			System.out.println("<!> == Rekening Tidak Ditemukan! == <!>");
			menuAdmin();
		} else {
			System.out.println("<|=============================================|>");
			System.out.println(" Rekening Atas Nama = "+dataNasabah[0][cek2]);
			System.out.print(" Hapus Seluruh Data Nasabah Rekening ini ? (Y/N) >> ");
			pil = sc.next().charAt(0);
			if (pil=='y'||pil=='Y'){
				for(int j=0;j<dataNasabah.length;j++){
					for(int i=1;i<dataNasabah[0].length-cek2;i++){
						dataNasabah[j][cek2]=dataNasabah[j][cek2+i];		
					}
				}
				for (int i=1;i<saldoNasabah.length-cek2;i++){
					saldoNasabah[cek2]=saldoNasabah[cek2+i];
				}
				System.out.println("\n Data Nasabah "+rekening+" Telah Dihapus!\n");
				addNasabah-=1;
				keluarAdmin();
			} else {
				menuAdmin();
			}
		}
	}

	//FUNGSI EDIT DATA NASABAH	
	static void adminEdit(){
		String rekening,cek;
		int cek2=0;
		char pil, ed;
		Scanner sc = new Scanner(System.in);
		clrscr();
		System.out.println("<| ========== [BANK iNi] ==========|>\n");
		System.out.println("<|        Edit Data Nasabah        |>\n");
		System.out.println(" Masukkan Rekening >>");
		rekening = sc.nextLine();
		for(int i=0;i<dataNasabah[0].length;i++){
				cek=dataNasabah[5][i];
				if(rekening.equals(cek)){
					cek2=i;
					break;
				} else {
					cek2=-2;
				}
			}
		if(cek2==-2){
			System.out.println("<!> == Rekening Tidak Ditemukan! == <!>");
			menuAdmin();
		} else {
			clrscr();
			System.out.println("<| ========== [BANK iNi] ========== |>\n");
			System.out.println("<|        Edit Data Nasabah         |>\n");
			System.out.println("a> Nama  			b> Jenis Kelamin");
			System.out.println("c> TL    			d> Email");
			System.out.println("e> Jenis Kartu\n");
			System.out.println("<| ========== [BANK iNi] ========== |>\n");
			System.out.print(" Pilih Menu : ");
			pil = sc.next().charAt(0);
			if (pil=='a'){
				fungsiEdit(0,cek2);
				
			}else if (pil=='b'){
				fungsiEdit(1,cek2);
				
			}else if (pil=='c'){
				fungsiEdit(2,cek2);
				
			}else if (pil=='d'){
				fungsiEdit(3,cek2);
				
			}else if (pil=='e'){
				fungsiEdit(4,cek2);
				
			}else{
				System.out.println("<!> === Menu Tidak Ditemukan! === <!>");
				keluarAdmin();
			}
		}
	}

	//EDIT DATA + PREVIEW
	static void fungsiEdit(int a,int b){
		Scanner sc = new Scanner(System.in);
		char ed;
		String cek;
		System.out.println(dataNasabah[a][b]);
		System.out.println("Edit data ? (Y/N)");
		ed = sc.next().charAt(0);
		if (ed=='y'||ed=='Y'){
			System.out.print("Masukkan Data Baru : ");
			dataNasabah[a][b] = sc.next()+sc.nextLine();
			if (ed=='y'){
				clrscr();
				System.out.println(" SUKSES !");
				System.out.println("<| ========== [BANK iNi] ==========|>\n");
				System.out.println(" Preview : "+dataNasabah[a][b]);
				System.out.println("\n<| ========== [BANK iNi] ==========|>\n");
				keluarAdmin();	
			}
			
		} else {
			menuAdmin();
		}

	}	
}
