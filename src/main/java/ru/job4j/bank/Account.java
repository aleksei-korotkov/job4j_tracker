package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает работу модели данных, представляющую банковский счёт пользователя
 * @author ALEKSEI KOROTKOV
 * @version 1.0
 * href="{@docRoot}/target/site/apidocs/ru/job4j/bank/Account.html"
 */
public class Account {
    /**
     * Реквизиты банковского счёта, тип String
     */
    private  String requisite;
    /**
     * Сумма на банковском счёте, тип double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}