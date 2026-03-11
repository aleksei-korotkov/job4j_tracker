package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
                users.replace(user, accounts);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account result = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                }
            }
        }
        return result;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        User sourceUser = findByPassport(sourcePassport);
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        User destinationUser = findByPassport(destinationPassport);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if ((sourceUser != null) && (sourceAccount != null)
            && (destinationUser != null) && (destinationAccount != null)
            && (sourceAccount.getBalance() >= amount)) {
            double sourceBalance = sourceAccount.getBalance() - amount;
            findByRequisite(sourcePassport, sourceRequisite).setBalance(sourceBalance);
            double destinationBalance = destinationAccount.getBalance() + amount;
            findByRequisite(destinationPassport, destinationRequisite).setBalance(destinationBalance);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}