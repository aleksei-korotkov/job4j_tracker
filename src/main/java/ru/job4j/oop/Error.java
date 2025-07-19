package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    Error() { }

    Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        Error error1 = new Error(true, 1, "one");
        error1.printInfo();
        Error error2 = new Error(false, 2, "two");
        error2.printInfo();
        Error error3 = new Error(true, 3, "thri");
        error3.printInfo();
        Error error4 = new Error(false, 4, "four");
        error4.printInfo();
        Error error5 = new Error(true, 5, "five");
        error5.printInfo();
    }
}