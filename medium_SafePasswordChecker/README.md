Только безопасные пароли
Средний Обработка текста Условия Циклы Списки

Вы разрабатываете программу для проверки безопасности паролей. Ваша задача - проверить набор паролей и определить, какие из них безопасны. Пароль считается таковым, если он удовлетворяет пяти условиям:
1. Содержит хотя бы одну заглавную букву;
2. Содержит хотя бы одну строчную букву;
3. Содержит хотя бы одну цифру;
4. Содержит хотя бы один специальные символ (допустимый набор символов: !@#$%^&*()-+);
5. Длина пароля больше или равна 8 символам.
Реализуйте метод, который принимает на вход один пароль и проверяет его на соответствие условиям. Проверьте каждый пароль в наборе с помощью этого метода и верните только безопасные пароли.

Формат ввода
Одна строка, в которой чередуются пароли, разделенные пробелами. Длина строки - не более 100 символов.

Формат вывода
Одна строка, в которой содержатся только безопасные пароли, разделенные пробелами. Выводите пароли в том порядке, в котором они были даны на вход. Если подходящих паролей нет, выводите "Не найдено" (без кавычек).

Пример 1
Входные данные: Password1 Pass@word 12345 pass!word Passw@rd Password1!
Выходные данные: Password1!

Пример 2
Входные данные: Password1 Pass@word 12345 pass!word
Выходные данные: Не найдено