package com.example.malclient.models;

import java.util.List;

public class Data {
    private List<Anime> node;

    private Paging paging;

    public List<Anime> getNode() {
        return node;
    }

    public void setNode(List<Anime> node) {
        this.node = node;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
