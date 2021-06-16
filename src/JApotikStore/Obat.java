package JApotikStore;
//Tipe Data (Atribut)
public class Obat {
	String KodeObat;
	String NamaObat;
	String Satuan;
	String Kategori;
	String JenisObat;
	String Stok;
	String Keterangan;
//Constructor untuk Obat
	public Obat(String kodeObat, String namaObat, String satuan, String kategori, String jenisObat, String stok, String keterangan) {
		super();
		KodeObat = kodeObat;
		NamaObat = namaObat;
		Satuan = satuan;
		Kategori = kategori;
		JenisObat = jenisObat;
		Stok = stok;
		Keterangan = keterangan;
	}
//Getters n Setters untuk masing-masing atribut obat
	public String getKodeObat() {
		return KodeObat;
	}

	public void setKodeObat(String kodeObat) {
		KodeObat = kodeObat;
	}

	public String getNamaObat() {
		return NamaObat;
	}

	public void setNamaObat(String namaObat) {
		NamaObat = namaObat;
	}

	public String getSatuan() {
		return Satuan;
	}

	public void setSatuan(String satuan) {
		Satuan = satuan;
	}

	public String getKategori() {
		return Kategori;
	}

	public void setKategori(String kategori) {
		Kategori = kategori;
	}

	public String getJenisObat() {
		return JenisObat;
	}

	public void setJenisObat(String jenisObat) {
		JenisObat = jenisObat;
	}

	public String getStok() {
		return Stok;
	}

	public void setStok(String stok) {
		Stok = stok;
	}

	public String getKeterangan() {
		return Keterangan;
	}

	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}

}
