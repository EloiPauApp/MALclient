package com.example.malclient.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Anime implements Parcelable {
    private int mal_id;
    private String url;
    private String image_url;
    private String title;
    private boolean airing;
    private String synopsis;
    private String type;
    private int episodes;
    private double score;
    private String start_date;
    private String end_date;
    private String rated;
    private int nota;
    private int estat;

    public Anime() {
    }

    protected Anime(Parcel in) {
        mal_id = in.readInt();
        url = in.readString();
        image_url = in.readString();
        title = in.readString();
        airing = in.readByte() != 0;
        synopsis = in.readString();
        type = in.readString();
        episodes = in.readInt();
        score = in.readDouble();
        start_date = in.readString();
        end_date = in.readString();
        rated = in.readString();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public Anime(String toString, String toString1, String toString2, int selectedItemPosition, int i) {
    }

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public int getEstat() {
        return estat;
    }

    public void setEstat(int estat) {
        this.estat = estat;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", image_url='" + image_url + '\'' +
                ", title='" + title + '\'' +
                ", airing=" + airing +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", score=" + score +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", rated='" + rated + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mal_id);
        dest.writeString(url);
        dest.writeString(image_url);
        dest.writeString(title);
        dest.writeBoolean(airing);
        dest.writeString(synopsis);
        dest.writeString(type);
        dest.writeInt(episodes);
        dest.writeDouble(score);
        dest.writeString(start_date);
        dest.writeString(end_date);
        dest.writeString(rated);

    }
}
