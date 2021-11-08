package com.example.th05;

public class ItemThumbnail {
    String _name;
    int _img;

    public ItemThumbnail(String Name, int Img) {
        _name = Name;
        _img = Img;
    }

    public String getName() {
        return _name;
    }

    public int getImg() {
        return _img;
    }

}
