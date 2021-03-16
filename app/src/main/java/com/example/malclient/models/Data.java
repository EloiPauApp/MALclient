package com.example.malclient.models;

import java.util.List;

public class Data {
    private String requested_hash;
    private boolean requested_cached;
    private int requested_cache_expiry;
    private List<Anime> results;
    private List<Anime> top;

    public List<Anime> getTop() {
        return top;
    }

    public void setTop(List<Anime> top) {
        this.top = top;
    }

    public String getRequested_hash() {
        return requested_hash;
    }

    public void setRequested_hash(String requested_hash) {
        this.requested_hash = requested_hash;
    }

    public boolean isRequested_cached() {
        return requested_cached;
    }

    public void setRequested_cached(boolean requested_cached) {
        this.requested_cached = requested_cached;
    }

    public int getRequested_cache_expiry() {
        return requested_cache_expiry;
    }

    public void setRequested_cache_expiry(int requested_cache_expiry) {
        this.requested_cache_expiry = requested_cache_expiry;
    }

    public List<Anime> getResults() {
        return results;
    }

    public void setResults(List<Anime> results) {
        this.results = results;
    }
}
