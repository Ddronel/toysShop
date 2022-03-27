<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${toy.description}</title>
</head>
<body>
<h3>Характеристика - ${toy.description}</h3>
<h3>Цена - ${toy.cost}</h3>
<h3>Размер - ${toy.size}</h3>
<br>
<form method="post" action="/toys/${toy.id}/update">
    <label>
        Характеристика: <input name="description" value="${toy.description}">
    </label>
    <label>
        Цена: <input name="cost" value="${toy.cost}">
    </label>
    <label>
        Размер: <input name="size" value="${toy.size}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>