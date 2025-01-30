Система управления доступом

Сложный, Управление доступом, Классы, Коллекции, Условия, Цепочка вызовов

Вы работаете над внутрикорпоративной системой доступа пользователей. Реализуйте класс UserManager, который будет управлять доступом пользователей к системе.
У класса должны быть методы для добавления нового пользователя, удаления пользователя, повышения и понижения уровня доступа пользователя, а также для получения списка всех пользователей. Уровни доступа пользователей — это целые числа (0 ≤ x).
Класс UserManager должен поддерживать следующие методы, которые должны быть цепочками (кроме get_users):
— add_user — добавляет нового пользователя с указанным уровнем доступа или уровнем доступа по умолчанию, равным 1;
— remove_user — удаляет пользователя;
— promote — увеличивает уровень доступа пользователя на 1;
— demote — уменьшает уровень доступа на 1, если уровень доступа больше 0. Иначе ничего не происходит.
— get_users — вернет список всех пользователей с их текущим уровнем доступа.

Формат ввода
Несколько строк, состоящих из команд add_user, remove_user, promote, demote, get_users. Входные данные гарантированно завершаются командой get_users.

Формат вывода
Несколько строк, в которой может быть один из вариантов:
— Пользователи с уровнем доступа, при этом исходный порядок пользователей сохраняется;
— «Не найдено», если пользователей в списке не осталось.

Пример 1
Входные данные:
add_user Alice 4
add_user Bob 3
add_user Charlie 2
get_users
Выходные данные:
Alice: 4
Bob: 3
Charlie: 2

Пример 2
Входные данные:
add_user Alice 1
add_user Bob 3
add_user Charlie 3
promote Alice
promote Alice
demote Alice
get_users
Выходные данные:
Alice: 2
Bob: 3
Charlie: 3

Пример 3
Входные данные:
add_user Bob 3
add_user Charlie 2
remove_user Bob
remove_user Charlie
get_users
Выходные данные:
Не найдено

Реализовать следующую структуру:
import java.util.ArrayList;
import java.util.List;

public class CommandLineProcessor {
    private UserManager userManager = new UserManager();

    /**
     * Обработка одной строки.
     * @param commandLine строка команды. Например: "add_user Alice 4". Другой пример: "get_users"
     * @return вывод команды, или null если команда возвращает строку
     */
    public String processInput(String commandLine) {
        // Ваш код
        return null;
    }
}

class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public UserManager addUser(String name, int accessLevel) {
        // Ваш код
        return this;
    }

    public UserManager addUser(String name) {
        // Ваш код
        return this;
    }

    public UserManager removeUser(String name) {
        // Ваш код
        return this;
    }

    public UserManager promote(String name) {
        // Ваш код
        return this;
    }

    public UserManager demote(String name) {
        // Ваш код
        return this;
    }

    public String getUsers() {
        // Ваш код
        return "";
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
}