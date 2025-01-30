package org.example;

import java.util.*;

public class CommandLineProcessor {
    private UserManager userManager = new UserManager();

    /**
     * Обработка одной строки.
     * @param commandLine строка команды. Например: "add_user Alice 4". Другой пример: "get_users"
     * @return вывод команды, или null если команда возвращает строку
     */
    public String processInput(String commandLine) {
        String[] command = commandLine.split(" ");
        switch (command[0]) {
            case "add_user":
                if (command.length == 2) { userManager.addUser(command[1]); }
                if (command.length == 3) { userManager.addUser(command[1], Integer.parseInt(command[2])); }
                break;
            case "remove_user":
                userManager.removeUser(command[1]); break;
            case "promote":
                userManager.promote(command[1]); break;
            case "demote":
                userManager.demote(command[1]); break;
            case "get_users":
                return userManager.getUsers();
        }

        return "";
    }
}

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public UserManager addUser(String name, int accessLevel) {
        users.add(new User(name, accessLevel));
        return this;
    }

    public UserManager addUser(String name) {
        users.add(new User(name, 1));
        return this;
    }

    public UserManager removeUser(String name) {
        users.removeIf(user -> user.getName().equals(name));
        return this;
    }

    public UserManager promote(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                user.setAccessLevel(user.getAccessLevel() + 1);
            }
        }
        return this;
    }

    public UserManager demote(String name) {
        for (User user : users) {
            int level = user.getAccessLevel();
            if (user.getName().equals(name) && level > 0) {
                user.setAccessLevel(level - 1);
            }
        }
        return this;
    }

    public String getUsers() {
        String result = "";
        for (User user : users) {
            result += user.toString() + "\n";
        }
        return result == "" ? "Не найдено" : result.trim();
    }
}

class User {
    private String name;
    private int accessLevel;

    public User(String name, int accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getName() {
        return name;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return name + ": " + accessLevel;
    }
}