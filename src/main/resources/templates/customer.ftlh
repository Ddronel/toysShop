<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${customer.first_name}</title>
</head>
<body>
<h3>Имя - ${customer.first_name}</h3>
<h3>Фамилия - ${customer.last_name}</h3>
<h3>Email - ${customer.email}</h3>
<h3>Адрес - ${customer.address}</h3>
<br>
<form method="post" action="/customers/${customer.id}/update">
    <label>
        Имя: <input name="first_name" value="${customer.first_name}">
    </label>
    <label>
        Фамилия: <input name="last_name" value="${customer.last_name}">
    </label>
    <label>
        Email: <input name="email" value="${customer.email}">
    </label>
    <label>
        Адрес: <input name="address" value="${customer.address}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>