<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Игрушки</title>
</head>
<body>
<h1>Добавления игрушек</h1>
<form method="post" action="/toys">
    <label>Характеристика
        <input name="description" placeholder="Описание">
    </label>
    <label>Цена
        <input name="cost" placeholder="Цена">
    </label>
    <label>Размер
        <input name="size" placeholder="Размер">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Характеристика</th>
        <th>Цена</th>
        <th>Размер</th>
        <th>Удалить</th>
        <th>Действия</th>
    </tr>
    <#list toys as toy>
        <tr>
            <td>${toy.id}</td>
            <td>${toy.description}</td>
            <td>${toy.cost}</td>
            <td>${toy.size}</td>
            <td>
                <form method="post" action="/toys/${toy.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <a href="/toys/${toy.id}">Изменить..</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>