<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ваши покупатели</title>
</head>
<body>
<h1>Покупатели текущего продавца</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Email</th>
        <th>Адрес</th>
    </tr>
    <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.first_name}</td>
            <td>${customer.last_name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
        </tr>
    </#list>
</table>
<h2>Свободные покупатели..</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Email</th>
        <th>Адрес</th>
        <th>Действие</th>
    </tr>
    <#list unCustomers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.first_name}</td>
            <td>${customer.last_name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <form method="post" action="/sellers/${sellerId}/customers">
                    <input name="customerId" type="hidden" value="${customer.id}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>