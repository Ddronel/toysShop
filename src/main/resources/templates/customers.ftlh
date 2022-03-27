<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Покупатели</title>
</head>
<body>
<h1>Добавление покупателя</h1>
<form method="post" action="/customers">
    <label>First name
        <input name="first_name" placeholder="Имя">
    </label>
    <label>Last name
        <input name="last_name" placeholder="Фамилия">
    </label>
    <label>Email
        <input name="email" placeholder="Почта">
    </label>
    <label>Address
        <input name="address" placeholder="Адрес">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Email</th>
        <th>Адрес</th>
        <th>Удалить</th>
        <th>Действия</th>
    </tr>
    <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.first_name}</td>
            <td>${customer.last_name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <form method="post" action="/customers/${customer.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
            </td>
            <td>
                <a href="/customers/${customer.id}">Изменить..</a>
                <a href="/customers/${customer.id}/toys">Перейти к заказам</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>