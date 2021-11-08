package com.example.th05;

public class Dish {
    String name;
    int pic;
    Boolean promotion;

    Dish(String name, int pic, Boolean discount)
    {
        this.name = name;
        this.pic = pic;
        this.promotion = discount;
    }

    public String getName() {
        return name;
    }

    public int getPic() { return pic; }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isPromotion()
    {
        return promotion;
    }

}
