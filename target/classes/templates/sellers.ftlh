<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Продавцы</title>
</head>
<body>
<h1>Добавление продавца</h1>
<form method="post" action="/sellers">
    <label>First_last name
        <input name="first_last_name" placeholder="Имя и Фамилия">
    </label>
    <label>Возраст
        <input name="age" placeholder="Возраст">
    </label>
    <label>Номер телефона
        <input name="phone_number" placeholder="Номер телефона">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Имя и Фамилия</th>
        <th>Возраст</th>
        <th>Номер телефона</th>
        <th>Удалить</th>
        <th>Действия</th>
    </tr>
    <#list sellers as seller>
        <tr>
            <td>${seller.id}</td>
            <td>${seller.first_last_name}</td>
            <td>${seller.age}</td>
            <td>${seller.phone_number}</td>
            <td>
                <form method="post" action="/sellers/${seller.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <a href="/sellers/${seller.id}">Изменить..</a>
                <a href="/sellers/${seller.id}/customers">Перейти к покупателям</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>