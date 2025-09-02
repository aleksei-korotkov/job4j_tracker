package ru.job4j.polymorphism;

public class Bus implements Transport {
    private int passengersCount;
    private int fuelCost;

    @Override
    public void move() {
        System.out.println("Выполняется метод Bus.move()");
    }

    @Override
    public void passengers(int count) {
        passengersCount = count;
    }

    @Override
    public int refuel(int fuel) {
        return fuelCost * fuel;
    }
}