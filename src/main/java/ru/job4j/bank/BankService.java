package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу модели данных банковского сервиса
 * @author ALEKSEI KOROTKOV
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами,
     * хранение осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет, если такой клиент в системе, если нет, то добавляет его с пустым списком счетов
     * @param user клиент банка который добавляется с систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет клиента банка из системы, если такой существует,
     * клиент опредеяется по уникальному номеру паспорта
     * @param passport номер паспорта пользователя которого нужно удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Если такой клиент есть в системе, то метод добавляет ему банковский счёт,
     * если такого счёта ещё нет у этого клиента
     * @param passport номер паспорта по которому определяется клиент
     * @param account банковсий счёт который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет клиента в системе по номеру паспорта
     * @param passport номер паспорта клиента
     * @return возращает найденного клиента или null, если такого клиента нет
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет клиента по паспорту, если клиент существует, то ищет у него банковский счёт
     * @param passport номер паспорта клиента
     * @param requisite реквизиты баанковского счёта
     * @return возвращает банковский счёт или null если счёт не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод переводит деньги между двумя счетами и возвращает true,
     * если счёт не найден или не хватает денег на счёте sourcePassport(с которого переводят),
     * то метод должен вернуть false
     * @param sourcePassport паспорт клиента с счета которого переводят
     * @param sourceRequisite реквизиты счёта с которого переводят
     * @param destinationPassport паспорт клиента на счёт которого переводят
     * @param destinationRequisite реквизиты счёта на который переводят
     * @param amount сумма перевода
     * @return возрващеает true при успешном переводе или false, если перевод не произошёл
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if ((sourceAccount != null) && (destinationAccount != null) && (sourceAccount.getBalance() >= amount)) {
            findByRequisite(sourcePassport, sourceRequisite).setBalance(sourceAccount.getBalance() - amount);
            findByRequisite(destinationPassport, destinationRequisite).setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}