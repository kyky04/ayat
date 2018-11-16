package id.uinbdg.ayat.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Arti{

	@SerializedName("materi")
	private List<MateriItem> materi;

	public void setMateri(List<MateriItem> materi){
		this.materi = materi;
	}

	public List<MateriItem> getMateri(){
		return materi;
	}

	@Override
 	public String toString(){
		return 
			"Arti{" + 
			"materi = '" + materi + '\'' + 
			"}";
		}
}