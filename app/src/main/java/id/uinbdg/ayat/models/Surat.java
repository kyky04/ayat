package id.uinbdg.ayat.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Surat{

	@SerializedName("data")
	private List<DataItemSurat> data;

	public void setData(List<DataItemSurat> data){
		this.data = data;
	}

	public List<DataItemSurat> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Surat{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}