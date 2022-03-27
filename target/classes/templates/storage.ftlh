<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Склад №${storage.id}</title>
</head>
<body>
<h3>Вместительность- ${storage.capacity}</h3>
<br>
<form method="post" action="/storages/${storage.id}/update">
    <label>
        Вместительность: <input name="capacity" value="${storage.capacity}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>