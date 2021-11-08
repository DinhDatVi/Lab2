package com.example.th05;

public enum Thumbnail {

    Thumbnail1("Thumbnail 1",R.drawable.bundau),
    Thumbnail2("Thumbnail 2", R.drawable.cavienchien),
    Thumbnail3("Thumbnail 3", R.drawable.pho),
    Thumbnail4("Thumbnail 4", R.drawable.pizza);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

}
