<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Склады</title>
</head>
<body>
<h1>Добавление</h1>
<form method="post" action="/storages">
    <label>Вместительность
        <input name="capacity" placeholder="Вместительность">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Вместительность</th>
        <th>Удалить</th>
        <th>Действия</th>
    </tr>
    <#list storages as storage>
        <tr>
            <td>${storage.id}</td>
            <td>${storage.capacity}</td>
            <td>
                <form method="post" action="/storages/${storage.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <a href="/storages/${storage.id}">Изменить..</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>