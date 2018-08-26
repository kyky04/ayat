package id.uinbdg.ayat.models;

public class ItemMateri {
    int id;
    int id_surah;
    int id_ayat;
    String surah;

    public ItemMateri(int id, int id_surah, int id_ayat, String surah) {
        this.id = id;
        this.id_surah = id_surah;
        this.id_ayat = id_ayat;
        this.surah = surah;
    }

    public ItemMateri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_surah() {
        return id_surah;
    }

    public void setId_surah(int id_surah) {
        this.id_surah = id_surah;
    }

    public int getId_ayat() {
        return id_ayat;
    }

    public void setId_ayat(int id_ayat) {
        this.id_ayat = id_ayat;
    }

    public String getSurah() {
        return surah;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }
}
