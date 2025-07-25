package ru.job4j.oop;

public class Cat {
    private String food;

    private String name;

    public void show() {
        System.out.println(this.name + " : " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    void giveNick(String nick) {
        this.name = nick;
    }

    public String sound() {
        String voice = "may-may";
        return voice;
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food.");
        Cat gav = new Cat();
        gav.eat("cutlet");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.show();
    }
}