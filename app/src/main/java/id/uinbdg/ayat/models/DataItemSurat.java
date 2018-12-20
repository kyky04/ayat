package id.uinbdg.ayat.models;

import com.google.gson.annotations.SerializedName;

public class DataItemSurat {

	@SerializedName("arti_surat")
	private String artiSurat;

	@SerializedName("nomor_surat")
	private int nomorSurat;

	@SerializedName("nomor_ayat")
	private int nomorAyat;

	@SerializedName("nama_surat")
	private String namaSurat;

	@SerializedName("isi_surat")
	private String isiSurat;

	@SerializedName("arti_ayat")
	private String arti_ayat;

	@SerializedName("file")
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getArti_ayat() {
		return arti_ayat;
	}

	public void setArti_ayat(String arti_ayat) {
		this.arti_ayat = arti_ayat;
	}

	public void setArtiSurat(String artiSurat){
		this.artiSurat = artiSurat;
	}

	public String getArtiSurat(){
		return artiSurat;
	}

	public void setNomorSurat(int nomorSurat){
		this.nomorSurat = nomorSurat;
	}

	public int getNomorSurat(){
		return nomorSurat;
	}

	public void setNomorAyat(int nomorAyat){
		this.nomorAyat = nomorAyat;
	}

	public int getNomorAyat(){
		return nomorAyat;
	}

	public void setNamaSurat(String namaSurat){
		this.namaSurat = namaSurat;
	}

	public String getNamaSurat(){
		return namaSurat;
	}

	public void setIsiSurat(String isiSurat){
		this.isiSurat = isiSurat;
	}

	public String getIsiSurat(){
		return isiSurat;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"arti_surat = '" + artiSurat + '\'' + 
			",nomor_surat = '" + nomorSurat + '\'' + 
			",nomor_ayat = '" + nomorAyat + '\'' + 
			",nama_surat = '" + namaSurat + '\'' + 
			",isi_surat = '" + isiSurat + '\'' + 
			"}";
		}
}