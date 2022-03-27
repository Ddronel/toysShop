<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${seller.first_last_name}</title>
</head>
<body>
<h3>Имя и Фамилия- ${seller.first_last_name}</h3>
<h3>Возраст - ${seller.age}</h3>
<h3>Номер телефона - ${seller.phone_number}</h3>
<br>
<form method="post" action="/sellers/${seller.id}/update">
    <label>
        Имя и Фамилия: <input name="first_last_name" value="${seller.first_last_name}">
    </label>
    <label>
        Возраст: <input name="age" value="${seller.age}">
    </label>
    <label>
        Номер телефона: <input name="phone_number" value="${seller.phone_number}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>