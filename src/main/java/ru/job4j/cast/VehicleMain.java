package ru.job4j.cast;

public class VehicleMain {
        public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle plane3 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle train3 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle bus3 = new Bus();
        Vehicle[] vehicles = {plane1, plane2, plane3, train1, train2, train3, bus1, bus2, bus3};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}