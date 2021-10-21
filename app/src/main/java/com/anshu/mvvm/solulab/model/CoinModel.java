package com.anshu.mvvm.solulab.model;

public class CoinModel {

    private String Name;
    private String image;
    private String url;



    public CoinModel(String name, String image) {
        Name = name;
        this.image = image;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }




}
