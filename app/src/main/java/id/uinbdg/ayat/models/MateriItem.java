package id.uinbdg.ayat.models;

import com.google.gson.annotations.SerializedName;

public class MateriItem{

	@SerializedName("id_surah")
	private int idSurah;

	@SerializedName("arti_text")
	private String artiText;

	@SerializedName("id_ayat")
	private int idAyat;

	@SerializedName("id")
	private int id;

	public void setIdSurah(int idSurah){
		this.idSurah = idSurah;
	}

	public int getIdSurah(){
		return idSurah;
	}

	public void setArtiText(String artiText){
		this.artiText = artiText;
	}

	public String getArtiText(){
		return artiText;
	}

	public void setIdAyat(int idAyat){
		this.idAyat = idAyat;
	}

	public int getIdAyat(){
		return idAyat;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"MateriItem{" + 
			"id_surah = '" + idSurah + '\'' + 
			",arti_text = '" + artiText + '\'' + 
			",id_ayat = '" + idAyat + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}