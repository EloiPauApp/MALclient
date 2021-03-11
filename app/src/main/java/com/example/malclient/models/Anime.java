package com.example.malclient.models;

import java.util.List;

public class Anime {
    private int id;
    private String title;
    private MainPicture main_picture;
    private String start_date;
    private String end_date;
    private String synopsis;
    private List<Genre> genres;
    private String status;
    private int num_episodes;
    private Season start_season;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MainPicture getMain_picture() {
        return main_picture;
    }

    public void setMain_picture(MainPicture main_picture) {
        this.main_picture = main_picture;
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum_episodes() {
        return num_episodes;
    }

    public void setNum_episodes(int num_episodes) {
        this.num_episodes = num_episodes;
    }

    public Season getStart_season() {
        return start_season;
    }

    public void setStart_season(Season start_season) {
        this.start_season = start_season;
    }
}
