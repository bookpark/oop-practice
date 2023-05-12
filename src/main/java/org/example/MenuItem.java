package org.example;

public class MenuItem {

    private final String menu;
    private final int price;

    public MenuItem(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }
}
