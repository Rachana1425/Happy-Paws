package com.example.rachana.happypaww;

public class Food {


    private String itemName;
    private String ItemDescription;
    private String itemPrice;
    private int itemImage;

    public Food(String itemName,String itemDescription, String itemPrice, int itemImage) {
        this.itemName = itemName;
        this.ItemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }


    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }


}