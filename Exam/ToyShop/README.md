# Задание 2
 
Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.
Стараемся применять ООП и работу с файлами.
Если какой-то пункт не изучали и не знаете, как сделать, то можете сделать своим способом. Например, у кого в курсе не было ООП, то применяем списки\массивы\словари

# Розыгрыш игрушек в магазине детских товаров

В данной программе реализуется розыгрыш игрушек в магазине детских товаров, с применением ООП и рабатой с файлами формата .csv.

Программа имеет следующую структуру:
* Папка с классами (Classes)
    + Покупатель (Buyer)
    + Игрушка (Toy)
    + Приз (Prize)
    + Вручение приза (PizeDate)
    + Drawing
* Папка с моделями (Models)
    + DrawMod
    + ToyMod
    + BuyerMod
* Папка с визуалами (Views)
    + BuyersView
    + ToysView
* Папка с файлами csv (db)
    + buyers.csv
    + toys.csv
    + prizesended.csv
    + prizestosend.csv
* Меню (Menu)
* Запуск программы (Main)

После запуска программы в консоль выводится сообщение о запуске программы и гланое меню. В главном меню есть нескольких пунктов для выбора:
1. Покупатели.
2. Игрушки.
3. Розыгрыш призов.
4. Выход из программы.

При переходе в меню Покупатели мы можем сделать выбор из:
1. Показать таблицу.
2. Добавить покупателя.
3. Редактировать покупателя.
4. Удалить покупателя.
5. Возвращение в Главное меню.
6. Выход.

При переходе в меню Игрушки мы можем сделать выбор из:
1. Показать таблицу.
2. Добавить игрушку.
3. Редактировать игрушку.
4. Удалить игрушку.
5. Возвращение в Главное меню.
6. Выход.

При переходе в меню Розыгрыш призов мы можем сделать выбор из:
1. Показать таблицу-Разыгранные призы.
2. Разыграть следующий приз.
3. Отметить приз как врученный.
4. Показать таблицу-Врученные призы.
5. Возвращение в Главное меню.
6. Выход.

При выходе из программы в консоль выведется сообщение о завершении программы и приложение завершит работу.